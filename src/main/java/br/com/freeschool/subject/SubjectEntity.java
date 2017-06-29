package br.com.freeschool.subject;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import br.com.freeschool.exam.ExamEntity;
import br.com.freeschool.user.UserEntity;
import br.com.freeschool.utils.BaseEntity;

@Entity
@Table(name = "subject")
public class SubjectEntity extends BaseEntity<Long> {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne
	@JoinColumn(name ="user")
	private UserEntity userEntity;
	
	@NotBlank
	private String title;
	
	private String teacher;

	private String importantContent;
	
	@OneToMany(mappedBy="subjectEntity", cascade = CascadeType.PERSIST)
	private List<ExamEntity> exams;
	
	public List<ExamEntity> getExams() {
		return exams;
	}
	
	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		if(userEntity == null)
			return;
		this.userEntity = userEntity;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if(title == null)
			return;
		this.title = title;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		if(teacher == null)
			return;
		this.teacher = teacher;
	}

	public String getImportantContent() {
		return importantContent;
	}

	public void setImportantContent(String importantContent) {
		this.importantContent = importantContent;
	}
	
}
