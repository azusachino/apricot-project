package icu.azusachino.apricot.config;

import com.lmax.disruptor.spring.boot.DisruptorAutoConfiguration;
import com.lmax.disruptor.spring.boot.RingBufferAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author haru
 * @since 2024/06/27
 */
@Configuration
@Import({DisruptorAutoConfiguration.class, RingBufferAutoConfiguration.class})
public class MainCfg {
}
