/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodsoi.model;

import java.util.Date;

/**
 *
 * @author jefferson
 */
public class AtividadeCuidador extends Atividade {
    
    private boolean comeu;
    private String qualComida;

    public AtividadeCuidador(String nome, boolean comeu, String qualComida, String data, 
            int cpfUsuario, String tarefas, Animal animal) {
        super(nome, data, cpfUsuario, tarefas, animal);
        this.comeu = comeu;
        this.qualComida = qualComida;
    }

    

    public boolean isComeu() {
        return comeu;
    }

    public void setComeu(boolean comeu) {
        this.comeu = comeu;
    }

    public String getQualComida() {
        return qualComida;
    }

    public void setQualComida(String qualComida) {
        this.qualComida = qualComida;
    }
    
    
    
}
