package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import entities.Aluno;
import jdbc.AlunoJDBC;

public class Program {

	public static void main(String[] args) {

		try {

			int opcao = 0;
			Scanner console = new Scanner(System.in);
			AlunoJDBC acao = new AlunoJDBC();
			do {
				System.out.println("\n####### Menu #######" + "\n1 - Cadastrar" + "\n2 - Listar" + "\n3 - Alterar"
						+ "\n4 - Excluir" + "\n5 - Sair");
				System.out.println("\nOpção:");
				opcao = Integer.parseInt(console.nextLine());
				switch (opcao) {
				case 1: {
					Aluno a = new Aluno();

					System.out.println("\n ### Cadastrar Aluno ### \n\r");

					System.out.print("Nome: ");
					a.setNome(console.nextLine());

					System.out.print("Sexo: ");
					a.setSexo(console.nextLine());

					System.out.print("Data de Nascimento (dd-mm-aaaa): ");
					DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					a.setDt_nasc(LocalDate.parse(console.nextLine(), formato));

					acao.salvar(a);
					System.out.println("\nCadastro do aluno realizado com sucesso!");
					break;
				}
				case 2: {
					List<Aluno> lista = acao.listar();
					System.out.println("\nLISTAGEM DE ALUNOS");
					for (Aluno aluno : lista) {
						System.out
								.println("**************************************************************************");
						System.out.println("Nome: " + aluno.getNome() + ", Sexo: " + aluno.getSexo() + ", Data Nasc.: "
								+ aluno.getDt_nasc() + ", Id: " + aluno.getId());
						System.out
								.println("**************************************************************************");
					}
					System.out.println("FIM DA LISTAGEM\n");
					break;
				}
				case 3: {
					System.out.print("\n Informe o ID de quem deseja alterar: ");
					int idAlterar = console.nextInt();
					
					console.nextLine();

					System.out.print("\n Insira o valor para nome: ");
					String nomeAlterar = console.nextLine();

					System.out.print("\n Insira o valor para o sexo: ");
					String sexoAlterar = console.nextLine();

					System.out.print("\n Informe o valor para a data de nascimento: ");
					DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate dtNascimentoAlterar = LocalDate.parse(console.nextLine(), formato);

					acao.alterar(idAlterar, nomeAlterar, sexoAlterar, dtNascimentoAlterar);
					System.out.println("\nAluno alterado com sucesso!");
					break;
				}
				case 4: {
					System.out.print("\n Informe o ID de quem deseja excluir: ");
					acao.apagar(console.nextInt());
					break;
				}
				default:
					break;
				}
			} while (opcao != 5);
			System.out.println("\n\n\nPROGRAMA FINALIZADO!");
			acao.fecharConexaoPst();
			console.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
