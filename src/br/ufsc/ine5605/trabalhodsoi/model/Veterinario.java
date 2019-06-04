/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodsoi.model;



/**
 *
 * @author jefferson
 */
public class Veterinario extends Funcionario {
    
    private int CRMV;

    public Veterinario(int CRMV, long CPF, int RG, String nome, int numContrato){
        super(CPF, RG, nome, numContrato);
        this.CRMV = CRMV;
    }

    public int getCRMV() {
        return CRMV;
    }

    public void setCRMV(int CRMV) {
        this.CRMV = CRMV;
    }
    
    
}
