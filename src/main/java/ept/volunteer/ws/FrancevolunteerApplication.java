package ept.volunteer.ws;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class FranceVolunteerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FranceVolunteerApplication.class, args);
    }

}
