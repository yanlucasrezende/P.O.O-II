package br.edu.ifgoias.academico.entities;

import java.io.Serializable;
import java.util.Objects;

/*
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
*/

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Disciplina implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idaluno;

	@Column(name = "nomeDisciplina", nullable = false)
	private String nome;

	public Disciplina() {
		super();
	}

	public Disciplina(Integer idaluno, String nome) {
		super();
		this.idaluno = idaluno;
		this.nome = nome;
	}

	public Integer getIdaluno() {
		return idaluno;
	}

	public void setIdaluno(Integer idaluno) {
		this.idaluno = idaluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Disciplina [idaluno=" + idaluno + ", nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idaluno, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		return Objects.equals(idaluno, other.idaluno) && Objects.equals(nome, other.nome);
	}

}
