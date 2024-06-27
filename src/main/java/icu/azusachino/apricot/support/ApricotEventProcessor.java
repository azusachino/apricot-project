package icu.azusachino.apricot.support;

import com.lmax.disruptor.EventHandler;
import icu.azusachino.apricot.models.ApricotEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author haru
 * @date 2024-06-26 22:26
 */
@Component
public class ApricotEventProcessor implements EventHandler<ApricotEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApricotEventProcessor.class);

    @Override
    public void onEvent(ApricotEvent apricotEvent, long l, boolean b) {
        LOGGER.info("received event: {}", apricotEvent);
    }
}
