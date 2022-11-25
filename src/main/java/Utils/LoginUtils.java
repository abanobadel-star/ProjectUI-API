package Utils;

import Models.Response.LoginResponseModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import objects.LoginObject;
import restWrapper.Headers;
import restWrapper.RestWrapper;

import static restWrapper.RestWrapper.Login_endPoint;

public class LoginUtils {

    public static LoginResponseModel login(String username , String password) throws JsonProcessingException {
        return RestWrapper.restPost(Login_endPoint, Headers.GeneralHeader(), LoginObject.login(username,password), LoginResponseModel.class);
    }
}
