package br.com.freeschool.exam;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import br.com.freeschool.subject.SubjectEntity;
import br.com.freeschool.utils.BaseEntity;

@Entity
@Table(name = "exam")
public class ExamEntity extends BaseEntity<Long>{
	
	private static final long serialVersionUID = 1L;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne
	@JoinColumn(name ="subject")
	private SubjectEntity subjectEntity;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	private double grade;

	public SubjectEntity getSubjectEntity() {
		return subjectEntity;
	}

	public void setSubjectEntity(SubjectEntity subjectEntity) {
		this.subjectEntity = subjectEntity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}
	
}
