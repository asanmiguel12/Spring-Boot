package com.pluralsight.demo.Controllers;


import com.pluralsight.demo.Models.Student;
import com.pluralsight.demo.Services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("student")
public class StudentController {
    private StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // get all
    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    // get course by id
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id){
        Student studentFound = studentService.getStudentByID(id);
        if(studentFound == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentFound);
    }

    // get course by name
    @GetMapping("/name/{name}")
    public ResponseEntity<Optional<Student>> getStudentByName(@PathVariable String name) {
        return ResponseEntity.ok(studentService.getStudentByName(name));
    }

    // add a course
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        if(student.getId() != 0) {
            return ResponseEntity.badRequest().build();
        }
        Student newStudent = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
    }

    // update a course
    @PutMapping("{id}")
    public ResponseEntity<Void> updateStudent(@RequestBody Student student, @PathVariable long id ){
        boolean success = studentService.updateStudent(student,id);
        if(success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // delete a course
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.ok().build();
    }
}