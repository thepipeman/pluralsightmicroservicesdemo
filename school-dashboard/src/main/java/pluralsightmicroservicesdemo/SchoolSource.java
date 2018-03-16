package pluralsightmicroservicesdemo;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by Aaron Rasing on 3/14/18.
 */
public interface SchoolSource {

    @Output("schoolDashboardChannel")
    MessageChannel schoolDashboard();

    @Output("standardSchool")
    MessageChannel standardSchool();
}
