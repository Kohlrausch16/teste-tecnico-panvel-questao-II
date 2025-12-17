package entities;

import entities.enums.StatusTarefa;

public class Tarefa {

    private String id;
    private String titulo;
    private String descricao;
    private StatusTarefa status;
    private String data;

    public Tarefa(String id, String titulo, String descricao, StatusTarefa status, String data){
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
