package br.com.freeschool.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	public UserEntity findByUserName(String username);

}

