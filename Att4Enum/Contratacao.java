package Att4Enum;

import java.util.Date;
import java.util.Objects;

public class Contratacao {
    private Date data;
    private Cargo cargo;
    private Status status;
    private Projeto projeto;
    private Funcionario funcionario;

    public Contratacao(Date data, Cargo cargo, Projeto projeto, Funcionario funcionario) {
        this.data = data;
        this.cargo = cargo;
        this.status = Status.PENDENTE;
        this.projeto = projeto;
        this.funcionario = funcionario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void pendente() {
        this.status = Status.PENDENTE;
    }

    public void contratar() {
        this.status = Status.CONTRATADO;
    }

    public void demitir() {
        this.status = Status.DEMITIDO;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cargo, data, funcionario, projeto, status);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contratacao other = (Contratacao) obj;
        return cargo == other.cargo && Objects.equals(data, other.data)
                && Objects.equals(funcionario, other.funcionario) && Objects.equals(projeto, other.projeto)
                && status == other.status;
    }

    @Override
    public String toString() {
        return "Contratacao [data=" + data + ", cargo=" + cargo + ", status=" + status + ", projeto=" + projeto
                + ", funcionario=" + funcionario + "]";
    }

}