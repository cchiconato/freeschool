package br.com.intro.utils;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.com.intro.user.UserVerificationEntity;


public class EmailSender {

	public void send(UserVerificationEntity userVerificationEntity) {
		  try {
	            Email email = new SimpleEmail();
	            email.setStartTLSRequired(true);
	            email.setHostName("smtp.gmail.com");
	            email.setSmtpPort(465);
	            email.setStartTLSRequired(true);
	            email.setSSLOnConnect(true);
	            email.setAuthenticator(new DefaultAuthenticator("plebssuporte@gmail.com", "password123?"));
	            

	            email.setFrom("plebssuporte@gmail.com");
	            email.setSubject("Cadastro no Plebs");
	            email.setMsg("Clique no link para ativar sua conta http://localhost:8080/api/user/"+userVerificationEntity.getVerificationKey());
	            email.addTo(userVerificationEntity.getUserName());
	            email.send();

	        } catch (EmailException e) {
	            e.printStackTrace();
	        }
	}
}

