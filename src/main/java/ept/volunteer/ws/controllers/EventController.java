package ept.volunteer.ws.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ept.volunteer.ws.common.Constant;
import ept.volunteer.ws.models.Event;
import ept.volunteer.ws.models.PayloadRequest;
import ept.volunteer.ws.models.Volunteer;
import ept.volunteer.ws.requestpayload.response.ResponseData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/frvol/event")
public class EventController {

    @PostMapping("/getDetail/v1")
    public ResponseData getEventDetail(@RequestBody PayloadRequest payloadRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        ResponseData responseData = new ResponseData();

        Event event = new Event();
        event.setId(1L);
        event.setEventName("2024 Olympic Game");
        event.setEventImg("");
        event.setEventStartTime("01/03/2024");
        event.setEventEndTime("30/05/2024");
        event.setDuration("30");
        event.setEventMissionType("Sport");
        event.setEventAddress("93200 Saint-Denis");
        event.setPostedDate("01/01/2024");
        event.setDescription("They are the ones who gave us their first passion, the first contacts were made by volunteers. (...) They play a leading role in French Sport, they also play a leading role in the organisation of the Games. They will be the face of the Paris 2024 Olympics");
        event.setNeededProfessionals("Medication skills, Sport skills, English...");
        event.setNeededTimes("La semaine en journée");
        event.setSlotRemaining("10");
        event.setEventPoints(50);
        event.setEventStatus("Open");

        responseData.setCode(Constant.RESPONSE_CODE_200);
        responseData.setMessage(Constant.RESPONSE_MESSAGE_OK);
        responseData.setData(objectMapper.writeValueAsString(event));
        return responseData;
    }

    @PostMapping("/getList/v1")
    public ResponseData getEventList(@RequestBody PayloadRequest payloadRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        ResponseData responseData = new ResponseData();
        List<Event> eventList = new ArrayList<>();

        Event event = new Event();
        event.setId(1L);
        event.setEventName("2024 Olympic Game");
        event.setEventImg("");
        event.setEventStartTime("01/03/2024");
        event.setEventEndTime("30/05/2024");
        event.setDuration("30");
        event.setEventMissionType("Sport");
        event.setEventAddress("93200 Saint-Denis");
        event.setPostedDate("01/01/2024");
        event.setDescription("They are the ones who gave us their first passion, the first contacts were made by volunteers. (...) They play a leading role in French Sport, they also play a leading role in the organisation of the Games. They will be the face of the Paris 2024 Olympics");
        event.setNeededProfessionals("Medication skills, Sport skills, English...");
        event.setNeededTimes("La semaine en journée");
        event.setSlotRemaining("10");
        event.setEventPoints(50);
        event.setEventStatus("Open");

        Event event2 = new Event();
        event2.setId(2L);
        event2.setEventName("2024 Olympic Game");
        event2.setEventImg("");
        event2.setEventStartTime("01/03/2024");
        event2.setEventEndTime("30/05/2024");
        event2.setDuration("30");
        event2.setEventMissionType("Sport");
        event2.setEventAddress("93200 Saint-Denis");
        event2.setPostedDate("01/01/2024");
        event2.setDescription("They are the ones who gave us their first passion, the first contacts were made by volunteers. (...) They play a leading role in French Sport, they also play a leading role in the organisation of the Games. They will be the face of the Paris 2024 Olympics");
        event2.setNeededProfessionals("Medication skills, Sport skills, English...");
        event2.setNeededTimes("La semaine en journée");
        event2.setSlotRemaining("10");
        event2.setEventPoints(50);
        event2.setEventStatus("Open");

        eventList.add(event);
        eventList.add(event2);

        responseData.setCode(Constant.RESPONSE_CODE_200);
        responseData.setMessage(Constant.RESPONSE_MESSAGE_OK);
        responseData.setData(objectMapper.writeValueAsString(eventList));
        return responseData;
    }

}
