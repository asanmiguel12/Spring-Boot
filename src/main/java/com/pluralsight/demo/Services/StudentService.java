package com.pluralsight.demo.Services;

import com.pluralsight.demo.Models.Student;
import com.pluralsight.demo.Repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // get a course by id
    public Student getStudentByID(long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        }
        return null;
    }

    public Optional<Student> getStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    // adding a Student
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    // deleting a student
    public void deleteStudentById(long id) {
        Student student = getStudentByID(id);
        if (student != null) {
            studentRepository.delete(student);
        }
    }


    // updating a course
    public boolean updateStudent(Student student, long id) {
        Student studentToBeUpdated = getStudentByID(id);
        if (studentToBeUpdated != null) {
            studentToBeUpdated.setName(student.getName());
            studentToBeUpdated.setId(student.getId());
            studentToBeUpdated.setAge(student.getAge());
            studentRepository.save(studentToBeUpdated);
            return true;
        } else {
            return false;
        }
    }

}