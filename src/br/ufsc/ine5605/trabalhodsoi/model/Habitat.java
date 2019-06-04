package br.ufsc.ine5605.trabalhodsoi.model;

import java.util.ArrayList;

/**
 *
 * @author jefferson
 */
public class Habitat {
    
    private ArrayList<Animal> animais = new ArrayList<>();
    private String nome;
    private TipoAnimal tipo;

    public Habitat(String nome, TipoAnimal tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public ArrayList<Animal> getAnimais() {
        return animais;
    }
    
    //adiciona animal
    public void addAnimal(Animal animal) {
        if(!animais.contains(animal)){
            animais.add(animal);
        }
        if(animal.getHabitat() != this){
            animal.setHabitat(this);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoAnimal getTipo() {
        return tipo;
    }

    public void setTipo(TipoAnimal tipo) {
        this.tipo = tipo;
    }
    
    
}

