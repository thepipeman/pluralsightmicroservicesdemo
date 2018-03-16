package org.pipecrafts.practice.pluralsight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(Sink.class)
//@EnableBinding(Processor.class)
@SpringBootApplication
public class SchoolStreamIntakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolStreamIntakeApplication.class, args);
	}

	@StreamListener(value = Sink.INPUT, condition = "headers['speed'] > 40")
//	@ServiceActivator(inputChannel = Sink.INPUT)
//	@StreamListener(Processor.INPUT)
//	@SendTo(Processor.OUTPUT)
	public void logFast(String msg) {
		System.out.println("fast - " + msg);
	}

	@StreamListener(value = Sink.INPUT, condition = "headers['speed'] <= 40")
//	@ServiceActivator(inputChannel = Sink.INPUT)
//	@StreamListener(Processor.INPUT)
//	@SendTo(Processor.OUTPUT)
	public void logSlow(String msg) {
		System.out.println("slow - " + msg);
	}

}
