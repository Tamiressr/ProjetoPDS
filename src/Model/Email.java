package Model;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Email {

	public static void enviarEmail(String texto) {
		String meuEmail = "cdemototaxi@gmail.com";
		String minhaSenha = "central123";

		SimpleEmail mail = new SimpleEmail();
		try {
			System.out.println("Enviando...");
			mail.setFrom(meuEmail);
			mail.setSubject("FeedBack");
			mail.setMsg(texto);

			mail.setHostName("smtp.gmail.com");
			mail.setSmtpPort(25);
			mail.addTo("tamiressiqueira12@gmail.com");
			mail.setSSL(true);

			mail.setAuthentication(meuEmail, minhaSenha);
			mail.send();
			System.out.println("Email enviado.");
		} catch (EmailException ex) {
			ex.printStackTrace();
			System.out.println("Email não enviado.");
		}
	}
}