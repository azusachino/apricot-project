package icu.azusachino.apricot.service;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.Map;

/**
 * @author haru
 * @since 2024/06/27
 */
@Service
public class ApricotMainService {

    @Bean
    HandlerFunction<ServerResponse> helloWorld() {
        return request -> ServerResponse.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE)
            .bodyValue("hello world");
    }

    @Bean
    HandlerFunction<ServerResponse> echo() {
        return request -> {
            var msg = request.pathVariable("msg");
            return ServerResponse.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(Map.of("msg", msg));
        };
    }

}
