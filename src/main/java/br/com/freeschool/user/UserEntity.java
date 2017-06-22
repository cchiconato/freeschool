package br.com.freeschool.user;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.freeschool.utils.BaseEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity<Long> implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Email
	@Column(name = "user_name", length = 100, nullable = false, unique = true)
	private String userName;

	@Column(name = "password", length = 100, nullable = false)
	private String password;

	@Column(name = "is_verified", nullable = false)
	private boolean isVerified = false;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "registration_date")
	private Date registrationDate = new Date();

	public UserEntity(){}

	public void setUserName(String userName) {
		this.userName = userName.replace(" ", "");
	}

	public void setPassword(String password) {
		this.password = password;
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
		String token = Jwts.builder().setSubject(getUsername()).signWith(SignatureAlgorithm.HS512, "banana")
				.compact() + getUsername();
		return token.replace(".", "");
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.EMPTY_LIST;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	public String getPassword() {
		return password;
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

}