package RestAssuredAPI;
import Models.Response.GetMerchantInfoResponseModel;
import Models.Response.LoginResponseModel;
import Utils.GetMerchantInfoUtils;
import Utils.LoginUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RestRequestAPI {

    public static Properties prop;
    static String configpath=System.getProperty("user.dir")+"\\src\\test\\java\\configuration\\config.properties"; // to get path for config properties file
    public static String username = "omarfoodics2+test2@gmail.com";
    public static String password = "sk190517225LM@$*";
     LoginResponseModel loginResponseModel;
     GetMerchantInfoResponseModel getMerchantInfoResponseModel;

    static String token = "dd" ;
    public RestRequestAPI() throws IOException {
        prop=new Properties();
        FileInputStream file=new FileInputStream(configpath);
        prop.load(file);
    }

    @Test(priority=1)
    public void Login_User()
    {
        String pathParam= prop.getProperty("Login");
       // body
        JSONObject request=new JSONObject();
        request.put("username",username);
        request.put("password",password);

        RestAssured.baseURI= prop.getProperty("baseURL"); //base url from property file
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type","application/json"); //header
        httpRequest.body(request);  //body of request
        Response response= httpRequest.request(Method.POST, pathParam);
        String responseBody =response.getBody().asString();  //read response as string
        System.out.println("response body is :"+ responseBody); //print response

        //assert on status code
        int statusCode =response.getStatusCode();
        System.out.println("status code :"+ statusCode);
        Assert.assertEquals(statusCode, 200);

        //assert name
        String name=response.jsonPath().get("userDetails.name");
        System.out.println("Name :"+name);
        Assert.assertEquals(name, "cucee");

        //assert username
        String Username=response.jsonPath().get("userDetails.username");
        System.out.println("body _post :"+Username);
        Assert.assertEquals(Username, "omarfoodics2+test2@gmail.com");

        //assert userid
        String user_id=response.jsonPath().get("userDetails.id");
        System.out.println("user id :"+user_id);
        Assert.assertEquals(user_id,"634790bd-f1e4-416c-a720-f4d0d8d8ece5");
        token =response.jsonPath().get("token");
    }
    @Test(priority = 2)
    public void getMerchantInfo()
    {
        String pathParam = prop.getProperty("Merchant_info");
        RestAssured.baseURI = prop.getProperty("baseURL");
        RequestSpecification httpRequest =RestAssured.given();
        httpRequest.header("Authorization", token);
        Response response = httpRequest.request(Method.GET, pathParam);
        String responseBody = response.getBody().asString();  //read response as string
        System.out.println("response body is :"+ responseBody);
        //assert status code
        int statusCode = response.getStatusCode();
        System.out.println("status code :"+ statusCode);
        Assert.assertEquals(statusCode, 200);
         //assert merchantId
        int merchantId = response.jsonPath().get("merchantId");
        System.out.println("merchantId :"+merchantId);
        Assert.assertEquals(merchantId, 712);
        //assert merchantId
        String merchant_name = response.jsonPath().get("name");
        System.out.println("merchant_name :"+merchant_name);
        Assert.assertEquals(merchant_name, "Foodics Misc Charges Collection Account");

    }

     //                      =========== using pojo model ===========================
    @Test
    public void userLogin() throws JsonProcessingException {
        loginResponseModel = LoginUtils.login(username,password);
        Assert.assertTrue(loginResponseModel.UserDetailsObject.id.equals("634790bd-f1e4-416c-a720-f4d0d8d8ece5"));
        Assert.assertTrue(loginResponseModel.UserDetailsObject.email.equals(username));
    }
    @Test
    public void getMerchantInfo2() {
        getMerchantInfoResponseModel = GetMerchantInfoUtils.getMerchantInfo();
        Assert.assertTrue(getMerchantInfoResponseModel.name.equals("Foodics Misc Charges Collection Account"));
    }
}
