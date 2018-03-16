package pluralsightmicroservicesdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by Aaron Rasing on 3/15/18.
 */
@RestController
public class SchoolRestController {

    @Autowired
    SchoolSource schoolSource;

    @RequestMapping(path="/school", method = RequestMethod.POST)
    public String publishMessage(@RequestBody String payload) {
        System.out.println(payload);
        Random random = new Random();
        schoolSource.schoolDashboard().send(
                MessageBuilder.withPayload(payload)
                .setHeader("speed", random.nextInt(8) * 10).build());
        return "success";
    }




}
