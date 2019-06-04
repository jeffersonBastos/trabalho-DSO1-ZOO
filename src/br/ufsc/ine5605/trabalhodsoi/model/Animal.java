/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodsoi.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jefferson
 */
public class Animal {
    
    private int codigo;
    private String especie;
    private String nome;
    private String ChegadaZoo;
    private TipoAnimal tipoAnimal;
    private Habitat habitat;
    private  ArrayList<AtividadeCuidador> atividadesCuidador = new ArrayList<>();
    private  ArrayList<AtividadeVeterinaria> atividadesVeterinaria = new ArrayList<>();
       

    public Animal(int codigo, String especie, String nome, String ChegadaZoo, TipoAnimal tipoAnimal, Habitat habitat) {
        this.codigo = codigo;
        this.especie = especie;
        this.nome = nome;
        this.ChegadaZoo = ChegadaZoo;
        this.tipoAnimal = tipoAnimal;
        this.habitat = habitat;
    }

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(TipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public void addAtividadeCuidador(AtividadeCuidador atividadeCuidador) {
        if(!atividadesCuidador.contains(atividadeCuidador)){
            atividadesCuidador.add(atividadeCuidador);
        }
        if(atividadeCuidador.getAnimal() != this){
            atividadeCuidador.setAnimal(this);
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getChegadaZoo() {
        return ChegadaZoo;
    }

    public void setChegadaZoo(String ChegadaZoo) {
        this.ChegadaZoo = ChegadaZoo;
    }
    
    public ArrayList<AtividadeCuidador> getAtividadesCuidador() {
        return atividadesCuidador;
    }

    public void setAtividadesCuidador(ArrayList<AtividadeCuidador> atividadesCuidador) {
        this.atividadesCuidador = atividadesCuidador;
    }

    public ArrayList<AtividadeVeterinaria> getAtividadesVeterinaria() {
        return atividadesVeterinaria;
    }

    public void setAtividadesVeterinaria(ArrayList<AtividadeVeterinaria> atividadesVeterinaria) {
        this.atividadesVeterinaria = atividadesVeterinaria;
    }

    public void addAtividadeVeterinaria(AtividadeVeterinaria atividadeVeterinaria) {
        if(!atividadesCuidador.contains(atividadeVeterinaria)){
            atividadesVeterinaria.add(atividadeVeterinaria);
        }
        if(atividadeVeterinaria.getAnimal() != this){
            atividadeVeterinaria.setAnimal(this);
        }
    }

    public void excluirAtividadeCuidador(String nome) {
        for (AtividadeCuidador a : atividadesCuidador){
            if (a.equals(nome)){
                atividadesCuidador.remove(a);
            }
        }
    }

    public void excluirAtividadeVeterinaria(String nome) {
        for (AtividadeCuidador a : atividadesCuidador){
            if (a.equals(nome)){
                atividadesCuidador.remove(a);
            }
        }
    }

}
