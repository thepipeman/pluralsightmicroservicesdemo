package org.pipecrafts.practice.pluralsight;

import org.pipecrafts.practice.pluralsight.commons.SchoolRecord;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron Rasing on 3/7/18.
 */
@RestController
@RequestMapping("api/v1/school")
public class GradSchoolRestController {


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<SchoolRecord>> getSchools(){
        List<SchoolRecord> schoolRecords = new ArrayList<>();
        schoolRecords.add(new SchoolRecord(1, "De La Salle University Graduate School", 15));
        schoolRecords.add(new SchoolRecord(2, "Ateneo De Manila University Graduate School", 10));
        schoolRecords.add(new SchoolRecord(3, "University of the Philippines Graduate School", 10));

        return new ResponseEntity<>(schoolRecords, HttpStatus.OK);
    }

}
