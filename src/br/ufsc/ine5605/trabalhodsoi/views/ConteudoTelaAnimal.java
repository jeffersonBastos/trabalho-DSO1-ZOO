package br.ufsc.ine5605.trabalhodsoi.views;
import br.ufsc.ine5605.trabalhodsoi.model.Habitat;
import br.ufsc.ine5605.trabalhodsoi.model.TipoAnimal;
import java.util.ArrayList;



public class ConteudoTelaAnimal {
    public int codigo;
    public String especie;
    public String nome;
    public String chegadaZoo;
    public TipoAnimal tipoAnimal;
    public Habitat habitat;

    public ConteudoTelaAnimal(int codigo, String especie, String nome, String chegadaZoo, TipoAnimal tipoAnimal, Habitat habitat) {
        this.codigo = codigo;
        this.especie = especie;
        this.nome = nome;
        this.chegadaZoo = chegadaZoo;
        this.tipoAnimal = tipoAnimal;
        this.habitat = habitat;
    }
    
    ConteudoTelaAnimal (){
        this.codigo = 0;
        this.especie = "";
        this.nome = "";
        this.chegadaZoo = "";
        this.tipoAnimal = null;
        this.habitat = null;
        
    }
}
