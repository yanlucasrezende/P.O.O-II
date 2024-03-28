package Att4Enum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Projeto {

	private String nome;
	private Date dtInicio;
	private Date dtTermino;
	private List<Contratacao> listaContratacoes = new ArrayList<>();

	public Projeto(String nome, Date dtInicio, Date dtTermino) {
		this.nome = nome;
		this.dtInicio = dtInicio;
		this.dtTermino = dtTermino;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Date getDtTermino() {
		return dtTermino;
	}

	public void setDtTermino(Date dtTermino) {
		this.dtTermino = dtTermino;
	}

	public List<Contratacao> getListaContratacoes() {
		return listaContratacoes;
	}

	public boolean adicionarContratacao(Contratacao contratacao) {
		getListaContratacoes().add(contratacao);
		return true;
	}

	public boolean removerContratacao(Contratacao contratacao) {
		if (getListaContratacoes().contains(contratacao)) {
			getListaContratacoes().remove(contratacao);
			return true;
		}
		return false;
	}

	public void listarContratacoes() {
		System.out.println("\nLista de contratacoes: {");
		for (Contratacao contratacao : this.listaContratacoes) {
			System.out.println(contratacao.toString());
		}
		System.out.println("}\n");
	}

	@Override
	public int hashCode() {
		return Objects.hash(dtInicio, dtTermino, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projeto other = (Projeto) obj;
		return Objects.equals(dtInicio, other.dtInicio) && Objects.equals(dtTermino, other.dtTermino)
				&& Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Projeto [nome=" + nome + ", dtInicio=" + dtInicio + ", dtTermino=" + dtTermino + "]";
	}

}