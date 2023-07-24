package com.example.courseDemo.service;

import com.example.courseDemo.repository.CourseRepository;
import com.example.courseDemo.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // get all Courses

    public List<Course> getCourses() {
        List<Course> allCourses = new ArrayList<>();
        for (Course course : courseRepository.findAll()) {
            allCourses.add(course);
        }
        return allCourses;
    }

    // find course by Topic

    public List<Course> getCoursesByTopic(Long topicId) {
        return courseRepository.findByTopicId(topicId);
    }


    public Course getCourse(Long id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        Course course = optionalCourse.get();
        return course;
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }
}
