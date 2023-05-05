package com.example.courseDemo.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    private final TopicRepository topicRepository;
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic(1L, "Kotlin","Kotlin Description"),
            new Topic(2L, "Javascript", "Javascript desc"),
            new Topic(3L, "C++","C++ Description")
    ));

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<Topic> getAllTopics() {
        List<Topic> allTopics = new ArrayList<>();
        for (Topic topic : topicRepository.findAll()) {
            allTopics.add(topic);
        }
        return allTopics;
    }

    public Topic getTopic(Long id) {
        Optional<Topic> optionalTopic = topicRepository.findById(id);
        Topic topic = optionalTopic.get();
        return topic;
    }

    public Topic addTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public void updateTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
}
