package com.example.courseDemo.lessons;

import com.example.courseDemo.course.Course;
import com.example.courseDemo.course.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LessonController {

    private final LessonService lessonService;
    private final CourseService courseService;

    public LessonController(LessonService lessonService, CourseService courseService) {
        this.lessonService = lessonService;
        this.courseService = courseService;
    }

    @GetMapping("/courses/{courseId}/lessons")
    public List<Lesson> getLessons(@PathVariable Long courseId) {
        return lessonService.getLessonsForCourse(courseId);
    }

    /**
     * Saves a lesson for a course
     * @param courseId The ID of the course to add Lesson to
     * @param lesson Lesson that will be saved
     * @return new Lesson that is created
     */
    @PostMapping("/courses/{courseId}/lessons")
    public Lesson saveLesson(@PathVariable Long courseId, @RequestBody Lesson lesson) {
        Course course = courseService.getCourse(courseId);
        course.addLesson(lesson);
        lesson.setCourse(course);
        return lessonService.saveLesson(lesson);
    }

    /**
     * Deletes the lesson from course
     * @param courseId The ID of the course containing the lesson to be deleted
     * @param lessonId The ID of the lesson to be deleted
     */
    @DeleteMapping("/courses/{courseId}/lessons/{lessonId}")
    public void deleteLesson(@PathVariable Long courseId, @PathVariable Long lessonId) {
        Course course = courseService.getCourse(courseId);
        Lesson lesson = lessonService.getLessonById(lessonId);
        course.deleteLesson(lesson);
    }

    /**
     * Update an existing lesson in a course.
     *
     * @param courseId the ID of the course containing the lesson to update
     * @param lessonId the ID of the lesson to update
     * @param newLesson the new values for the lesson
     */
    @PutMapping("/courses/{courseId}/lessons/{lessonId}")
    public void updateLesson(@PathVariable Long courseId, @PathVariable Long lessonId, @RequestBody Lesson newLesson) {
        lessonService.updateLesson(newLesson, lessonId);
    }



}
