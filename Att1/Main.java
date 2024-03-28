package Att1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<Aluno> listaAluno = new ArrayList<>();
    static List<Curso> listaCurso = new ArrayList<>();
    static List<Matricula> listaMatricula = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            if (!inicializaPrograma()) {
                break;
            }
        }
    }

    public static boolean inicializaPrograma() {
        switch (imprimeMenu()) {
            case 1:
                cadastrarAluno();
                return true;
            case 2:
                cadastrarCurso();
                return true;
            case 3:
                realizarMatricula();
                return true;
            case 4:
                mostrarAlunos();
                return true;
            case 5:
                mostrarCursos();
                return true;
            case 6:
                mostrarMatriculas();
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
        System.out.println("Digite 1 - Cadastrar Aluno");
        System.out.println("Digite 2 - Cadastrar Curso");
        System.out.println("Digite 3 - Realizar Matricula");
        System.out.println("Digite 4 - Imprimir lista de alunos");
        System.out.println("Digite 5 - Imprimir lista de cursos");
        System.out.println("Digite 6 - Imprimir lista de matriculas");
        System.out.println("Digite 0 - Sair");
        System.out.println("************************************\n");
        return sc.nextInt();
    }

    public static void cadastrarAluno() {
        try {
            System.out.println("\nDigite o nome do aluno: ");
            sc.nextLine();
            String nome = sc.nextLine();

            System.out.println("\nDigite a matricula do aluno");
            int matricula = sc.nextInt();

            System.out.println("\nDigite a data de nascimento, yyyy-MM-dd: ");
            sc.nextLine();
            String dataNascimentoStr = sc.nextLine();
            LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            Aluno aluno = new Aluno(matricula, nome, dataNascimento);
            listaAluno.add(aluno);
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void cadastrarCurso() {
        try {
            System.out.println("\nDigite o nome do curso: ");
            sc.nextLine();
            String nome = sc.nextLine();

            System.out.println("\nDigite o numero do curso");
            int numero = sc.nextInt();

            System.out.println("\nDigite a data de inicio, yyyy-MM-dd: ");
            sc.nextLine();
            String dataNascimentoStr = sc.nextLine();
            LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            Curso curso = new Curso(numero, nome, dataNascimento);
            listaCurso.add(curso);
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void realizarMatricula() {
        try {
            System.out.println("\nDigite o numero do curso: ");
            int numeroCurso = sc.nextInt();

            Curso cursoEncontrado = null;
            for (Curso curso : listaCurso) {
                if (curso.getNumeroCurso() == numeroCurso) {
                    cursoEncontrado = curso;
                    break;
                }
            }
            if (cursoEncontrado == null) {
                System.out.println("\nCurso informado nao existente!");
                return;
            }

            System.out.println("\nDigite o numero da matricula do aluno: ");
            int numeroMatricula = sc.nextInt();

            Aluno alunoEncontrado = null;
            for (Aluno aluno : listaAluno) {
                if (aluno.getMatricula() == numeroMatricula) {
                    alunoEncontrado = aluno;
                    break;
                }
            }
            if (alunoEncontrado == null) {
                System.out.println("\nAluno informado nao existente!");
                return;
            }

            if (Matricula.calculaMaiorIdade(alunoEncontrado)) {
                Matricula matricula = new Matricula(cursoEncontrado, alunoEncontrado);
                listaMatricula.add(matricula);
            } else {
                System.out.println("\nAluno informado nao atende o requisito de maioriadade!");
                return;
            }

        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void mostrarAlunos() {
        System.out.println("Lista de alunos {");
        for (Aluno aluno : listaAluno) {
            System.out.println("\t" + aluno.toString());
        }
        System.out.println("}");
    }

    public static void mostrarCursos() {
        System.out.println("Lista de cursos {");
        for (Curso curso : listaCurso) {
            System.out.println("\t" + curso.toString());
        }
        System.out.println("}");
    }

    public static void mostrarMatriculas() {
        System.out.println("Lista de matriculas {");
        for (Matricula matricula : listaMatricula) {
            System.out.println("\t" + matricula.toString());
        }
        System.out.println("}");
    }

}