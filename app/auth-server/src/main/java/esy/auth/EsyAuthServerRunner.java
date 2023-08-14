package esy.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@Slf4j
@SpringBootApplication
public class EsyAuthServerRunner {

    public static void main(final String[] args) {
        final var builder = new SpringApplicationBuilder(EsyAuthServerRunner.class);
        builder.run(args);
    }
}
