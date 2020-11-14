package se.kth.sda8.devnews.articles;

import se.kth.sda8.devnews.Topics.Topic;
import se.kth.sda8.devnews.comments.Comment;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idArticle")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name ="body", columnDefinition ="Text")
    private String body;

    @Column(name="authorName")
    private String authorName;

    @OneToMany
    private List<Comment> comments;

    @ManyToMany
    private List<Topic> topics;


    public Article() {
    }

    public Article(Long id, String title, String body, String authorName) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.authorName = authorName;


    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
}