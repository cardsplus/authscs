package esy.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
public class EsyDemoRunner {

    public static void main(final String[] args) {
        final SpringApplicationBuilder builder = new SpringApplicationBuilder(EsyDemoRunner.class);
        builder.run(args);
    }
}
