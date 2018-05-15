package Diagrama;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "escola")
public class Escola {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String nome;
	@Column
	private String nivelDeGoverno;
	@Column
	private String cnpj;
	@Column
	private String link;
	@Column
	private String email;
	@Column
	private String senha;
//	@Column
//	private Endereco endereco;
//	@Column
//	private Telefone celular;
//	@Column
//	private Telefone fixo;

	public Escola() {
//		this.endereco=new Endereco();
//		this.celular=new Telefone();
//		this.fixo=new Telefone();

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

//	public Endereco getEndereco() {
//		return endereco;
//	}
//
//	public void setEndereco(Endereco endereco) {
//		this.endereco = endereco;
//	}
//
//	public Telefone getCelular() {
//		return celular;
//	}
//
//	public void setCelular(Telefone celular) {
//		this.celular = celular;
//	}
//
//	public Telefone getFixo() {
//		return fixo;
//	}

//	public void setFixo(Telefone fixo) {
//		this.fixo = fixo;
//	}

	public String getNivelDeGoverno() {
		return nivelDeGoverno;
	}

	public void setNivelDeGoverno(String nivelDeGoverno) {
		this.nivelDeGoverno = nivelDeGoverno;
	}

	public int getId() {
		return id;
	}

}
