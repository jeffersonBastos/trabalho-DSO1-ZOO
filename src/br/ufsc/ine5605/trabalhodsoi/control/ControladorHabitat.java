package br.ufsc.ine5605.trabalhodsoi.control;

import java.util.ArrayList;
import br.ufsc.ine5605.trabalhodsoi.control.ControladorPrincipal;
import br.ufsc.ine5605.trabalhodsoi.exception.AnimalNaoEncontradoException;
import br.ufsc.ine5605.trabalhodsoi.model.Animal;
import br.ufsc.ine5605.trabalhodsoi.model.Habitat;
import br.ufsc.ine5605.trabalhodsoi.model.TipoAnimal;
import br.ufsc.ine5605.trabalhodsoi.views.TelaHabitat;
import br.ufsc.ine5605.trabalhodsoi.model.InterfaceListar;
/**
 *
 * @author jefferson
 */
public class ControladorHabitat implements InterfaceListar{
    private ArrayList<Habitat> habitats;
    private TelaHabitat telaHabitat;
    private ControladorPrincipal controladorPrincipal;

    public ControladorHabitat(ControladorPrincipal controladorPrincipal){
        habitats = new ArrayList<>();
        this.controladorPrincipal = controladorPrincipal;
        this.telaHabitat = new TelaHabitat(this);
    }
    public void inicia() throws AnimalNaoEncontradoException{
        telaHabitat.inicia();
    }

    public void listar() {
       telaHabitat.mostrarListaHabitat(habitats);
    }

    public void inserirHabitat(String nome, TipoAnimal tipo) {
        Habitat habitat= new Habitat(nome, tipo);
        if(!verificaExisteHabitat(nome)){
            habitats.add(habitat);
        }else{   
            telaHabitat.exibeErroHabitatJaCadastrado();
        }    
       
    }

    public boolean verificaExisteHabitat(String nome) {
        for(Habitat h : habitats){
            if(h.getNome()== nome){
            return true;
            }
        }
        return false;     
    }

    public boolean incluiAnimal(int codigo, String nomeHabitat) throws AnimalNaoEncontradoException {
        if(!controladorPrincipal.verificaSeExisteAnimal(codigo)){
            return false;
        }else{
            buscaHabitat(nomeHabitat).addAnimal(controladorPrincipal.buscaAnimalPorCodigo(codigo));
            return true;
        }
    
    }

    public void listaAnimalHabitat(String nome) {
        telaHabitat.exibeListaAnimal(buscaAnimais(buscaHabitat(nome)));
        
    }
    public ArrayList<Animal> buscaAnimais(Habitat habitat){
       return habitat.getAnimais();
    }
    public Habitat buscaHabitat(String nome){
        for(Habitat h : habitats){
            if(h.getNome() == nome){
                return h;
            }
        }
        return null;
    }

    public void excluiHabitat(String nome) {
        habitats.remove(buscaHabitat(nome));
    }

    public void preCasdastro() {
        String Nome ="jaula leao";
        TipoAnimal tipo =TipoAnimal.MAMIFERO;
        inserirHabitat(Nome, tipo);
        
        Nome ="aviario";
        tipo =TipoAnimal.AVE;
        inserirHabitat(Nome, tipo);
        
        Nome = "Lago";
        tipo = TipoAnimal.REPTIL;
        inserirHabitat(Nome, tipo);
    }

    public void listarAnimais() {
        controladorPrincipal.listaAnimais();
    }
}