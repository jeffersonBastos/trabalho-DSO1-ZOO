/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodsoi.views;

/**
 *
 * @author jefferson
 */
public class ConteudoTelaCuidador {
     
    private int CPF;
    private int RG;
    private String nome;
    private int numContrato;

    public ConteudoTelaCuidador(int CPF, int RG, String nome, int numContrato) {
        this.CPF = CPF;
        this.RG = RG;
        this.nome = nome;
        this.numContrato = numContrato;
    }
    ConteudoTelaCuidador() {
        this.CPF = 0;
        this.RG = 0;
        this.nome = "";
        this.numContrato = 0;
        
    }

    
}
