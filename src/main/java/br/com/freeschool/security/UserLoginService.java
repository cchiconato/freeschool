package br.com.freeschool.security;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.freeschool.user.UserEntity;

@Repository
public class UserLoginService implements UserDetailsService{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		TypedQuery<UserEntity> query = manager.createQuery("select u from UserEntity u where u.userName = :login",UserEntity.class).setParameter("login", login);
		List<UserEntity> users = query.getResultList();
		if (users.isEmpty()) {
			throw new UsernameNotFoundException("O usuario " + login + " não existe");
		}
		if(!users.get(0).isVerified())
			throw new IllegalStateException("O usuario " + login + " não está ativo");
		
		return users.get(0);
	}

}
