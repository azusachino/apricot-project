package icu.azusachino.apricot.config;

import java.util.concurrent.ThreadFactory;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.WaitStrategy;

import icu.azusachino.apricot.models.ApricotEvent;
import icu.azusachino.apricot.support.disruptor.ApricotEventFactory;
import io.netty.util.concurrent.DefaultThreadFactory;

/**
 * @author haru
 * @since 2024/06/27
 */
@Configuration
public class MainCfg {

    @Bean
    @ConditionalOnMissingBean
    WaitStrategy waitStrategy() {
        return new BlockingWaitStrategy();
    }

    @Bean
    @ConditionalOnMissingBean
    ThreadFactory threadFactory() {
        return new DefaultThreadFactory("main-tp");
    }

    @Bean
    @ConditionalOnMissingBean
    EventFactory<ApricotEvent> eventFactory() {
        return new ApricotEventFactory();
    }
}
