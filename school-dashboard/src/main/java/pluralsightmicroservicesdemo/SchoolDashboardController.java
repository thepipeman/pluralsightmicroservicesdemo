package pluralsightmicroservicesdemo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.pipecrafts.practice.pluralsight.commons.PersonRecord;
import org.pipecrafts.practice.pluralsight.commons.SchoolRecord;
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
 * Created by Aaron Rasing on 3/7/18.
 */
@Controller
public class SchoolDashboardController {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "reliable")
    @RequestMapping("/dashboard")
    public String getSchools(Model m) {
        ResponseEntity<List<SchoolRecord>> responseEntity = restTemplate.exchange("http://school-service/api/v1/school/",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<SchoolRecord>>() {
                });
        m.addAttribute("schools", responseEntity.getBody());


        return "dashboard";
    }

    public String reliable(Model m){
        System.out.println("Fallback operation called");

        SchoolRecord schoolRecord = new SchoolRecord(1, "No School", 0);
        List<SchoolRecord> schoolRecords = new ArrayList<>();
        schoolRecords.add(schoolRecord);
        m.addAttribute("schools", schoolRecords);
        return "dashboard";
    }


}
