package AtividadeAvaliativa;

import java.util.Date;
import java.util.Objects;

public class EventoPeriodico extends Evento {

	private DiaSemana diaSemana;

	public EventoPeriodico(String nome, String descricao, Date dataInicio, Date dataTermino, String localizacao,
			DiaSemana diaSemana) {
		super(nome, descricao, dataInicio, dataTermino, localizacao);
		this.diaSemana = diaSemana;
	}

	public DiaSemana getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(DiaSemana diaSemana) {
		this.diaSemana = diaSemana;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(diaSemana);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventoPeriodico other = (EventoPeriodico) obj;
		return diaSemana == other.diaSemana;
	}

	@Override
	public String toString() {
		return "EventoPeriodico [diaSemana=" + diaSemana + "]";
	}

}
