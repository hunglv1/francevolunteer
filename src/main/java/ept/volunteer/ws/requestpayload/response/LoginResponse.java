package ept.volunteer.ws.requestpayload.response;

public class LoginResponse {

    private String email;
    private String token;
    private String message;
    private String code;

    public LoginResponse(String email, String token, String message, String code) {
        this.email = email;
        this.token = token;
        this.message = message;
        this.code = code;
    }

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
