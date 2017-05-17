package br.com.intro.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.intro.utils.BaseEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Email
	@Column(name = "user_name", length = 100, nullable = false, unique = true)
	private String userName;

	@Column(name = "password", length = 100, nullable = false)
	private String password;

	@Column(name = "user_type", length = 100, nullable = false)
	@Enumerated(EnumType.STRING)
	private UserType userType;

	@Column(name = "birth_year", nullable = false)
	private int birthYear;

	@Column(name = "city", length = 100, nullable = false)
	private String city;

	@Column(name = "state", length = 100, nullable = false)
	private String state;
	
	@Column(name = "is_verified", nullable = false)
	private boolean isVerified;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "registration_data")
	private Date registrationDate = new Date();

	public UserEntity(){}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	
	public Date getRegistrationDate() {
		return registrationDate;
	}

	@JsonIgnore
	public String getToken() {
		String token = Jwts.builder().setSubject(getUserName()).signWith(SignatureAlgorithm.HS512, "banana")
				.compact() + getUserName();
		return token.replace(".", "");
	}
	
}
