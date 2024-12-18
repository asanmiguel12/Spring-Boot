package com.pluralsight.demo.Repositories;

import com.pluralsight.demo.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByName(String name);

}

