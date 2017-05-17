package br.com.intro.user;

import java.text.SimpleDateFormat;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class UserVerificationEmailSender {

	public void send(UserVerificationEntity userVerificationEntity, UserEntity userEntity) {
		try {
			final String linkForVerification = "http://localhost:8080/api/user/activateUser/"
					+ userVerificationEntity.getVerificationKey();

			HtmlEmail email = new HtmlEmail();
			email.setStartTLSRequired(true);
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			email.setStartTLSRequired(true);
			email.setSSLOnConnect(true);
			email.setAuthenticator(new DefaultAuthenticator("plebssuporte@gmail.com", "password123?"));

			email.setFrom("plebssuporte@gmail.com");
			email.setSubject("Cadastro no Plebs");
			email.setHtmlMsg(getHtmlMessage(userEntity, linkForVerification));
			email.setTextMsg("Obrigado por se cadastrar no Plebs! Clique no link para ativar sua conta: " + linkForVerification);
			email.addTo(userEntity.getUserName());
			email.send();

		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

	private String getHtmlMessage(UserEntity userEntity, final String linkForVerification) {
		StringBuilder html = new StringBuilder();
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy"); 
		html.append("<html><body>");
		html.append("<h1>Obrigado por se cadastras no Plebs!</h1>");
		html.append("<table rules='all' style='border-color: #666;' cellpadding='10'>");
		html.append("<tr style='background: #eee;'><td><strong>Usuário :</strong> </td><td>"+userEntity.getUserName()+"</td></tr>");
		html.append("<tr><td><strong>Data de cadastro :</strong> </td><td>"+dt.format(userEntity.getRegistrationDate())+"</td></tr>");
		html.append("</table>");
		html.append("<h3>Para ativar sua conta clique no link a seguir: </h3>");
		html.append("<a href='"+linkForVerification+"'>"+linkForVerification+"</a>");
		html.append("</body></html>");
		return html.toString();
	}
}
