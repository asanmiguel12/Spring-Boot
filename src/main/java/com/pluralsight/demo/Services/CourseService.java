package com.pluralsight.demo.Services;

import com.pluralsight.demo.Models.Course;
import com.pluralsight.demo.Repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // get all course
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // get a course by id
    public Course getCourseById (long id) {
        Optional<Course> optionalProduct = courseRepository.findById(id);
        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        return null;
    }

    // deleting a course
    public void deleteCourseById(long id) {
        Course course = getCourseById(id);
        if(course != null) {
            courseRepository.delete(course);
        }
    }

    // updating a course
    public void updateCourse(Course course, long id) {
        Course courseToBeUpdated = getCourseById(id);
        courseToBeUpdated.setDescription(course.getDescription());
        courseToBeUpdated.setName(course.getName());
        courseToBeUpdated.setId(course.getId());
        courseToBeUpdated.setAverageGrade(course.getAverageGrade());
        courseRepository.save(courseToBeUpdated);
    }

    // adding a course
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }
}