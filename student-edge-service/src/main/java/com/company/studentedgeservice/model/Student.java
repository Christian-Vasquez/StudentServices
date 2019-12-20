package com.company.studentedgeservice.model;

import java.util.Objects;

public class Student {

    private int id;
    private String firstName;
    private String LastName;

    public Student() {
    }

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        LastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student that = (Student) o;
        return id == that.id &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(LastName, that.LastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, LastName);
    }

    @Override
    public String toString() {
        return "StudentClient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }
}
