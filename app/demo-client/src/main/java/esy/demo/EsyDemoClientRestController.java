package esy.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import static esy.demo.EsyDemoClientConfiguration.API_PATH;
import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.clientRegistrationId;

@RestController
@RequestMapping(API_PATH)
public class EsyDemoClientRestController {

    @Value("${oauth2.server-uri}")
    private String apiServer;

    @Autowired
    private WebClient webClient;

    @GetMapping(path = "/demo", produces = MediaType.APPLICATION_JSON_VALUE)
    public String demo() {
        return this.webClient
                .get()
                .uri(apiServer + "/demo")
                .attributes(clientRegistrationId("authscs-client-credentials"))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
