package esy.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

/**
 * @see <a href="https://www.codeburps.com/post/spring-boot-oauth2-for-server-to-server-security">Securing Server-to-Server Communication with Spring Boot & OAuth2</a>
 * @see <a href="https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/">OAuth 2.0 Resource Server</a>
 * @see <a href="https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/jwt.html">OAuth 2.0 Resource Server JWT</a>
 */
@Configuration
@EnableWebSecurity
public class EsyDemoServerConfiguration {

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

    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        final var filter = new CommonsRequestLoggingFilter();
        filter.setMaxPayloadLength(10000);
        filter.setIncludeClientInfo(true);
        filter.setIncludeQueryString(true);
        filter.setIncludeHeaders(true);
        filter.setIncludePayload(true);
        return filter;
    }
}
