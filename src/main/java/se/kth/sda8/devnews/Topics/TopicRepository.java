package se.kth.sda8.devnews.Topics;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    List<Topic> findAllByArticles_id(Long articleId);
}

