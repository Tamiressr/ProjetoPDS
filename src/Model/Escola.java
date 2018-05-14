package Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Escola {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String cnpj;
	private String link;
	private String email;
	private String senha;
	private String nivelDeGoverno;
//	@Column
//	private Endereco endereco;
//	@Column
//	private Telefone telefone;

	@OneToMany(mappedBy="escola")
	private List<Turma> turmas = new ArrayList<>();
	
	public Escola() {
		
	}
	
	public String toString() {
		return "Escola [Nome=" + nome + ", CNPJ=" + cnpj + ", Link=" + link + ", Email=" + email + ",]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public String getNivelDeGoverno() {
		return nivelDeGoverno;
	}

	public void setNivelDeGoverno(String nivelDeGoverno) {
		this.nivelDeGoverno = nivelDeGoverno;
	}

}