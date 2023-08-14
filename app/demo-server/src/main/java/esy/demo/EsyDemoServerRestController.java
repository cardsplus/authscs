package esy.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EsyDemoServerConfiguration.API_PATH + "/demo")
public class EsyDemoServerRestController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String demo() {
        return "{\"title\":\"DEMO\"}";
    }
}
