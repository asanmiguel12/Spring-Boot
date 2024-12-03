package com.pluralsight.demo.Repositories;

import com.pluralsight.demo.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, Long> {
}
