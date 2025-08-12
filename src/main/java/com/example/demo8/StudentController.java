package com.example.demo8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

  @Autowired
  private StudentRepo studentRepo;

  // ✅ Get all students - return JSON to Postman
  @GetMapping
  public ResponseEntity<List<Student>> listStudent() {
    try {
      List<Student> students = new ArrayList<Student>();
      studentRepo.findAll().forEach(students::add); // Fixed method name

      if (students.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
      }

      return new ResponseEntity<>(students, HttpStatus.OK); // 200 with JSON

    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); // 500
    }
  }

  // ✅ GET one student by indexNo
  @GetMapping("/{indexNo}")
  public ResponseEntity<Student> getStudentById(@PathVariable("indexNo") String indexNo) {
    return studentRepo.findById(indexNo)
        .map(student -> new ResponseEntity<>(student, HttpStatus.OK)) // found
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); // not found
  }

}
