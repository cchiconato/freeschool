package br.com.freeschool.subject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.freeschool.exam.ExamEntity;
import br.com.freeschool.exam.ExamRepository;
import br.com.freeschool.user.UserEntity;
import br.com.freeschool.utils.ServiceMap;

@RestController
@RequestMapping(path = "/api/subject")
public class SubjectService implements ServiceMap{
	
	@Autowired
	private SubjectRepository subjectRepository;
	@Autowired
	private ExamRepository examRepository;
	
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
	
	@GetMapping(path="/{id}")
	public SubjectEntity findSubjectBytId(@PathVariable Long id) {
		return subjectRepository.findById(id);
	}
	
	@PostMapping(path="/exam/{id}")
	public ResponseEntity<SubjectEntity> insert(@RequestBody ExamEntity exam, @PathVariable Long id){
		exam.setSubjectEntity(subjectRepository.findById(id));
		examRepository.save(exam);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<SubjectEntity> update(@RequestBody SubjectEntity subject, @PathVariable Long id){
		SubjectEntity subjectFound = subjectRepository.findById(id);
		subjectFound.setImportantContent(subject.getImportantContent());
		subjectRepository.save(subjectFound);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
