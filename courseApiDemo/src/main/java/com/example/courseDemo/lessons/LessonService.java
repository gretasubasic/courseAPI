package com.example.courseDemo.lessons;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<Lesson> getLessonsForCourse(Long courseId) {
        List<Lesson> allLessions = new ArrayList<>();
        for (Lesson lesson : lessonRepository.findByCourseId(courseId)) {
            allLessions.add(lesson);
        }
        return allLessions;
    }

    public Lesson saveLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public Lesson updateLesson(Lesson lesson, Long id) {
        Optional<Lesson> lessonOptional = lessonRepository.findById(id);
        Lesson existingLesson = lessonOptional.get();
        existingLesson.setName(lesson.getName());
        existingLesson.setDescription(lesson.getDescription());
        existingLesson.setCourse(lesson.getCourse());

        return lessonRepository.save(lesson);
    }
    public Lesson getLessonById(Long id) {
        Optional<Lesson> optionalLesson = lessonRepository.findById(id);
        Lesson lesson = optionalLesson.get();
        return lesson;
    }

    public List<Lesson> findLessonsByTopicNameAndCourseName(String topicName, String courseName) {
        return lessonRepository.findByTopicNameAndCourseName(topicName, courseName);
    }
}
