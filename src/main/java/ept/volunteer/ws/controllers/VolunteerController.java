package ept.volunteer.ws.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ept.volunteer.ws.common.Constant;
import ept.volunteer.ws.models.PayloadRequest;
import ept.volunteer.ws.models.Volunteer;
import ept.volunteer.ws.requestpayload.response.ResponseData;
import ept.volunteer.ws.responsitory.UserLoginRepository;
import ept.volunteer.ws.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/frvol/volunteer")
public class VolunteerController {

    @Autowired
    UserLoginRepository userRepository;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/profile/v1")
    public ResponseData getVolunteerProfile(@RequestBody PayloadRequest payloadRequest) throws JsonProcessingException {

        System.out.println(payloadRequest.toString());

        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        ResponseData responseData = new ResponseData();

        Volunteer volunteer = new Volunteer();
        volunteer.setId(1L);
        volunteer.setGender("Male");
        volunteer.setFirstName("Ken");
        volunteer.setLastName("LE");
        volunteer.setDob("21/05/1989");
        volunteer.setAddress("5 Passage Carnot");
        volunteer.setPostalCode("94270");
        volunteer.setCity("Kremlin Becettre");
        volunteer.setCountry("France");
        volunteer.setPhoneNumber("1234567890");
        volunteer.setActionArea("Olympic Paris 2024");
        volunteer.setMissionType("Literacy-Training-School support");
        volunteer.setAvailability("The week by day");
        volunteer.setProfessionalSituation("Job seeker");
        volunteer.setProfessionalDetail("");
        volunteer.setPossibaleDisplacement("0-50km");
        volunteer.setTravelType("By car");
        volunteer.setEmail("fake@gmail.com");
        volunteer.setPassword("");
        volunteer.setPrivacyRequiredRule(1);
        volunteer.setPrivacyGetPromotion(0);

        responseData.setCode(Constant.RESPONSE_CODE_200);
        responseData.setMessage(Constant.RESPONSE_MESSAGE_OK);
        responseData.setData(objectMapper.writeValueAsString(volunteer));
        return responseData;
    }

    @PostMapping("/getList/v1")
    public ResponseData getVolunteerList(@RequestBody PayloadRequest payloadRequest) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        ResponseData responseData = new ResponseData();
        List<Volunteer> volunteerList = new ArrayList<>();

        Volunteer volunteer = new Volunteer();
        volunteer.setId(1L);
        volunteer.setGender("Male");
        volunteer.setFirstName("Ken");
        volunteer.setLastName("LE");
        volunteer.setDob("21/05/1989");
        volunteer.setAddress("5 Passage Carnot");
        volunteer.setPostalCode("94270");
        volunteer.setCity("Kremlin Becettre");
        volunteer.setCountry("France");
        volunteer.setPhoneNumber("1234567890");
        volunteer.setActionArea("Olympic Paris 2024");
        volunteer.setMissionType("Literacy-Training-School support");
        volunteer.setAvailability("The week by day");
        volunteer.setProfessionalSituation("Job seeker");
        volunteer.setProfessionalDetail("");
        volunteer.setPossibaleDisplacement("0-50km");
        volunteer.setTravelType("By car");
        volunteer.setEmail("fake@gmail.com");
        volunteer.setPassword("");
        volunteer.setPrivacyRequiredRule(1);
        volunteer.setPrivacyGetPromotion(0);

        Volunteer volunteer2 = new Volunteer();
        volunteer2.setId(2L);
        volunteer2.setGender("Male");
        volunteer2.setFirstName("Hung");
        volunteer2.setLastName("LE");
        volunteer2.setDob("21/05/1989");
        volunteer2.setAddress("10 Passage Carnot");
        volunteer2.setPostalCode("94270");
        volunteer2.setCity("Kremlin Becettre");
        volunteer2.setCountry("France");
        volunteer2.setPhoneNumber("1234567890");
        volunteer2.setActionArea("Olympic Paris 2024");
        volunteer2.setMissionType("Literacy-Training-School support");
        volunteer2.setAvailability("The week by day");
        volunteer2.setProfessionalSituation("Job seeker");
        volunteer2.setProfessionalDetail("");
        volunteer2.setPossibaleDisplacement("0-50km");
        volunteer2.setTravelType("By car");
        volunteer2.setEmail("fake@gmail.com");
        volunteer2.setPassword("");
        volunteer2.setPrivacyRequiredRule(1);
        volunteer2.setPrivacyGetPromotion(1);

        volunteerList.add(volunteer);
        volunteerList.add(volunteer2);

        responseData.setCode(Constant.RESPONSE_CODE_200);
        responseData.setMessage(Constant.RESPONSE_MESSAGE_OK);
        responseData.setData(objectMapper.writeValueAsString(volunteerList));
        return responseData;
    }

}
