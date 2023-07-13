package esy.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@Slf4j
@SpringBootApplication
public class EsyAuthRunner {

    public static void main(final String[] args) {
        final var builder = new SpringApplicationBuilder(EsyAuthRunner.class);
        builder.run(args);
    }
}
