package restWrapper;


import java.util.HashMap;
import java.util.Map;

public class Headers {

    public static Map<String, String> GeneralHeader(){
        Map<String,String> params = new HashMap<>();
        params.put("Content-Type","application/json");
        return params;
    }
    public static Map<String, String> HeaderWithToken(){
        Map<String,String> params = new HashMap<>();
        params.put("Content-Type","application/json");
        params.put("Authorization", "token");
        return params;
    }
}
