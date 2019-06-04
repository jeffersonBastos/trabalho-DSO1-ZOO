package br.ufsc.ine5605.trabalhodsoi.control;

import br.ufsc.ine5605.trabalhodsoi.exception.AnimalNaoEncontradoException;
import br.ufsc.ine5605.trabalhodsoi.model.Animal;
import br.ufsc.ine5605.trabalhodsoi.model.Habitat;
import br.ufsc.ine5605.trabalhodsoi.views.TelaPrincipal;



/**
 *
 * @author jefferson
 */
public class ControladorPrincipal {


    private TelaPrincipal telaPrincipal;
    ControladorAnimal controladorAnimal;
    private ControladorFuncionario controladorFuncionario;
    private ControladorHabitat controladorHabitat;
    ControladorAtividade controladorAtividade;
    
    public ControladorPrincipal(){
        telaPrincipal = new TelaPrincipal(this);
        controladorAnimal = new ControladorAnimal(this);
        controladorFuncionario = new ControladorFuncionario(this);
        controladorHabitat = new ControladorHabitat(this);
        controladorAtividade = new ControladorAtividade(this);
    }
    
    public void inicia() throws AnimalNaoEncontradoException{
        telaPrincipal.inicia();
    }    
    
    public void iniciaTelaAnimal() throws AnimalNaoEncontradoException {
        controladorAnimal.mostrarMenuAnimal();
    }

    public void iniciaTelaFuncionario() {
        controladorFuncionario.inicia();
    }

    public  void iniciaTelaHabitat() throws AnimalNaoEncontradoException {
        controladorHabitat.inicia();
    }
    
    public void iniciaTelaAtividade() throws AnimalNaoEncontradoException {
        controladorAtividade.inicia();
    }

    public boolean verificaSeExisteAnimal(int codigo) {
        return controladorAnimal.verificaExisteAnimal(codigo);
    }

    public Animal buscaAnimalPorCodigo(int codigo) throws AnimalNaoEncontradoException {
        return controladorAnimal.buscaAnimalPorCodigo(codigo);
    }

    public void iniciaPreCadastro() {
        controladorFuncionario.preCadastro();
        controladorHabitat.preCasdastro();
    }

    public  boolean verificaSeExisteHabitat(String nomeHabitat) {
        return controladorHabitat.verificaExisteHabitat(nomeHabitat);
    }

    public Habitat buscaHabitat(String nomeHabitat) {
        return controladorHabitat.buscaHabitat(nomeHabitat);
    }

    public void listaHabitat() {
        controladorHabitat.listar();
    }

    public void listaAnimais() {
        controladorAnimal.listarAnimais();
    }
}
    
