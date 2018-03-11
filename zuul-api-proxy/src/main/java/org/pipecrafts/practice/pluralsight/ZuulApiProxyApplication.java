package org.pipecrafts.practice.pluralsight;

import org.pipecrafts.practice.pluralsight.filters.ProxyFilter;
import org.pipecrafts.practice.pluralsight.filters.StartPreFilter;
import org.pipecrafts.practice.pluralsight.filters.StopPostFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class ZuulApiProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApiProxyApplication.class, args);
	}

	@Bean
	public ProxyFilter proxyFilter() {
		return new ProxyFilter();
	}

	@Bean
	public StartPreFilter startPreFilter() {
		return new StartPreFilter();
	}

	@Bean
	public StopPostFilter stopPostFilter() {
		return new StopPostFilter();
	}
}
