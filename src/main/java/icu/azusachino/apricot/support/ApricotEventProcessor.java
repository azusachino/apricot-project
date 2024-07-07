package icu.azusachino.apricot.support;

import java.util.Objects;
import java.util.concurrent.ThreadFactory;

import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.dsl.Disruptor;

import icu.azusachino.apricot.models.ApricotEvent;

/**
 * @author haru
 * @date 2024-06-26 22:26
 */
@Component
public class ApricotEventProcessor implements InitializingBean, DisposableBean {

    private final EventFactory<ApricotEvent> eventFactory;

    private final ThreadFactory threadFactory;

    private final EventHandler<ApricotEvent> eventHandler;

    private Disruptor<ApricotEvent> disruptor;

    public ApricotEventProcessor(EventFactory<ApricotEvent> eventFactory, ThreadFactory threadFactory,
            EventHandler<ApricotEvent> eventHandler) {
        this.eventFactory = eventFactory;
        this.threadFactory = threadFactory;
        this.eventHandler = eventHandler;
    }

    /**
     * Invoked by the containing {@code BeanFactory} after it has set all bean
     * properties and satisfied {@link BeanFactoryAware},
     * {@code ApplicationContextAware} etc.
     * <p>
     * This method allows the bean instance to perform validation of its overall
     * configuration and final initialization when all bean properties have been
     * set.
     *
     * @throws Exception in the event of misconfiguration (such as failure to set an
     *                   essential property) or if initialization fails for any
     *                   other reason
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        var d = new Disruptor<ApricotEvent>(this.eventFactory, 1024, this.threadFactory);
        this.setDisruptor(disruptor);
        d.handleEventsWith(this.eventHandler);
        d.start();
    }

    @Override
    public void destroy() throws Exception {
        if (Objects.nonNull(this.disruptor)) {
            this.disruptor.shutdown();
        }
    }

    /**
     * @param disruptor the disruptor to set
     */
    public void setDisruptor(Disruptor<ApricotEvent> disruptor) {
        this.disruptor = disruptor;
    }

}
