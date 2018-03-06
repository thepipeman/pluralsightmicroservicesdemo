package org.pipecrafts.practice.pluralsight.commons;

/**
 * Created by Aaron Rasing on 3/6/18.
 */
public class PersonRecord {

    private int id;

    private String name;

    private int age;

    public PersonRecord() {
    }

    public PersonRecord(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
