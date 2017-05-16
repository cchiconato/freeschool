package br.com.intro.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserVerificationRepository extends JpaRepository<UserVerificationEntity, Long>{
	
	public UserVerificationEntity findByVerificationKey(String verificationKey);

	public UserEntity findById(Long id);
}
