package se.kth.sda8.devnews.articles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ArticleControllerTests {

    @Autowired
    ArticleController articleController;

    @MockBean
    ArticleService articleService;


   @Test
   public void testGetById() {
       Article article1= new Article(1L, "Test title1","Test body1","Test authorName1" );
       Article article2= new Article(2L, "Test title2","Test body2","Test authorName2" );

       Mockito.when(articleService.getById(1L))
               .thenReturn(Optional.of(article1));
       Mockito.when(articleService.getById(2L))
               .thenReturn(Optional.of(article2));

       Article controllerArticle1  =articleController.getById(1L);
       Article controllerArticle2  =articleController.getById(2L);

       Assertions.assertEquals(article1.getTitle(), controllerArticle1.getTitle());
       Assertions.assertEquals(article2.getTitle(), controllerArticle2.getTitle());
   }

   @Test
    public void testGetAll(){
       Article article1= new Article(1L, "Test title1","Test body1","Test authorName1" );
       Article article2= new Article(2L, "Test title2","Test body2","Test authorName2" );
       List<Article> articles = new ArrayList<>();
       articles.add(article1);
       articles.add(article2);

       Mockito.when(articleService.getAll())
               .thenReturn(articles);

       List<Article> actualArticles = articleController.getAll(null);

       Assertions.assertEquals(articles.size(), actualArticles.size());
       Assertions.assertEquals(articles.get(0).getTitle(), actualArticles.get(0).getTitle());
       Assertions.assertEquals(articles.get(1).getTitle(), actualArticles.get(1).getTitle());
   }

    @Test
    public void testGetAllByTopicId() {
        Long topicId = 10L;
        Article article1= new Article(1L, "Test title1","Test body1","Test authorName1" );
        Article article2= new Article(2L, "Test title2","Test body2","Test authorName2" );
        List<Article> articles = new ArrayList<>();
        articles.add(article1);
        articles.add(article2);
        Mockito.when(articleService.getAllByTopicId(topicId))
                .thenReturn(articles);

        List<Article> actualProducts = articleController.getAll(topicId);

        Assertions.assertEquals(articles.size(), actualProducts.size());
        Assertions.assertEquals(articles.get(0).getTitle(), actualProducts.get(0).getTitle());
        Assertions.assertEquals(articles.get(1).getTitle(), actualProducts.get(1).getTitle());
    }
    @Test
    public void testCreate() {
        Article article1= new Article(1L, "Test title1","Test body1","Test authorName1" );
        Mockito.when(articleService.create(article1))
                .thenReturn(article1);

        Article controllerArticle1  =articleController.create(article1);

        Assertions.assertEquals(article1.getTitle(), controllerArticle1.getTitle());
    }





}
