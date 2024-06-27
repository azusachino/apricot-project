package icu.azusachino.apricot.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.Map;

/**
 * @author haru
 * @date 2024-06-26 22:12
 */
@Configuration
public class ApricotMainRouter {

    private final Map<String, HandlerFunction<ServerResponse>> routes;

    public ApricotMainRouter(Map<String, HandlerFunction<ServerResponse>> routes) {
        this.routes = routes;
    }

    @Bean
    RouterFunction<ServerResponse> mainRouter() {
        return RouterFunctions.route()
            .nest(RequestPredicates.path("/api/v1"), () -> RouterFunctions.route()
                .GET("/hello", this.routes.get("helloWorld")).build())

            .nest(RequestPredicates.path("/api/v2"), () -> RouterFunctions.route()
                .GET("/echo/{msg}", this.routes.get("echo")).build())
            .build();
    }
}
