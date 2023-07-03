package ept.volunteer.ws.requestpayload.request;

import javax.validation.constraints.NotBlank;

public class UserRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String token;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
