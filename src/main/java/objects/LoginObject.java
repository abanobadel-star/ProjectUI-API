package objects;

import Helpers.CleanObject;
import Models.Request.LoginRequestModel;
import com.fasterxml.jackson.core.JsonProcessingException;

public class LoginObject {

    public static String login(String username, String password) throws JsonProcessingException {
        LoginRequestModel loginRequestModel = new LoginRequestModel();
        loginRequestModel.username = username;
        loginRequestModel.password = password;
        return CleanObject.getCleanObject(loginRequestModel);
    }
}
