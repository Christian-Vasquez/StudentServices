package com.company.studentedgeservice.model;

import java.util.List;
import java.util.Objects;

public class StudentViewModel {

    private int id;
    private String firstName;
    private String LastName;
    private List<Courses> courses;

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

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentViewModel)) return false;
        StudentViewModel that = (StudentViewModel) o;
        return id == that.id &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(LastName, that.LastName) &&
                Objects.equals(courses, that.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, LastName, courses);
    }

    @Override
    public String toString() {
        return "StudentViewModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", courses=" + courses +
                '}';
    }
}
