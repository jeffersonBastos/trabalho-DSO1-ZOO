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
public abstract class Funcionario {
    
    private long CPF;
    private int RG;
    private String nome;
    private int numContrato;

    public Funcionario(long CPF, int RG, String nome, int numContrato) {
        this.CPF = CPF;
        this.RG = RG;
        this.nome = nome;
        this.numContrato = numContrato;
    }
    

    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

    public int getRG() {
        return RG;
    }

    public void setRG(int RG) {
        this.RG = RG;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumContrato() {
        return numContrato;
    }

    public void setNumContrato(int numContrato) {
        this.numContrato = numContrato;
    }

    
   
    


    
}
