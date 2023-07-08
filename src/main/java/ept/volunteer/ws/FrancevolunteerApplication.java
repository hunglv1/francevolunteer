package ept.volunteer.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableEncryptableProperties
//@EnableMongoRepositories(basePackages = "ept.volunteer.ws.responsitory")
public class FranceVolunteerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FranceVolunteerApplication.class, args);
    }

}
