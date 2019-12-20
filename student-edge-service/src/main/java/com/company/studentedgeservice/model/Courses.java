package com.company.studentedgeservice.model;

import java.util.Objects;

public class Courses {
    private int id;
    private int studentId;
    private String name;
    private int score;

    public Courses() {
    }

    public Courses(int id, int studentId, String name, int score) {
        this.id = id;
        this.studentId = studentId;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Courses)) return false;
        Courses that = (Courses) o;
        return id == that.id &&
                studentId == that.studentId &&
                score == that.score &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentId, name, score);
    }

    @Override
    public String toString() {
        return "CoursesClient{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
