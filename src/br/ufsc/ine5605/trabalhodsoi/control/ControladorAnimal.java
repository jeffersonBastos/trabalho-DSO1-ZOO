package br.ufsc.ine5605.trabalhodsoi.control;
import br.ufsc.ine5605.trabalhodsoi.exception.AnimalJahCadastradoException;
import br.ufsc.ine5605.trabalhodsoi.exception.AnimalNaoEncontradoException;
import br.ufsc.ine5605.trabalhodsoi.model.Animal;
import br.ufsc.ine5605.trabalhodsoi.model.Atividade;
import br.ufsc.ine5605.trabalhodsoi.model.AtividadeCuidador;
import br.ufsc.ine5605.trabalhodsoi.model.AtividadeVeterinaria;
import br.ufsc.ine5605.trabalhodsoi.model.Habitat;
import br.ufsc.ine5605.trabalhodsoi.views.ConteudoTelaAnimal;
import br.ufsc.ine5605.trabalhodsoi.views.TelaAnimal;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class ControladorAnimal {
    
    private ControladorPrincipal controladorPrincipal;
    private TelaAnimal telaAnimal;
    private ArrayList<Animal> animais;
    
    //teste pra ver se funciona o git
    
    public ControladorAnimal(ControladorPrincipal controladorPrincipal){
        this.controladorPrincipal = controladorPrincipal;
        animais = new ArrayList<Animal>();
        telaAnimal = new TelaAnimal(this);
    }
    
    public void mostrarMenuAnimal() throws AnimalNaoEncontradoException{
        telaAnimal.mostraMenuAnimal();
    }
       
    public void incluirAnimal (ConteudoTelaAnimal conteudoTelaAnimal) throws AnimalJahCadastradoException {
        for (Animal animal : animais){
            if (animal.getCodigo() == conteudoTelaAnimal.codigo){
                throw new AnimalJahCadastradoException();
            }
        }
        Animal animal = desempacota(conteudoTelaAnimal);
        animais.add(animal);
    }   
    
    public void excluirAnimal(int codigo) throws AnimalNaoEncontradoException {
        Animal animal  = buscaAnimalPorCodigo (codigo);
        if (animal == null){
            throw new AnimalNaoEncontradoException();
        }
        animais.remove(animal);
    }
    
    public void listarAnimais(){
        ArrayList<ConteudoTelaAnimal> listagemAnimais = new ArrayList<>();
        
        for (Animal animal : animais){
            listagemAnimais.add(empacota(animal));
        }
        
        telaAnimal.mostrarListaAnimais(listagemAnimais);
    }
    
    public Animal buscaAnimalPorCodigo (int codigo) throws AnimalNaoEncontradoException {
        
        Animal an = null;
        
        for (Animal animal : animais){
            if (animal.getCodigo() == codigo){
                an = animal;
            }
        }
        if (an == null){
            throw new AnimalNaoEncontradoException();
        }    
        return an;
    }
    
     public Animal desempacota(ConteudoTelaAnimal conteudoTelaAnimal) {   
        return new Animal(conteudoTelaAnimal.codigo, conteudoTelaAnimal.especie, conteudoTelaAnimal.nome, conteudoTelaAnimal.chegadaZoo, conteudoTelaAnimal.tipoAnimal, conteudoTelaAnimal.habitat);
    }

    private ConteudoTelaAnimal empacota(Animal animal) {
        return new ConteudoTelaAnimal(animal.getCodigo(), animal.getEspecie(), animal.getNome(), animal.getChegadaZoo(),animal.getTipoAnimal(), animal.getHabitat());
    }
    
    public boolean verificaExisteAnimal(int codigo){
       
        boolean existeAnimal = false;
        
        for (Animal an : animais){
            if (codigo == an.getCodigo()){
                existeAnimal = true;
            }
        }
        return existeAnimal;
    }

   

    public void addAtividadeCuidador(AtividadeCuidador atividadeCuidador, Animal animal){
        animal.addAtividadeCuidador(atividadeCuidador);
    }

    public void addAtividadeVeterinario(AtividadeVeterinaria atividadeVeterinaria, Animal animal){
        animal.addAtividadeVeterinaria(atividadeVeterinaria);
    }

    

    public void preCasdastro() {
        
    }

    public boolean verificaExisteHabitat(String nomeHabitat) {
        return controladorPrincipal.verificaSeExisteHabitat(nomeHabitat);
    }

    public Habitat buscaHabitat(String nomeHabitat) {
        return controladorPrincipal.buscaHabitat(nomeHabitat);
    }

    public void listaHabitat() {
        controladorPrincipal.listaHabitat();
    }

    
}