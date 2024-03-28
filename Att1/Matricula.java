package Att1;

import java.time.LocalDate;

public class Matricula {
    private Curso curso;
    private Aluno aluno;
    private LocalDate dataMatricula;

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public Matricula(Curso curso, Aluno aluno) {
        this.curso = curso;
        this.aluno = aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public static boolean calculaMaiorIdade(Aluno aluno) {
        if ((LocalDate.now().getYear() - aluno.getDataNascimento().getYear()) > 17) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((curso == null) ? 0 : curso.hashCode());
        result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
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
        Matricula other = (Matricula) obj;
        if (curso == null) {
            if (other.curso != null)
                return false;
        } else if (!curso.equals(other.curso))
            return false;
        if (aluno == null) {
            if (other.aluno != null)
                return false;
        } else if (!aluno.equals(other.aluno))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Matricula [curso=" + curso + ", aluno=" + aluno + "]";
    }

}