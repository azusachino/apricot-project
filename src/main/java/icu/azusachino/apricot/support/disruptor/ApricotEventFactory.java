package icu.azusachino.apricot.support.disruptor;

import com.lmax.disruptor.EventFactory;
import icu.azusachino.apricot.models.ApricotEvent;

/**
 * @author haru
 * @date 2024-06-27 21:43
 */
public class ApricotEventFactory implements EventFactory<ApricotEvent> {

    @Override
    public ApricotEvent newInstance() {
        return ApricotEvent.defaultEvent();
    }
}
