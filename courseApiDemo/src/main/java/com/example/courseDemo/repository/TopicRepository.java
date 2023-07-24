package com.example.courseDemo.repository;

import com.example.courseDemo.model.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Long> {
}
