package com.example.demo.controller;

import com.example.demo.dto.Student;
import com.example.demo.dto.StudentRes;
import com.example.demo.entity.StudentEntity;
import com.example.demo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public ResponseEntity<Void> create(@RequestBody Student student) {
        studentService.saveStudent(student);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/getstudent")
    public ResponseEntity <List<StudentRes>> findAll() {
        List<StudentRes> studentResList = studentService.findAll();
        return ResponseEntity.ok().body(studentResList);
    }


}
