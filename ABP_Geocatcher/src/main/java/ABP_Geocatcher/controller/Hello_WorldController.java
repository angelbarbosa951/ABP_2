package ABP_Geocatcher.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello_WorldController {

    @GetMapping("/helloworld")
    public String helloWorld() {
        return "Hello World";
    }

}
