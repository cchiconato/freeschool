package br.com.freeschool.subject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.freeschool.user.UserEntity;
import br.com.freeschool.utils.ServiceMap;

@RestController
@RequestMapping(path = "/api/subject")
public class SubjectService implements ServiceMap{
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@GetMapping
	public List<SubjectEntity> findAllSubjectsByUser(@AuthenticationPrincipal UserEntity user) {
		return subjectRepository.findAllByUserEntityId(user.getId());
	}
	
	@PostMapping
	public ResponseEntity<SubjectEntity> insert(@AuthenticationPrincipal UserEntity user, @RequestBody SubjectEntity subject){
		subject.setUserEntity(user);
		subjectRepository.save(subject);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
