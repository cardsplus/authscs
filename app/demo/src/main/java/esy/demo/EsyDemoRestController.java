package esy.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EsyDemoConfiguration.API_PATH + "/demo")
public class EsyDemoRestController {

    @GetMapping(produces = "text/plain")
    public String demo() {
        return "DEMO";
    }
}
