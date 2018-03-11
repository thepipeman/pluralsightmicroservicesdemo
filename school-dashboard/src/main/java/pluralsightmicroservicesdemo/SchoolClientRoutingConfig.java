package pluralsightmicroservicesdemo;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * Created by Aaron Rasing on 3/11/18.
 */
public class SchoolClientRoutingConfig {

    @Autowired
    IClientConfig ribbonClientConfig;

    @Bean
    public IRule ribbonRule(IClientConfig config) {
        return new WeightedResponseTimeRule();
    }


}
