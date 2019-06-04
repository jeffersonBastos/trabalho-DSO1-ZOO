package br.ufsc.ine5605.trabalhodsoi.model;

import java.util.Date;

/**
 *
 * @author jefferson
 */
public class AtividadeVeterinaria extends Atividade {
    
    private String nome;
    private String remedio;
    private String saude;

    public AtividadeVeterinaria(String nome, String remedio, String saude, String data, long cpfUsuario, String tarefas, Animal animal) {
        super(nome, data, cpfUsuario, tarefas, animal);
        this.remedio = remedio;
        this.saude = saude;
    }

    
    public String getRemedio() {
        return remedio;
    }

    public void setRemedio(String remedio) {
        this.remedio = remedio;
    }

    public String getSaude() {
        return saude;
    }

    public void setSaude(String saude) {
        this.saude = saude;
    }
    
    
    
    
}