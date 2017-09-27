package http.payloads.request;

import java.util.HashMap;
import java.util.Map;

public class LoginPayload {

    private String login;

    private String password;

    public LoginPayload(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Map<String, String> build(){
        Map<String, String> p = new HashMap<String, String>();
        p.put("Bugzilla_login", login);
        p.put("Bugzilla_password", password);

        return p;
    }
}
