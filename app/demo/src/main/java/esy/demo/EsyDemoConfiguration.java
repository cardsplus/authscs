package esy.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
public class EsyDemoConfiguration {

    static final String API_PATH = "/api";

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.securityMatcher(antMatcher(API_PATH + "/**"));
        http.authorizeHttpRequests(customizer -> customizer
                .anyRequest()
                .authenticated());
        http.oauth2ResourceServer(customizer -> customizer
                .jwt(Customizer.withDefaults()));
        return http.build();
    }
}
