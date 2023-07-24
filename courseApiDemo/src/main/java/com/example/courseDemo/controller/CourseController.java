package com.example.courseDemo.controller;

import com.example.courseDemo.model.Course;
import com.example.courseDemo.model.Topic;
import com.example.courseDemo.service.CourseService;
import com.example.courseDemo.service.TopicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {


    private final CourseService courseService;
    private final TopicService topicService;

    public CourseController(TopicService topicService, CourseService courseService) {
        this.courseService = courseService;
        this.topicService = topicService;
    }

    @GetMapping("/topics/{topicId}/courses")
    public List<Course> getAllCoursesForTopic(@PathVariable Long topicId) {
     return courseService.getCoursesByTopic(topicId);
    }

    @GetMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable Long id) {
        return courseService.getCourse(id);
    }

    @PostMapping("/topics/{topicId}/courses")
    public Course addCourse(@PathVariable Long topicId, @RequestBody Course course) {
        Topic topic = topicService.getTopic(topicId);
        course.setTopic(topic);
        topic.addCourse(course);
        return courseService.addCourse(course);
    }
}
