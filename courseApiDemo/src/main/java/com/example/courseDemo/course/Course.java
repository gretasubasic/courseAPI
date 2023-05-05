package com.example.courseDemo.course;

import com.example.courseDemo.lessons.Lesson;
import com.example.courseDemo.topic.Topic;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    @JsonBackReference
    private Topic topic;

    @OneToMany
    @JsonManagedReference
    private Set<Lesson> lessons;

    // students

    /**
     * Adds a new lesson to the collection of lessons managed by this class.
     *
     * @param lesson The lesson to be added to the collection.
     */
    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    /**
     * Deletes the specified lesson from the collection of lessons, if it exists.
     *
     * @param lesson the lesson to delete from the collection
     */
    public void deleteLesson(Lesson lesson) {
        if (lessons.contains(lesson)) {
            lessons.remove(lesson);
        }
    }

    // getters + setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }
}
