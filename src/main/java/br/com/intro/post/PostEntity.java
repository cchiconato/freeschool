package br.com.intro.post;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.intro.utils.BaseEntity;

@Entity
@Table(name = "post")
public class PostEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Column(name = "title", length = 100, nullable = false)
	private String title;
	
	@Column(name = "subtitle", length = 100, nullable = false)
	private String subtitle;
	
	@Column(name = "content", length = 100, nullable = false)
	private String content;
	
	@Column(name = "post_type", length = 100, nullable = false)
	private PostType postType;

	@Column(name = "yes", nullable = false)
	private int yes;

	@Column(name = "no", nullable = false)
	private int no;
	
}
