package AtividadeAvaliativa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Evento {
	protected String nome;
	protected String descricao;
	protected Date dataInicio;
	protected Date dataTermino;
	protected String localizacao;
	protected List<Convidado> listaConvidado = new ArrayList<>();

	public Evento(String nome, String descricao, Date dataInicio, Date dataTermino, String localizacao) {
		this.nome = nome;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.localizacao = localizacao;
	}

	protected void adicionarConvidado(Convidado convidado) {
		if(!listaConvidado.contains(convidado)) {
			listaConvidado.add(convidado);
		}
	}
	protected void removerConvidado(Convidado convidado) {
		if(listaConvidado.contains(convidado)) {
			listaConvidado.add(convidado);
		}
	}
	protected void listarConvidados() {
		System.out.println("{\n");
		for(Convidado cv : listaConvidado) {
			System.out.println(cv.toString());
		}
		System.out.println("{");
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public List<Convidado> getListaConvidado() {
		return listaConvidado;
	}

	public void setListaConvidado(List<Convidado> listaConvidado) {
		this.listaConvidado = listaConvidado;
	}

	@Override
	public String toString() {
		return "Evento [nome=" + nome + ", descricao=" + descricao + ", dataInicio=" + dataInicio + ", dataTermino="
				+ dataTermino + ", localizacao=" + localizacao + ", listaConvidado=" + listaConvidado + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataInicio, dataTermino, descricao, listaConvidado, localizacao, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return Objects.equals(dataInicio, other.dataInicio) && Objects.equals(dataTermino, other.dataTermino)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(listaConvidado, other.listaConvidado)
				&& Objects.equals(localizacao, other.localizacao) && Objects.equals(nome, other.nome);
	}

}
