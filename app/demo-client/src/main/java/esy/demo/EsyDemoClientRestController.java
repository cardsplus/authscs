package esy.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.clientRegistrationId;

@RestController
@RequestMapping(EsyDemoClientConfiguration.API_PATH + "/demo")
public class EsyDemoClientRestController {

    @Autowired
    private WebClient webClient;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String demo() {
        return this.webClient
                .get()
                .uri("http://demo-server:7071" + EsyDemoClientConfiguration.API_PATH + "/demo")
                .attributes(clientRegistrationId("products-client-client-credentials"))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
