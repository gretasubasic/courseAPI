package com.example.courseDemo.repository;

import com.example.courseDemo.model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {
    public List<Course> findByTopicId(Long topicId);
}
