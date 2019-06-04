
package br.ufsc.ine5605.trabalhodsoi.exception;

public class AnimalNaoEncontradoException extends Exception{
    
    public AnimalNaoEncontradoException(){
        this("Animal não encontrado");
    }
    
    public AnimalNaoEncontradoException (String message){
        super(message);
    }
}
