package br.ufsc.ine5605.trabalhodsoi.control;
import br.ufsc.ine5605.trabalhodsoi.exception.AnimalNaoEncontradoException;
import br.ufsc.ine5605.trabalhodsoi.model.Animal;
import br.ufsc.ine5605.trabalhodsoi.model.Atividade;
import br.ufsc.ine5605.trabalhodsoi.model.AtividadeCuidador;
import br.ufsc.ine5605.trabalhodsoi.model.AtividadeVeterinaria;
import br.ufsc.ine5605.trabalhodsoi.views.TelaAtividade;
import java.util.ArrayList;

public class ControladorAtividade {
    
    private ArrayList<AtividadeCuidador> atividadesCuidador = new ArrayList<>();
    private ArrayList<AtividadeVeterinaria> atividadesVeterinaria = new ArrayList<>();
    private TelaAtividade telaAtividade;
    private ControladorPrincipal controladorPrincipal;

    public ControladorAtividade(ControladorPrincipal controladorPrincipal) {
        this.controladorPrincipal = controladorPrincipal;
        atividadesCuidador = new ArrayList<>();
        atividadesVeterinaria = new ArrayList<>();
        this.telaAtividade = new TelaAtividade(this);
    }
    public void inicia() throws AnimalNaoEncontradoException{
        telaAtividade.mostraMenuAtividades();
    }

    
    public void addAtividadeCuidador(AtividadeCuidador atividade) {
        atividadesCuidador.add(atividade);
    }
  
    public void delAtividadeCuidador(String nome) {
        for (AtividadeCuidador atividade : atividadesCuidador){
            if (atividade.getNome().equals(nome)){
               atividadesCuidador.remove(atividade);
            }
        }
    }

    public void addAtividadeVeterinaria(AtividadeVeterinaria atividade) {
        atividadesVeterinaria.add(atividade);
    }

    public void delAtividadeVeterinaria(String nome) {
        for (AtividadeVeterinaria atividade : atividadesVeterinaria){
            if (atividade.getNome().equals(nome)){
               atividadesVeterinaria.remove(atividade);
            }
        }
    }

    public void exibeAtividadesCuidador(){
        for (AtividadeCuidador atividade : atividadesCuidador){
            
        }
    }
   
    public Animal buscaAnimalPorCodigo(int codigo) throws AnimalNaoEncontradoException {
        return controladorPrincipal.controladorAnimal.buscaAnimalPorCodigo(codigo);
    }

    public void cadastraAtividadeCuidador(int codigo, String nome, boolean comeu, String qualComida, String data, long cpfUsuario, String tarefas) throws AnimalNaoEncontradoException {
        Animal animal = buscaAnimalPorCodigo(codigo);
        AtividadeCuidador atividadeCuidador = new AtividadeCuidador(nome, comeu, qualComida, data, (int) cpfUsuario, tarefas, animal);
        controladorPrincipal.controladorAnimal.addAtividadeCuidador(atividadeCuidador, animal);
        atividadesCuidador.add(atividadeCuidador);
    }
    
    public void cadastraAtividadeVeterinario(int codigo, String nome, String remedioDado,String saude, String data, long cpfUsuario, String tarefas) throws AnimalNaoEncontradoException {
        Animal animal = buscaAnimalPorCodigo(codigo);
        AtividadeVeterinaria atividadeVeterinario = new AtividadeVeterinaria(nome, remedioDado, saude, data, 
             cpfUsuario, tarefas, animal);
        controladorPrincipal.controladorAnimal.addAtividadeVeterinario(atividadeVeterinario, animal);
        atividadesVeterinaria.add(atividadeVeterinario);
    }

    public void excluirAtividadeCuidador(int codigo, String nome) throws AnimalNaoEncontradoException {
       Animal animal = buscaAnimalPorCodigo(codigo);
       animal.excluirAtividadeCuidador(nome);
       for (AtividadeCuidador a : atividadesCuidador){
           if (nome.equals(a.getNome())){
               atividadesCuidador.remove(a);
           }
       }
    }

    public void excluirAtividadeVeterinaria(int codigo, String nome) throws AnimalNaoEncontradoException {
        Animal animal = buscaAnimalPorCodigo(codigo);
        animal.excluirAtividadeVeterinaria(nome);
        for (AtividadeVeterinaria a : atividadesVeterinaria){
            if (nome.equals(a.getNome())){
                atividadesVeterinaria.remove(a);
            }
        }
    }

    public void editarAtividadeCuidador(int codigo, String nome, String novaTarefa) {
        for (AtividadeCuidador a : atividadesCuidador){
            if(a.getNome().equals(nome))
                a.setTarefas(novaTarefa);
        }
    }

    public void editarAtividadeVeterinaria(int codigo, String nome, String novaTarefa) {
       for (AtividadeVeterinaria a : atividadesVeterinaria){
           if(a.getNome().equals(nome))
               a.setTarefas(novaTarefa);
       }
    }
}
