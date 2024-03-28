package AtividadeAvaliativa;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static List<EventoPeriodico> listaEventoPeriodico = new ArrayList<>();
	static List<EventoRecorrente> listaEventoRecorrente = new ArrayList<>();
	static List<EventoUnico> listaEventoUnico = new ArrayList<>();
	static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) {
		try {
			while (true) {
				if (!inicializaPrograma()) {
					break;
				}
			}
		} catch (Exception e) {
		}
	}

	public static boolean inicializaPrograma() throws Exception {
		switch (imprimeMenu()) {
		case 1:
			cadastrarEvento();
			return true;
		case 2:
			cadastrarConvidado();
			return true;
		case 3:
			imprimirEventos();
			return true;
		case 0:
			return false;
		default:
			System.out.println("Digite um numero valido!");
			return true;
		}
	}

	public static int imprimeMenu() {
		System.out.println("\n************************************");
		System.out.println("Digite 1 - Cadastrar Evento");
		System.out.println("Digite 2 - Cadastrar Convidado");
		System.out.println("Digite 3 - Imprimir lista de eventos e seus convidados");
		System.out.println("Digite 0 - Sair");
		System.out.println("************************************\n");
		return sc.nextInt();
	}

	public static void imprimirEventos() {
		int tipoEvento = imprimeMenuTipoEvento();
		if (tipoEvento == 1) {
			for (EventoUnico ev : listaEventoUnico) {
				System.out.println(ev.toString());
				ev.listarConvidados();
			}
		} else if (tipoEvento == 2) {
			for (EventoPeriodico ev : listaEventoPeriodico) {
				System.out.println(ev.toString());
				ev.listarConvidados();
			}
		} else if (tipoEvento == 3) {
			for (EventoRecorrente ev : listaEventoRecorrente) {
				System.out.println(ev.toString());
				ev.listarConvidados();
			}
		} else {
			System.out.println("numero invalido");
			return;
		}
	}

	public static int imprimeMenuTipoEvento() {
		System.out.println("\n************************************");
		System.out.println("Digite 1 - Evento Unico");
		System.out.println("Digite 2 - Evento Periodico");
		System.out.println("Digite 3 - Evento Recorrente");
		System.out.println("************************************\n");
		return sc.nextInt();
	}

	public static void cadastrarConvidado() throws Exception {
		System.out.println("Informe o tipo de evento que deseja cadastrar o convidado!");
		int tipoEvento = imprimeMenuTipoEvento();
		while (true) {
			switch (tipoEvento) {
			case (1):
				cadastrarConvidadoEventoUnico();
				return;
			case (2):
				cadastrarConvidadoEventoPeriodico();
				return;
			case (3):
				cadastrarConvidadoEventoRecorrente();
				return;
			default:
				System.out.println("Informe uma opcao valida");
			}
		}
	}

	public static void cadastrarConvidadoEventoUnico() throws Exception {
		int posicaoEvento = imprimeListaEventosUnicos();
		if (posicaoEvento == 0) {
			return;
		} else {
			if (listaEventoUnico.size() <= (posicaoEvento--)) {
				return;
			} else {
				EventoUnico ev = listaEventoUnico.get(posicaoEvento);
				System.out.println("Informe o nome do convidado");
				sc.nextLine();
				String nome = sc.nextLine();

				Convidado cv = new Convidado(nome);
				ev.adicionarConvidado(cv);
			}
		}
	}

	public static int imprimeListaEventosUnicos() throws Exception {
		if (listaEventoUnico.isEmpty()) {
			return 0;
		}
		System.out.println("Qual desses eventos deseja cadastrar");
		System.out.println("\n************************************");
		List<Integer> listaIndices = new ArrayList<>();
		int i = 1;
		for (EventoUnico ev : listaEventoUnico) {
			System.out.println("Posicao " + i + ": " + ev.toString());
			listaIndices.add(i);
			i++;
		}
		System.out.println("************************************\n");
		if (!listaIndices.contains(sc.nextInt())) {
			throw new Exception("Evento informado invalido");
		}
		listaIndices = null;
		return sc.nextInt();
	}

	public static void cadastrarConvidadoEventoPeriodico() throws Exception {
		int posicaoEvento = imprimeListaEventosPeriodicos();
		if (posicaoEvento == 0) {
			return;
		} else {
			if (listaEventoUnico.size() <= (posicaoEvento--)) {
				return;
			} else {
				EventoPeriodico ev = listaEventoPeriodico.get(posicaoEvento);
				System.out.println("Informe o nome do convidado");
				sc.nextLine();
				String nome = sc.nextLine();

				Convidado cv = new Convidado(nome);
				ev.adicionarConvidado(cv);
			}
		}
	}

	public static int imprimeListaEventosPeriodicos() throws Exception {
		if (listaEventoPeriodico.isEmpty()) {
			return 0;
		}
		System.out.println("Qual desses eventos deseja cadastrar");
		System.out.println("\n************************************");
		List<Integer> listaIndices = new ArrayList<>();
		int i = 1;
		for (EventoPeriodico ev : listaEventoPeriodico) {
			System.out.println("Posicao " + i + ": " + ev.toString());
			listaIndices.add(i);
			i++;
		}
		System.out.println("************************************\n");
		if (!listaIndices.contains(sc.nextInt())) {
			throw new Exception("Evento informado invalido");
		}
		listaIndices = null;
		return sc.nextInt();
	}

	public static void cadastrarConvidadoEventoRecorrente() throws Exception {
		int posicaoEvento = imprimeListaEventosPeriodicos();
		if (posicaoEvento == 0) {
			return;
		} else {
			if (listaEventoUnico.size() <= (posicaoEvento--)) {
				return;
			} else {
				EventoRecorrente ev = listaEventoRecorrente.get(posicaoEvento);
				System.out.println("Informe o nome do convidado");
				sc.nextLine();
				String nome = sc.nextLine();

				Convidado cv = new Convidado(nome);
				ev.adicionarConvidado(cv);
			}
		}
	}

	public static int imprimeListaEventosRecorrentess() throws Exception {
		if (listaEventoRecorrente.isEmpty()) {
			return 0;
		}
		System.out.println("Qual desses eventos deseja cadastrar");
		System.out.println("\n************************************");
		List<Integer> listaIndices = new ArrayList<>();
		int i = 1;
		for (EventoRecorrente ev : listaEventoRecorrente) {
			System.out.println("Posicao " + i + ": " + ev.toString());
			listaIndices.add(i);
			i++;
		}
		System.out.println("************************************\n");
		if (!listaIndices.contains(sc.nextInt())) {
			throw new Exception("Evento informado invalido");
		}
		listaIndices = null;
		return sc.nextInt();
	}

	public static void cadastrarEvento() throws Exception {
		int tipoEvento = imprimeMenuTipoEvento();
		while (true) {
			switch (tipoEvento) {
			case (1):
				cadastrarEventoUnico();
				return;
			case (2):
				cadastrarEventoPeriodico();
				return;
			case (3):
				cadastrarEventoRecorrente();
				return;
			default:
				System.out.println("Informe uma opcao valida");
			}
		}
	}

	public static void cadastrarEventoPeriodico() throws Exception {

		System.out.println("\nDigite o nome do evento: ");
		sc.nextLine();
		String nome = sc.nextLine();

		System.out.println("\nDigite a descricao do evento");
		String descricao = sc.nextLine();

		Date dataInicio = null;
		try {
			System.out.println("\nDigite a data de inicio, dd/MM/yyyy: ");
			sc.nextLine();
			String dataInicioStr = sc.nextLine();
			dataInicio = df.parse(dataInicioStr);
		} catch (Exception e) {
			throw new DataInvalidException("Formato de data de inicio invalido");
		}
		if (dataInicio == null) {
			throw new DataInvalidException("Erro ao definir data de inicio, null!");
		}

		Date dataTermino = null;
		try {
			System.out.println("\nDigite a data de termino, dd/MM/yyyy: ");
			sc.nextLine();
			String dataTerminoStr = sc.nextLine();
			dataTermino = df.parse(dataTerminoStr);
		} catch (Exception e) {
			throw new DataInvalidException("Formato de data de termino invalido");
		}
		if (dataTermino == null) {
			throw new DataInvalidException("Erro ao definir data de termino, null!");
		}

		System.out.println("\nDigite o local do evento: ");
		sc.nextLine();
		String local = sc.nextLine();

		DiaSemana dia = imprimeMenuDiaSemana();

		EventoPeriodico ev = new EventoPeriodico(nome, descricao, dataInicio, dataTermino, local, dia);
		listaEventoPeriodico.add(ev);

	}

	public static DiaSemana imprimeMenuDiaSemana() {
		System.out.println("\n************************************");
		System.out.println("Digite 1 - Domingo");
		System.out.println("Digite 2 - Segunda");
		System.out.println("Digite 3 - Terca");
		System.out.println("Digite 4 - Quarta");
		System.out.println("Digite 5 - Quinta");
		System.out.println("Digite 6 - Sexta");
		System.out.println("Digite 7 - Sabado");
		System.out.println("************************************\n");
		while (true) {
			switch (sc.nextInt()) {
			case (1):
				return DiaSemana.DOMINGO;
			case (2):
				return DiaSemana.SEGUNDA;
			case (3):
				return DiaSemana.TERCA;
			case (4):
				return DiaSemana.QUARTA;
			case (5):
				return DiaSemana.QUINTA;
			case (6):
				return DiaSemana.SEXTA;
			case (7):
				return DiaSemana.SABADO;
			default:
				System.out.println("Informe um numero valido");
			}
		}
	}

	public static void cadastrarEventoUnico() throws Exception {
		System.out.println("\nDigite o nome do evento: ");
		sc.nextLine();
		String nome = sc.nextLine();

		System.out.println("\nDigite a descricao do evento");
		String descricao = sc.nextLine();

		Date dataInicio = null;
		try {
			System.out.println("\nDigite a data de inicio, dd/MM/yyyy: ");
			sc.nextLine();
			String dataInicioStr = sc.nextLine();
			dataInicio = df.parse(dataInicioStr);
		} catch (Exception e) {
			throw new DataInvalidException("Formato de data de inicio invalido");
		}
		if (dataInicio == null) {
			throw new DataInvalidException("Erro ao definir data de inicio, null!");
		}

		Date dataTermino = null;
		try {
			System.out.println("\nDigite a data de termino, dd/MM/yyyy: ");
			sc.nextLine();
			String dataTerminoStr = sc.nextLine();
			dataTermino = df.parse(dataTerminoStr);
		} catch (Exception e) {
			throw new DataInvalidException("Formato de data de termino invalido");
		}
		if (dataTermino == null) {
			throw new DataInvalidException("Erro ao definir data de termino, null!");
		}

		System.out.println("\nDigite o local do evento: ");
		sc.nextLine();
		String local = sc.nextLine();

		EventoUnico ev = new EventoUnico(nome, descricao, dataInicio, dataTermino, local);
		listaEventoUnico.add(ev);
	}

	public static void cadastrarEventoRecorrente() throws Exception {
		System.out.println("\nDigite o nome do evento: ");
		sc.nextLine();
		String nome = sc.nextLine();

		System.out.println("\nDigite a descricao do evento");
		String descricao = sc.nextLine();

		Date dataInicio = null;
		try {
			System.out.println("\nDigite a data de inicio, dd/MM/yyyy: ");
			sc.nextLine();
			String dataInicioStr = sc.nextLine();
			dataInicio = df.parse(dataInicioStr);
		} catch (Exception e) {
			throw new DataInvalidException("Formato de data de inicio invalido");
		}
		if (dataInicio == null) {
			throw new DataInvalidException("Erro ao definir data de inicio, null!");
		}

		Date dataTermino = null;
		try {
			System.out.println("\nDigite a data de termino, dd/MM/yyyy: ");
			sc.nextLine();
			String dataTerminoStr = sc.nextLine();
			dataTermino = df.parse(dataTerminoStr);
		} catch (Exception e) {
			throw new DataInvalidException("Formato de data de termino invalido");
		}
		if (dataTermino == null) {
			throw new DataInvalidException("Erro ao definir data de termino, null!");
		}

		System.out.println("\nDigite o local do evento: ");
		sc.nextLine();
		String local = sc.nextLine();

		EventoRecorrente ev = new EventoRecorrente(nome, descricao, dataInicio, dataTermino, local);
		listaEventoRecorrente.add(ev);
	}
}
