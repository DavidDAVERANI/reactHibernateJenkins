package springbootfirstapp.services;

import java.util.List;
import springbootfirstapp.repository.entity.Article;

public interface IArticleService {
	
     List<Article> getAllArticles();
     
     Article getArticleById(int articleId);
     
     boolean addArticle(Article article);
     
     void updateArticle(Article article);
     
     void deleteArticle(int articleId);
}
