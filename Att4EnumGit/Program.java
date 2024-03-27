package Att4EnumGit;

import java.text.SimpleDateFormat;

public class Program {

	public static void main(String[] args) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

			Projeto p1 = new Projeto("Construcao da loja XYZ", df.parse("01/01/2020"), df.parse("31/12/2021"));
			
			Funcionario f1 = new Funcionario("Dory", "999.999.999-00", TipoDocumento.CPF);
			Funcionario f2 = new Funcionario("Carline", "111.111.111-00", TipoDocumento.CPF);
			
			Contratacao c1 = new Contratacao(df.parse("01/01/2020"), Cargo.DIRETOR, p1, f1);
			Contratacao c2 = new Contratacao(df.parse("11/10/2020"), Cargo.ADMINISTRATIVO, p1, f2);
			
			//Optei por usar o metodo mas preferiria passar no construtor do contratacao para realizar essa adicao
			p1.adicionarContratacao(c1);
			p1.adicionarContratacao(c2);
			
			p1.listarContratacoes();
			
			c1.contratar();
			p1.listarContratacoes();
			
			c1.demitir();
			c2.contratar();
			
			p1.listarContratacoes();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
