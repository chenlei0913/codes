package config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Package : com.yixin.com.config
 *
 * @author YixinCapital -- asus
 *         2017/5/7 8:40
 */
@Configuration
public class MyRibbonClientConfiguration {

    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }

}
