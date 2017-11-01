package springbootfirstapp.repository.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="articles")
public class Article implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="article_id")
    private int articleId;  
	
	@Column(name="title")
    private String title;
	
	@Column(name="category")	
	private String category;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinTable(name = "articles_magasins",
			   joinColumns = { @JoinColumn(name = "article_id") },
			   inverseJoinColumns = { @JoinColumn(name = "magasin_id")})
	private Set<Magasin> magasins = new HashSet<Magasin>(0);
	
	
	
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public Set<Magasin> getMagasins() {
		return magasins;
	}
	public void setMagasins(Set<Magasin> magasins) {
		this.magasins = magasins;
	}
	
}
