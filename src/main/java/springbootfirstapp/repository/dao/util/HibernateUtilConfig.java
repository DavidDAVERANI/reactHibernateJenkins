package springbootfirstapp.repository.dao.util;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateUtilConfig {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Bean
	public SessionFactory getSessionFactory() {
		if(entityManagerFactory.unwrap(SessionFactory.class) == null) {
			System.out.println("************** Factory de merde is not hibernate factory **************************");
			throw new NullPointerException("Factory de merde is not hibernate factory");
		}
		return entityManagerFactory.unwrap(SessionFactory.class);
	}
}
