package AtividadeAvaliativa;

import java.util.Objects;

public class Convidado {
	private String nome;

	public Convidado(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Convidado other = (Convidado) obj;
		return Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Convidado [nome=" + nome + "]";
	}

}
