package icu.azusachino.apricot.support.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Spring ApplicationRunner
 */
@Order(25)
@Component
public class SpringRunner implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOGGER.info("spring runner is active");
    }

}
