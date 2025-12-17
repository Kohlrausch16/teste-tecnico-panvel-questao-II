package entities;

import entities.enums.StatusTarefa;

import java.util.ArrayList;

public class ListaTarefas {

    private ArrayList<Tarefa> listaTarefas = new ArrayList<>();

    public ListaTarefas(){}

    public void adicionar(Tarefa tarefa){
        this.listaTarefas.add(tarefa);
    }

    public void listar(){
        // Verifica se a lista está vazia
        if(this.listaTarefas.isEmpty()){
            System.out.println("Não há elementos na lista :(");
        } else {
            // Caso não, chama um método de impressão para cada tarefa
            this.listaTarefas.stream().forEach(tarefa -> this.imprimirTarefa(tarefa));
        }
    }

    private void imprimirTarefa(Tarefa tarefa){
        System.out.println("----------------------------");
        System.out.println("TAREFA " + tarefa.getId());
        System.out.println("Titulo: " + tarefa.getTitulo());
        System.out.println("Descrição: " + tarefa.getDescricao());
        System.out.println("Status: " + tarefa.getStatus());
        System.out.println("Data: " + tarefa.getData());
    }

    public void total(){
        System.out.println("\nA lista contém " + this.listaTarefas.size() + " tarefas");
    }
}
