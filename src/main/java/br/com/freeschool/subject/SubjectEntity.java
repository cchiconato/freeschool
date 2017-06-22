package br.com.freeschool.subject;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import br.com.freeschool.user.UserEntity;
import br.com.freeschool.utils.BaseEntity;

@Entity
@Table(name = "subject")
public class SubjectEntity extends BaseEntity<Long> {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	@JoinColumn(name ="user")
	private UserEntity userEntity;
	
	@NotBlank
	private String title;
	
	private String teacher;

	@NotBlank
	private String importantContent;
	
	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getImportantContent() {
		return importantContent;
	}

	public void setImportantContent(String importantContent) {
		this.importantContent = importantContent;
	}
	
}
