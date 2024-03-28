package Att1;

import java.time.LocalDate;

public class Curso {
    private int numeroCurso;
    private String nomeCurso;
    private LocalDate dataInicio;

    public Curso(int numeroCurso, String nomeCurso, LocalDate dataInicio) {
        this.numeroCurso = numeroCurso;
        this.nomeCurso = nomeCurso;
        this.dataInicio = dataInicio;
    }

    public Curso() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numeroCurso;
        result = prime * result + ((nomeCurso == null) ? 0 : nomeCurso.hashCode());
        result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Curso other = (Curso) obj;
        if (numeroCurso != other.numeroCurso)
            return false;
        if (nomeCurso == null) {
            if (other.nomeCurso != null)
                return false;
        } else if (!nomeCurso.equals(other.nomeCurso))
            return false;
        if (dataInicio == null) {
            if (other.dataInicio != null)
                return false;
        } else if (!dataInicio.equals(other.dataInicio))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Curso [ numeroCurso=" + numeroCurso + ", nomeCurso=" + nomeCurso + ", dataInicio=" + dataInicio + "]";
    }

    public int getNumeroCurso() {
        return numeroCurso;
    }

    public void setNumeroCurso(int numeroCurso) {
        this.numeroCurso = numeroCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

}