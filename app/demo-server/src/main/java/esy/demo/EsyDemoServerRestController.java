package esy.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static esy.demo.EsyDemoServerConfiguration.API_PATH;

@RestController
@RequestMapping(API_PATH)
public class EsyDemoServerRestController {

    @GetMapping(path = "/demo", produces = MediaType.APPLICATION_JSON_VALUE)
    public String demo() {
        return "{\"title\":\"DEMO\"}";
    }
}
