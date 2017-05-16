package br.com.intro.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	public UserEntity findByUserName(String userName);

	public UserEntity findById(long id);
}

