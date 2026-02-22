package com.example.demo.service;

import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ProductResponse;
import com.example.demo.dto.Student;
import com.example.demo.dto.StudentRes;
import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public StudentEntity saveStudent(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(student.getName());
        studentEntity.setStudent_id(student.getStudent_id());
        studentEntity.setScore(student.getScore());
        studentEntity.setGrade(student.getGrade());
        studentRepository.save(studentEntity);
        return studentRepository.save(studentEntity);
    }
    public List<StudentRes> findAll() {
        List<StudentRes> studentResList = new ArrayList<>();
        List<StudentEntity> studentEntityList = (List<StudentEntity>) studentRepository.findAll();
        for(int i=0 ; i<studentEntityList.size(); i++) {
            StudentRes studentRes = new StudentRes();
            studentRes.setId(studentEntityList.get(i).getId());
            studentRes.setStudent_id(studentEntityList.get(i).getStudent_id());
            studentRes.setName(studentEntityList.get(i).getName());
            studentRes.setGrade(studentEntityList.get(i).getGrade());
            studentRes.setScore(studentEntityList.get(i).getScore());
            studentResList.add(studentRes);
        }
        return studentResList;
    }
//    public Optional<StudentEntity> find(Long id) {
//        return studentRepository.findById(id);
//    }

}
