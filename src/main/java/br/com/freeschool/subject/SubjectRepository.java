package br.com.freeschool.subject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long>{

	List<SubjectEntity> findAllByUserEntityId(Long idUser);
}
