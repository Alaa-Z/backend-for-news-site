package se.kth.sda8.devnews.Topics;

import se.kth.sda8.devnews.articles.Article;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "topic")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idTopic")
    private Long id;

    @Column(name= "name")
    private String name;

    @ManyToMany(mappedBy ="topics")
    private List<Article> articles;

    public Topic() {
    }

    public Topic(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
