package org.pipecrafts.practice.pluralsight;

import org.pipecrafts.practice.pluralsight.commons.PersonRecord;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron Rasing on 3/6/18.
 */
@RestController
@RequestMapping("api/v1/person")
public class PersonRestController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PersonRecord>> getPersonRecords(){
        List<PersonRecord> records = new ArrayList<>();

        records.add(new PersonRecord(1, "Aaron", 24));
        records.add(new PersonRecord(2, "Tabs", 23));
        records.add(new PersonRecord(3, "Kyel", 25));

        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public ResponseEntity<PersonRecord> getPerson(@PathVariable("id") int id){
        PersonRecord personRecord = new PersonRecord(id, "John Doe", 25);

        return new ResponseEntity<>(personRecord, HttpStatus.OK);
    }

}
