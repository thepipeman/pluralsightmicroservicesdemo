package org.pipecrafts.practice.pluralsight.commons;

/**
 * Created by Aaron Rasing on 3/7/18.
 */
public class SchoolRecord {

    private int id;

    private String name;

    private int enrollees;

    public SchoolRecord() {
    }

    public SchoolRecord(int id, String name, int enrollees) {
        this.id = id;
        this.name = name;
        this.enrollees = enrollees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnrollees() {
        return enrollees;
    }

    public void setEnrollees(int enrollees) {
        this.enrollees = enrollees;
    }
}
