package Model;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Email {

	public static void enviarEmail(String nome,String texto) {
		String meuEmail = "cdemototaxi@gmail.com";
		String minhaSenha = "central123";

		SimpleEmail mail = new SimpleEmail();
		try {
			mail.setFrom(meuEmail);
			mail.setSubject("FeedBack");
			mail.setMsg("Feedback do Usuário: "+nome+" texto: "+texto);

			mail.setHostName("smtp.gmail.com");
			mail.setSmtpPort(25);
			mail.addTo(meuEmail);
			mail.setSSL(true);

			mail.setAuthentication(meuEmail, minhaSenha);
			mail.send();
		} catch (EmailException ex) {
			ex.printStackTrace();
		}
	}
	public static void recuperarEmail(String email,String texto) {
		String meuEmail = "cdemototaxi@gmail.com";
		String minhaSenha = "central123";

		SimpleEmail mail = new SimpleEmail();
		try {
			mail.setFrom(meuEmail);
			mail.setSubject("Recuperação de Senha");
			mail.setMsg(texto);

			mail.setHostName("smtp.gmail.com");
			mail.setSmtpPort(25);
			mail.addTo(email);
			mail.setSSL(true);

			mail.setAuthentication(meuEmail, minhaSenha);
			mail.send();
		} catch (EmailException ex) {
			ex.printStackTrace();
		}
	}
}