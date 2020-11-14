package se.kth.sda8.devnews.Topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.kth.sda8.devnews.comments.CommentController;
import se.kth.sda8.devnews.comments.CommentService;


import java.util.List;

@RestController
@RequestMapping ("/topics")
public class TopicController {
    private TopicService topicService;

    public TopicController (@Autowired TopicService topicService){
        this.topicService = topicService;
    }


    @GetMapping("")
    public List<Topic> getAll(@RequestParam(required = false) Long articleId) {
        if(articleId ==null){
                return topicService.getAll();
        }   else {
                return topicService.getAllByArticleId(articleId);
        }
    }


    // GET specific article by id
    @GetMapping("/{id}")
    public Topic getById(@PathVariable Long id){
        return topicService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //
    @PostMapping("")
    public Topic create(@RequestBody Topic newTopic) {
        return topicService.create(newTopic);

    }
    @PutMapping ("")
    public Topic update(@RequestBody Topic updatedTopic) {
        return topicService.update(updatedTopic);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        topicService.delete(id);



    }


}
