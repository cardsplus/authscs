package esy.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@Slf4j
@SpringBootApplication
public class EsyDemoServerRunner {

    public static void main(final String[] args) {
        final SpringApplicationBuilder builder = new SpringApplicationBuilder(EsyDemoServerRunner.class);
        builder.run(args);
    }
}
