package com.pluralsight.demo.Controllers;

import com.pluralsight.demo.Models.Course;
import com.pluralsight.demo.Services.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {
    private CourseService courseService;


    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // get all
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    // get by id
    @GetMapping("{id}")
    public Course getCourseById(@PathVariable long id) {
        return courseService.getCourseById(id);
    }

    // post
    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    // put
    @PutMapping("{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable long id) {
        courseService.updateCourse(course, id);
    }

    // delete
    @DeleteMapping("{id}")
    public void deleteCourseById(@PathVariable long id) {
        courseService.deleteCourseById(id);
    }
}
