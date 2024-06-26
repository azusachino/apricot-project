package icu.azusachino.apricot.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author haru
 * @date 2024-06-26 22:12
 */
@Configuration
public class ApricotMainRouter {

    private static final String V1 = "/api/v1";

    @Bean
    RouterFunction<ServerResponse> mainRouter() {
        return RouterFunctions.route()
            .GET(V1 + "/hello", RequestPredicates.accept(MediaType.APPLICATION_JSON), request -> ServerResponse.ok().bodyValue(""))
            .build();
    }
}
