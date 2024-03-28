package Att4Enum;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Funcionario {
	private String nome;
	private String numeroDocumento;
	private TipoDocumento documento;
	private List<Contratacao> listaContratacoes = new ArrayList<>();

	public Funcionario(String nome, String numeroDocumento, TipoDocumento documento) {
		this.nome = nome;
		this.numeroDocumento = numeroDocumento;
		this.documento = documento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public TipoDocumento getDocumento() {
		return documento;
	}

	public void setDocumento(TipoDocumento documento) {
		this.documento = documento;
	}

	public List<Contratacao> getListaContratacoes() {
		return listaContratacoes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(documento, nome, numeroDocumento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return documento == other.documento && Objects.equals(nome, other.nome)
				&& Objects.equals(numeroDocumento, other.numeroDocumento);
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", numeroDocumento=" + numeroDocumento + ", documento=" + documento + "]";
	}

}