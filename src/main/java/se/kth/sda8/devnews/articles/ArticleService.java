package se.kth.sda8.devnews.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository repository;

    public List<Article> getAll() {
        return repository.findAll();
    }

    public Optional<Article> getById(Long id){
        return repository.findById(id);
    }

    public Article create(Article newArticle) {
        return repository.save(newArticle);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Article update(Article updatedArticle) {
        return repository.save(updatedArticle);
    }

    public List<Article> getAllByTopicId(Long topicId) {
        return repository.findAllByTopics_id(topicId);
    }
}