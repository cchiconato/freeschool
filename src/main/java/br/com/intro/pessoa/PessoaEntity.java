package br.com.intro.pessoa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.intro.utils.BaseEntity;

@Entity
@Table(name = "pessoa")
public class PessoaEntity extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "nome", length = 100, nullable = false)
	private String nome;
	

	@Column(name = "idade", nullable = false)
	private int idade;


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
		this.idade = idade;
	}

}
