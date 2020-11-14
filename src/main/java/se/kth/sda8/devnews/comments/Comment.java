package se.kth.sda8.devnews.comments;


import se.kth.sda8.devnews.articles.Article;

import javax.persistence.*;

@Entity
@Table(name="comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idComment")
    private Long id;

    @Column(name ="body", columnDefinition ="Text")
    private String body;

    @Column(name="authorName")
    private String authorName;

    @ManyToOne
    private Article article;

    public Comment() {
    }

    public Comment(Long id, String body, String authorName, Article article) {
        this.id = id;
        this.body = body;
        this.authorName = authorName;
        this.article = article;
    }

    public Long getId() {
        return id;
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

    public void setBody(String body) {
        this.body = body;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
