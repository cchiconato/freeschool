package br.com.freeschool.subject;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long>{

	List<SubjectEntity> findAllByUserEntityId(Long idUser);

	SubjectEntity findById(Serializable id);
}
