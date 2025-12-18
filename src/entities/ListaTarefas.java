package entities;

import entities.enums.StatusTarefa;

import java.util.ArrayList;
import java.util.Optional;

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

    public void remover(String id) {
        // Busca tarefa com base no id informado
        Tarefa tarefa = this.buscarTarefaPorId(id);

        // Caso a tarefa tenha sido encontrada, remove esta;
        if (tarefa != null) {
            this.listaTarefas.remove(tarefa);
            System.out.println("Tarefa " + id + " deletada com sucesso!");
        }
    }

    public void marcarConcluida(String id){
        // Busca tarefa com base no id informado
        Tarefa tarefa= this.buscarTarefaPorId(id);
        // Extrai o index da tarefa dentro da lista
        int index = this.listaTarefas.indexOf(tarefa);

        // Caso a tarefa tenha sido encontrada, atualiza o status desta;
        if (tarefa != null) {
            tarefa.setStatus(StatusTarefa.FINALIZADA);
            // Sobrescreve a tarefa na lista com base no id encontrado
            this.listaTarefas.set(index, tarefa);
            System.out.println("Tarefa " + id + " atualizada com sucesso!");
        }
    }

    private Tarefa buscarTarefaPorId(String id){
        // Percorre a lista e busca por uma tarefa com o id iqual ao informado
        Optional<Tarefa> tarefaEncontrada = this.listaTarefas.stream().filter(tarefa -> tarefa.getId().equals(id)).findFirst();

        // Se a tarefa não for econtrada, retorna null
        if(tarefaEncontrada.isEmpty()) {
            System.out.println("Tarefa " + id + " não encontrada");
            return null;
        }

        // Caso encontrada, retorna a tarefa
        return tarefaEncontrada.get();
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
