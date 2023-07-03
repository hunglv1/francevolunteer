package ept.volunteer.ws.common;

public class Constant {

    private Constant(){}

    public static final String ROLE_USER = "user";
    public static final String BLANK = "";


    //RESPONSE messages, code -> START
    public static final String RESPONSE_MESSAGE_OK = "Successful";
    public static final String RESPONSE_MESSAGE_NOT_OK = "Unsuccessful";
    public static final String RESPONSE_MESSAGE_UNAUTHORIZED = "Unauthorized";
    public static final String RESPONSE_MESSAGE_SIGNIN_NOT_OK = "Email or password is incorrect";
    public static final String RESPONSE_MESSAGE_EMAIL_EXIST = "Email is already in use or incorrect";
    public static final String RESPONSE_CODE_200 = "200";
    public static final String RESPONSE_CODE_401 = "401";
    public static final String RESPONSE_CODE_400 = "400";
    public static final String RESPONSE_CODE_501 = "501";
    //RESPONSE messages, code -> END


    //JASYPT configurations -> START
    public static final String JASYPT_ENCRYPTOR_PASSWORD = "frvolunteer";
    public static final String JASYPT_ENCRYPTOR_ALGORYTHM = "PBEWithMD5AndDES";
    //JASYPT configurations -> END

}
