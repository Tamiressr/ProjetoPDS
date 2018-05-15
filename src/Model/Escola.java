package Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@OneToOne(mappedBy="escola")
	private  Endereco endereco;
	
	@OneToMany(mappedBy="escola")
	private List<Turma> turma=new ArrayList<Turma>();
	
	@OneToMany(mappedBy="escola")
	private List<Telefone> telefone=new ArrayList<Telefone>();
	
	public Escola() {
	//	this.endereco= new Endereco();
		//this.turma= new ArrayList<Turma>();
		//this.telefone= new ArrayList<Telefone>();
	}

	public void setId(int id) {
		this.id = id;
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

	@OneToOne(cascade=CascadeType.ALL)
	public Endereco getEndereco() {
		return endereco;
	}
	@OneToOne(cascade=CascadeType.ALL)
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	@OneToMany(mappedBy="escola")
	public List<Turma> getTurma() {
		return turma;
	}
	@OneToMany(mappedBy="escola")
	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}
	@OneToMany(mappedBy="escola",cascade=CascadeType.ALL)
	public List<Telefone> getTelefone() {
		return telefone;
	}
	@OneToMany(mappedBy="escola",cascade=CascadeType.ALL)
	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}

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
