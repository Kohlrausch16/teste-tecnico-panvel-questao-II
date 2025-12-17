import entities.ListaTarefas;
import entities.Tarefa;
import entities.enums.StatusTarefa;

import java.util.Scanner;

public class Main {

    private static ListaTarefas listaTarefas = new ListaTarefas();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Inicaliza controle do looping
        boolean continuar = true;

        // Enquanto continuar = true, exibir o menu
        while(continuar){

            System.out.println("\nInforme o número referente à opção desejada: ");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("3 - Listar tarefas");
            System.out.println("5 - Total de tarefas");
            System.out.println("0 - Encerrar programa");
            System.out.print("Opção: ");
            int opcaoMenu = sc.nextInt();
            // Limpando o buffer
            sc.nextLine();

            // Redireciona para a opção correspondente
            switch (opcaoMenu){
                case 0 -> continuar = false;
                case 1 -> adicionarTarefaMenu();
                case 3 -> listaTarefas.listar();
                case 5 -> listaTarefas.total();
            }
        }

        System.out.print("\nEncerrando execução do programa...");
    }

    private static void adicionarTarefaMenu(){
        // Captura os dados digitados pelo usuário
        System.out.print("\nId da tarefa: ");
        String id = sc.nextLine();

        System.out.print("Título da tarefa: ");
        String titulo = sc.nextLine();

        System.out.print("Descrição da tarefa: ");
        String descricao = sc.nextLine();

        System.out.print("Status da tarefa (PENDENTE/EM_ANDAMENTO): ");
        String statusDigitado = sc.nextLine().toUpperCase();
        StatusTarefa status = StatusTarefa.valueOf(statusDigitado);

        System.out.print("Data da tarefa: ");
        String data = sc.nextLine();

        // Cria intância da classe Tarefa
        Tarefa tarefa = new Tarefa(id, titulo, descricao, status, data);

        // Adiciona a tarefa à lista
        listaTarefas.adicionar(tarefa);
    }
}