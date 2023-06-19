package ept.volunteer.ws.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ept.volunteer.ws.common.Constant;
import ept.volunteer.ws.requestpayload.response.ResponseData;
import ept.volunteer.ws.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/frvol/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/userList")
    public ResponseData getUserList() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        ResponseData responseData = new ResponseData();
        responseData.setCode(Constant.RESPONSE_CODE_200);
        responseData.setMessage(Constant.RESPONSE_MESSAGE_OK);
        responseData.setData(objectMapper.writeValueAsString(userService.findAllUsers()));
        return responseData;

    }
}
