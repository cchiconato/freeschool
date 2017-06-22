package br.com.freeschool.utils;

import java.text.SimpleDateFormat;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import br.com.freeschool.user.UserEntity;

public class EmailSender {

	public static void sendEmailForUserConfirmation(UserEntity userEntity) {
		try {
			final String linkForVerification = "http://localhost:8080/api/public/user/activate/"
					+ userEntity.getToken();

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
			email.setTextMsg("Obrigado por cadastrar-se no Plebs! Clique no link para ativar sua conta: " + linkForVerification);
			email.addTo(userEntity.getUsername());
			email.send();

		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

	private static String getHtmlMessage(UserEntity userEntity, final String linkForVerification) {
		StringBuilder html = new StringBuilder();
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy"); 
		html.append("<html><body>");
		html.append("<h1>Obrigado por cadastrar-se no Plebs!</h1>");
		html.append("<table rules='all' style='border-color: #666;' cellpadding='10'>");
		html.append("<tr style='background: #eee;'><td><strong>Usuário :</strong> </td><td>"+userEntity.getUsername()+"</td></tr>");
		html.append("<tr><td><strong>Data de cadastro :</strong> </td><td>"+dt.format(userEntity.getRegistrationDate())+"</td></tr>");
		html.append("</table>");
		html.append("<h3>Para ativar sua conta clique no link abaixo: </h3>");
		html.append("<a href='"+linkForVerification+"'>"+linkForVerification+"</a>");
		html.append("</body></html>");
		return html.toString();
	}
}
