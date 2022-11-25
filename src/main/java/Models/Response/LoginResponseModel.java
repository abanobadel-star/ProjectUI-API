package Models.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponseModel {

    public UserDetails UserDetailsObject;
    public String token;
    public String expiration;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UserDetails {
        public String id;
        public String name;
        public String email;
        public String username;
        public String phoneNumber;
        public String role;
        public float statusId;
        ArrayList<Object> branches = new ArrayList<Object>();
        public boolean isLockedOut;
        public String activeSessionId = null;
        public String rejectReason = null;
        public String rejectURL = null;
        public boolean isPay2;

    }


}
