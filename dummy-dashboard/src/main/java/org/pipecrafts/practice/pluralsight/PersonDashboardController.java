package org.pipecrafts.practice.pluralsight;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.pipecrafts.practice.pluralsight.commons.PersonRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron Rasing on 3/6/18.
 */
@Controller
public class PersonDashboardController {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "reliable")
    @RequestMapping("/dashboard")
    public String getPersons(Model m) {
        ResponseEntity<List<PersonRecord>> responseEntity = restTemplate.exchange("http://dummy-service/api/v1/person/",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<PersonRecord>>() {
                });
        m.addAttribute("persons", responseEntity.getBody());


        return "dashboard";
    }


    public String reliable(Model m){
        System.out.println("Fallback operation called");

        PersonRecord personRecord = new PersonRecord(1, "Default error name", 0);
        List<PersonRecord> personRecords = new ArrayList<>();
        personRecords.add(personRecord);
        m.addAttribute("persons", personRecords);
        return "dashboard";
    }

}
