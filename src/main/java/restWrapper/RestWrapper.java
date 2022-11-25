package restWrapper;

import java.util.Map;
import java.util.Properties;
import static Helpers.PropertiesLoader.readPropertyFile;
import static io.restassured.RestAssured.given;

public class RestWrapper {

    private static final Properties urlProps = readPropertyFile("config/api.properties");
    public static final String Login_endPoint =System.getProperty("Login", urlProps.getProperty("Login"));
    public static final String base_url =System.getProperty("baseURL", urlProps.getProperty("baseURL"));
    public static final String Merchant_info_endPoint = System.getProperty("Merchant_info", urlProps.getProperty("Merchant_info"));

    public static <T> T restPost(String endPoint , Map<String ,String> headers, Object bodyData, Class<T> responseClass) {
        return given()
            .relaxedHTTPSValidation()
            .headers(headers)
            .body(bodyData)
            .when()
            .post(System.getProperty("baseURL",urlProps.getProperty("baseURL")).concat(endPoint))
            .then()
            .extract()
            .as(responseClass);
    }
    public static <T> T restGet(String endPoint , Map<String ,String> headers, Class<T> responseClass) {
        return given()
            .relaxedHTTPSValidation()
            .headers(headers)
            .when()
            .get(System.getProperty("baseURL",urlProps.getProperty("baseURL")).concat(endPoint))
            .then()
            .extract()
            .as(responseClass);
    }
}
