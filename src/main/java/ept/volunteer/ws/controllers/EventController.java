package ept.volunteer.ws.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ept.volunteer.ws.common.CommonUtils;
import ept.volunteer.ws.common.Constant;
import ept.volunteer.ws.models.Event;
import ept.volunteer.ws.requestpayload.response.ResponseData;
import ept.volunteer.ws.responsitory.EventRepository;
import ept.volunteer.ws.responsitory.RepositoryTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/frvol/event")
public class EventController {

    private static final Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    EventRepository eventRepository;

    @Autowired
    RepositoryTemplate repositoryTemplate;

    @PostMapping("/getDetail/v1")
    public ResponseData getEventDetail(@RequestBody String eventId) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        ResponseData responseData = new ResponseData();
        responseData.setCode(Constant.RESPONSE_CODE_200);
        responseData.setMessage(Constant.RESPONSE_MESSAGE_OK);

        try {
            Optional<Event> event = eventRepository.findByEventId(Long.parseLong(eventId));

            if (event.isPresent())
                responseData.setData(objectMapper.writeValueAsString(event.get()));
            else
                responseData.setData(objectMapper.writeValueAsString(Constant.BLANK));
        } catch (Exception e) {
            logger.error("Exception : {}", e.getMessage());
            responseData.setCode(Constant.RESPONSE_CODE_501);
            responseData.setMessage(Constant.RESPONSE_MESSAGE_NOT_OK);
        }

        return responseData;
    }

    @PostMapping("/getList/v1")
    public ResponseData getEventList() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        ResponseData responseData = new ResponseData();
        responseData.setCode(Constant.RESPONSE_CODE_200);
        responseData.setMessage(Constant.RESPONSE_MESSAGE_OK);
        responseData.setData(objectMapper.writeValueAsString(eventRepository.findAll()));
        return responseData;
    }

    @PostMapping("/createEvent/v1")
    public ResponseData createEvent(@RequestBody Event event) {

        ResponseData responseData = new ResponseData();
        responseData.setCode(Constant.RESPONSE_CODE_200);
        responseData.setMessage(Constant.RESPONSE_MESSAGE_OK);

        try {
            event.setEventId(CommonUtils.generateRandomId());
            eventRepository.save(event);
        } catch (Exception e) {
            logger.error("Exception : {}", e.getMessage());
            responseData.setCode(Constant.RESPONSE_CODE_501);
            responseData.setMessage(Constant.RESPONSE_MESSAGE_NOT_OK);
        }

        responseData.setData(Constant.BLANK);
        return responseData;
    }

    @PostMapping("/updateEvent/v1")
    public ResponseData updateEvent(@RequestBody Event event) {

        ResponseData responseData = new ResponseData();
        responseData.setCode(Constant.RESPONSE_CODE_200);
        responseData.setMessage(Constant.RESPONSE_MESSAGE_OK);

        try {
            logger.info("event.getEventId() = " + event.getEventId());
            logger.info(event.toString());
            repositoryTemplate.updateEventByEventId(event.getEventId(), event);
        } catch (Exception e) {
            logger.error("Exception : {}", e.getMessage());
            responseData.setCode(Constant.RESPONSE_CODE_501);
            responseData.setMessage(Constant.RESPONSE_MESSAGE_NOT_OK);
        }

        responseData.setData(Constant.BLANK);
        return responseData;
    }

    @PostMapping("/deleteEvent/v1")
    public ResponseData deleteEvent(@RequestBody String eventId) {

        ResponseData responseData = new ResponseData();
        responseData.setCode(Constant.RESPONSE_CODE_200);
        responseData.setMessage(Constant.RESPONSE_MESSAGE_OK);

        try {
            repositoryTemplate.deleteEventByEventId(Long.parseLong(eventId));
        } catch (Exception e) {
            responseData.setCode(Constant.RESPONSE_CODE_500);
            responseData.setMessage(Constant.RESPONSE_MESSAGE_NOT_OK);
        }

        responseData.setData(Constant.BLANK);
        return responseData;
    }

}
