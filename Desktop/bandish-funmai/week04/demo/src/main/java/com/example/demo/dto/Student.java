package com.example.demo.dto;

public class Student {
    private String name;

    private Long id;

    private String student_id;

    private int score;

    private String grade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }


    public String getName() {
        return name;
    }
    public String getStudent_id() {
        return student_id;
    }
    public int getScore() {
        return score;
    }
    public String getGrade() {
        return grade;
    }
}


