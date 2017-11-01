package springbootfirstapp.repository.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springbootfirstapp.repository.entity.Article;

@Transactional
@Repository
public class ArticleDAO  implements IArticleDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session = null;
	private Criteria criteria = null;
	
	@Override
	public Article getArticleById(int articleId) {
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		criteria = session.createCriteria(Article.class);
		Criterion restriction1 = Restrictions.eq("articleId", articleId);
		
		criteria.add(restriction1);
		session.getTransaction().commit();
		Article article = (Article) criteria.uniqueResult();
		Hibernate.initialize(article.getMagasins());
		session.close();
		return  article;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAllArticles() {
		//String hql = "FROM Article as atcl ORDER BY atcl.articleId";
		
		List articles = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			criteria = session.createCriteria(Article.class);
			articles = criteria.list();
			session.getTransaction().commit();
			
		} catch(Exception e) {
			System.out.println("Exception dans session de get all articles");
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		//return (List<Article>) entityManager.createQuery(hql).getResultList();
		return (List<Article>) articles;
	}
	
	@Override
	public void addArticle(Article article) {
		//entityManager.persist(article);
	}
	
	@Override
	public void updateArticle(Article article) {
		Article artcl = getArticleById(article.getArticleId());
		artcl.setTitle(article.getTitle());
		artcl.setCategory(article.getCategory());
		//entityManager.flush();
	}
	
	@Override
	public void deleteArticle(int articleId) {
		//entityManager.remove(getArticleById(articleId));
	}
	
	@Override
	public boolean articleExists(String title, String category) {
		String hql = "FROM Article as atcl WHERE atcl.title = ? and atcl.category = ?";
		/*int count = entityManager.createQuery(hql).setParameter(1, title)
		              .setParameter(2, category).getResultList().size();
		return count > 0 ? true : false;
		*/
		return true;
	}
}
