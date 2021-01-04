package sample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    private Class<? extends HelloController> className = this.getClass();

    @RequestMapping(value = "/")
    public String hello() {

        log.info(className + " INFO LOG TEST");
        log.debug(className + " DEBUG LOG TEST");
        log.warn(className + " WARN LOG TEST");
        log.error(className + " ERROR LOG TEST");

        return "Hello World";
    }


}
