package com.example.courseDemo.lessons;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, Long> {
    List<Lesson> findByCourseId(Long courseId);

    @Query("SELECT l FROM Lesson l JOIN l.course c JOIN c.topic t WHERE t.name = :topicName AND c.name = :courseName")
    List<Lesson> findByTopicNameAndCourseName(@Param("topicName") String topicName, @Param("courseName") String courseName);

}
