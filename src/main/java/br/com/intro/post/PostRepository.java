package br.com.intro.post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long>{
	
	public PostEntity findByTitle(String title);

}

