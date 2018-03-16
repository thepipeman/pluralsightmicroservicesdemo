package pluralsightmicroservicesdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.pipecrafts.practice.pluralsight.commons.SchoolRecord;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;

import java.util.Random;


/**
 * Created by Aaron Rasing on 3/13/18.
 */
@EnableBinding(SchoolSource.class)
public class SchoolPublisher {

    Random r = new Random();


    @Bean
//    @InboundChannelAdapter(channel = "schoolDashboardChannel", poller = @Poller(fixedDelay="2000"))
    public MessageSource<SchoolRecord> sendSchool() {
        ObjectMapper objectMapper = new ObjectMapper();
        SchoolRecord schoolRecord = new SchoolRecord(1, "UP Diliman", 500);
        String response = "";
        try {
             response = objectMapper.writeValueAsString(schoolRecord);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return () -> MessageBuilder.withPayload(schoolRecord)
                .setHeader("speed", r.nextInt(8) * 10).build();
    }


}
