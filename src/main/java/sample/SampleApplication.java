package sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import sun.security.jgss.GSSToken;

@SpringBootApplication(exclude = {MultipartAutoConfiguration.class})
public class SampleApplication {


    public static void main(String[] args) {

        SpringApplication.run(SampleApplication.class, args);
    }
}
