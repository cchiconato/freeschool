package br.com.intro.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

	public List<UserEntity> findByUsername(String username);

	public UserEntity findById(long id);
}

