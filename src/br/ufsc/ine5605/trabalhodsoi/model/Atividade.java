package br.ufsc.ine5605.trabalhodsoi.model;


/**
 *
 * @author jefferson
 */
public abstract class Atividade {
    
    private String nome;
    private String data;
    private long cpfUsuario;
    private String tarefas;
    private Animal animal;

    public Atividade(String nome, String data, long cpfUsuario, String tarefas, Animal animal) {
        this.nome = nome;
        this.data = data;
        this.cpfUsuario = cpfUsuario;
        this.tarefas = tarefas;
        this.animal = animal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(long cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public String getTarefas() {
        return tarefas;
    }

    public void setTarefas(String tarefas) {
        this.tarefas = tarefas;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    
    
    
}