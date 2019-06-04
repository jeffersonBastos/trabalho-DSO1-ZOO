package br.ufsc.ine5605.trabalhodsoi.exception;


public class AnimalJahCadastradoException extends Exception {
    
    public AnimalJahCadastradoException(){
        this ("Animal ja cadastrado!");
    }

    public AnimalJahCadastradoException(String message){
        super(message);
    }
}
