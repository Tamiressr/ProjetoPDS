package Diagrama;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="escola")
public class Escola {
	private String nome;
	private String cnpj;
	private String link;
	private String email;
	private String senha;
	private Endereco endereco;
	private Telefone telefone;

	
	
	
	public Escola() {
		
	}


	public String toString() {
		return "Escola [Nome=" + nome + ", CNPJ=" + cnpj + ", Link=" + link + ", Email=" + email + ",]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
