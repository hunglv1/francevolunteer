package ept.volunteer.ws.responsitory;

import ept.volunteer.ws.models.Event;
import ept.volunteer.ws.models.UserLogin;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryTemplate {

    private final MongoTemplate mongoTemplate;

    public RepositoryTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void updateUserByUserId(Long userId, UserLogin userLogin) {
        Query query = new Query(Criteria.where("userId").is(userId));
        Update update = new Update()
                .set("status", userLogin.getStatus());

        mongoTemplate.updateFirst(query, update, UserLogin.class);
    }

    public void deleteUserByUserId(Long userId) {
        Query query = new Query(Criteria.where("userId").is(userId));
        mongoTemplate.remove(query, UserLogin.class);
    }

    public void deleteEventByEventId(Long eventId) {
        Query query = new Query(Criteria.where("eventId").is(eventId));
        mongoTemplate.remove(query, Event.class);
    }

    public void updateEventByEventId(Long eventId, Event event) {
        Query query = new Query(Criteria.where("eventId").is(eventId));
        Update update = new Update()
                .set("eventName", event.getEventName())
                .set("eventImg", event.getEventImg())
                .set("eventStartTime", event.getEventStartTime())
                .set("eventEndTime", event.getEventEndTime())
                .set("duration", event.getDuration())
                .set("eventMissionType", event.getEventMissionType())
                .set("eventAddress", event.getEventAddress())
                .set("postedDate", event.getPostedDate())
                .set("description", event.getDescription())
                .set("neededProfessionals", event.getNeededProfessionals())
                .set("neededTimes", event.getNeededTimes())
                .set("slotRemaining", event.getSlotRemaining())
                .set("eventPoints", event.getEventPoints())
                .set("eventStatus", event.getEventStatus());

        mongoTemplate.updateFirst(query, update, Event.class);
    }

}
