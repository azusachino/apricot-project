package icu.azusachino.apricot.support.disruptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmax.disruptor.EventHandler;

import icu.azusachino.apricot.models.ApricotEvent;

/**
 * Event Handler
 */
public class ApricotEventHandler implements EventHandler<ApricotEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApricotEventHandler.class);

    @Override
    public void onEvent(ApricotEvent event, long sequence, boolean endOfBatch) throws Exception {
        LOGGER.info("[ApricotEventHandler] event: {}, seq: {}, endOfBatch: {}", event, sequence, endOfBatch);
    }

}
