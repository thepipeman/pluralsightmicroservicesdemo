package org.pipecrafts.practice.pluralsight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PluralsightEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PluralsightEurekaServerApplication.class, args);
	}
}
