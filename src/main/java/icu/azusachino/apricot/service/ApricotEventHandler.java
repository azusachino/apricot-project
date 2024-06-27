package icu.azusachino.apricot.service;

import com.lmax.disruptor.spring.boot.DisruptorTemplate;
import com.lmax.disruptor.spring.boot.event.DisruptorBindEvent;
import icu.azusachino.apricot.models.ApricotEvent;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * @author haru
 * @since 2024/06/27
 */
@Service
public class ApricotEventHandler implements InitializingBean {

    private final DisruptorTemplate disruptorTemplate;

    public ApricotEventHandler(DisruptorTemplate disruptorTemplate) {
        this.disruptorTemplate = disruptorTemplate;
    }

    @Override
    public void afterPropertiesSet() {
        this.sendEvent();
    }

    public void sendEvent() {
        var evt = new ApricotEvent();
        evt.setId("1");
        evt.setKey("key");
        evt.setValue("value");
        this.disruptorTemplate.publishEvent(new DisruptorBindEvent(evt));
    }
}
