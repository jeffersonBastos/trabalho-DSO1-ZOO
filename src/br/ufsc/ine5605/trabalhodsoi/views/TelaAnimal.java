package br.ufsc.ine5605.trabalhodsoi.views;
import br.ufsc.ine5605.trabalhodsoi.control.ControladorAnimal;
import br.ufsc.ine5605.trabalhodsoi.exception.AnimalJahCadastradoException;
import br.ufsc.ine5605.trabalhodsoi.exception.AnimalNaoEncontradoException;
import br.ufsc.ine5605.trabalhodsoi.model.Animal;
import br.ufsc.ine5605.trabalhodsoi.model.Atividade;
import br.ufsc.ine5605.trabalhodsoi.model.AtividadeCuidador;
import br.ufsc.ine5605.trabalhodsoi.model.AtividadeVeterinaria;
import br.ufsc.ine5605.trabalhodsoi.model.Habitat;
import br.ufsc.ine5605.trabalhodsoi.model.TipoAnimal;
import java.util.ArrayList;
import java.util.Scanner;



public class TelaAnimal {
    
    private Scanner teclado;
    private ControladorAnimal controladorAnimal;
    
    public TelaAnimal(ControladorAnimal controladorAnimal){
        teclado = new Scanner(System.in);
        this.controladorAnimal = controladorAnimal;
    }
    
    public void mostraMenuAnimal() throws AnimalNaoEncontradoException{
        
        int opcao;
        
        do { 
            System.out.println("-------ANIMAL------");
            System.out.println("1-CADASTRAR ANIMAL");
            System.out.println("2-EXCLUIR ANIMAL");
            System.out.println("3-LISTAR ANIMAIS");
            System.out.println("4-RELATORIO DAS ATIVIDADES DO ANIMAL");
            System.out.println("0-VOLTAR");
            opcao = recebeValorInteiroMenu();
            
            switch(opcao){
                case 1: 
                    mostrarTelaCadastroAnimal();
                    break;
                case 2: 
                    mostrarTelaExclusaoAnimal();
                    break;
                case 3 :
                    controladorAnimal.listarAnimais();
                    break;
                case 4 :
                    mostrarTelaRelatorios();
                    break;
                case 0:; 
                    break;
                default:System.out.println("digite entre 0 e 4.");
            }
        }while (opcao != 0);      
    }
    
    public void mostrarTelaCadastroAnimal() throws AnimalNaoEncontradoException{
        System.out.println("Cadastro de novo animal");
        
        System.out.println("CODIGO DO ANIMAL: ");
        int codigo = recebeValorInteiro();
        
        System.out.println("ESPECIE DO ANIMAL: ");
        String especie = recebeValorString();
        
        System.out.println("NOME DO ANIMAL: ");
        String nome = recebeValorString();
        
        System.out.println("DATA DE CHEGADA");
        String data = recebeValorString();
        int escolha;
        TipoAnimal tipo = null;
        do{
            System.out.println("tipo do animal(0-Mamifero, 1- Ave, 2- Reptil)");
            escolha = recebeValorInteiro();
            switch(escolha){
                case 0: tipo = TipoAnimal.MAMIFERO;
                    break;
                case 1: tipo = TipoAnimal.AVE;
                    break;
                case 2: tipo =TipoAnimal.REPTIL;
                    break;
                default:System.out.println("digite apenas o numero 0, 1 OU 2"); 
                    break;
            }
        }while(escolha < 0 || escolha > 2);   
        Habitat habitat =  null;
        
            System.out.println("Digite o nome do Habitat do Animal");
            String nomeHabitat = recebeValorString();
            if(!controladorAnimal.verificaExisteHabitat(nomeHabitat)){
                System.out.println("Nao existe habitat com esse nome.");
                controladorAnimal.listaHabitat(); 
                
            }else{
                habitat = controladorAnimal.buscaHabitat(nomeHabitat);
            }
        
        
        ConteudoTelaAnimal conteudoTelaAnimal = new ConteudoTelaAnimal(codigo, especie, nome, data, tipo, habitat);
        
        try {
            controladorAnimal.incluirAnimal(conteudoTelaAnimal);

        } catch (AnimalJahCadastradoException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void mostrarTelaExclusaoAnimal(){
        ConteudoTelaAnimal conteudoTelaAnimal = new ConteudoTelaAnimal();
        
        System.out.println("EXCLUSAO DE ANIMAL");
        System.out.println("DIGITE O CODIGO DO ANIMAL QUE DESEJA EXLUIR: ");
        
        System.out.println("CODIGO: ");
        conteudoTelaAnimal.codigo = teclado.nextInt();
        
        try {
            controladorAnimal.excluirAnimal(conteudoTelaAnimal.codigo);
        } catch (AnimalNaoEncontradoException ex) {
            System.out.println(ex.getMessage());;            
        }
    }
    
    public void mostrarListaAnimais (ArrayList<ConteudoTelaAnimal> listagemAnimais) {
        System.out.println("********");
        System.out.println("* Lista de Animais *");
        for (ConteudoTelaAnimal conteudoTelaAnimal : listagemAnimais) {
            Animal animal = controladorAnimal.desempacota(conteudoTelaAnimal);
            System.out.println("CODIGO: " + animal.getCodigo());
            System.out.println("ESPECIE: " + animal.getEspecie());
            System.out.println("NOME: " + animal.getNome());
            System.out.println("DATA DE CHEGADA: " + animal.getChegadaZoo());
            System.out.println("TIPO DO ANIMAL: " + animal.getTipoAnimal());
        }
    }
    
    public int recebeValorInteiro() {
        int valor = 0;
        try{
            valor = teclado.nextInt();
            teclado.nextLine();
        }catch (Exception e) {
            System.out.println("Valor inválido! Digite um número inteiro.");
        }
        return valor;
    }

    public String recebeValorString() {
        return teclado.nextLine();
    }
    public int recebeValorInteiroMenu(){
        int valor = -1;
        try{
            valor = teclado.nextInt();
            teclado.nextLine();
        } catch (Exception e){
            System.out.println("Valor inválido! Digite um número inteiro");
        }   
        if (valor == -1){
            teclado.nextLine();
        }
        return valor;
     }

    public void mostrarTelaRelatorios() throws AnimalNaoEncontradoException{
        
        int opcao;
        do{
            System.out.println("------RELATORIO DE ATIVIDADES------");
            System.out.println("1-LISTA DE ATIVIDADES DO CUIDADOR");
            System.out.println("2-LISTA DE ATIVIDADES DO VETERINARIO");
            System.out.println("0- VOLTAR");
            opcao = teclado.nextInt();

                switch(opcao){
                    case 1: 
                        listarAtividadesCuidador();
                        break;
                    case 2: 
                        listarAtividadesVeterinaria();
                        break;
                    case 0:;    
                    default:System.out.println("digite entre 0 e 2");
                                                
                }   
        }while (opcao != 0);  

    } 
    
    
    public void listarAtividadesCuidador() throws AnimalNaoEncontradoException {
        int codigo;
        do{
            System.out.println("------RELATORIO DE ATIVIDADES DO CUIDADOR------");
            System.out.println("DIGITE O CODIGO DO ANIMAL: ");
            codigo = teclado.nextInt();
            if(controladorAnimal.verificaExisteAnimal(codigo)){
                Animal animal = controladorAnimal.buscaAnimalPorCodigo(codigo);
                exibeAtividadeCuidador(animal.getAtividadesCuidador());
            }else{
                System.out.println("nao foi encontrado animal com esse codigo");
                controladorAnimal.listarAnimais();
            }    
        }while (codigo != 0);
            
    }

    private void exibeAtividadeCuidador(ArrayList<AtividadeCuidador> atividadesCuidador) {
        System.out.println("ATIVIDADES CUIDADOR: ");
        
        for (AtividadeCuidador at :atividadesCuidador ){
            System.out.println("NOME DA ATIVIDADE: "+ at.getNome());
            if (at.isComeu() == true){
                System.out.println("ANIMAL COMEU? SIM");
            }else{
                System.out.println("ANIMAL COMEU? NÃO");
            }
            System.out.println("O QUE O ANIMAL COMEU: "+ at.getQualComida());
            System.out.println("DATA DA ATIVIDADE: "+ at.getData());
            System.out.println("CPF DO USUARIO: "+ at.getCpfUsuario());
            System.out.println("TAREFAS: "+ at.getTarefas());  
            System.out.println("--------------");

        }

    
    
    }

    public void listarAtividadesVeterinaria() throws AnimalNaoEncontradoException {
        int codigo;
        do{
            System.out.println("------RELATORIO DE ATIVIDADES DO VETERINARIO------");
            System.out.println("DIGITE O CODIGO DO ANIMAL: ");
            codigo = teclado.nextInt();
            if(controladorAnimal.verificaExisteAnimal(codigo)){
                Animal animal = controladorAnimal.buscaAnimalPorCodigo(codigo);
                exibeAtividadeVeterinario(animal.getAtividadesVeterinaria());
            }else{
                System.out.println("nao foi encontrado animal com esse codigo");
                controladorAnimal.listarAnimais();
            }    
        }while (codigo != 0);    
    }

    public void exibeAtividadeVeterinario(ArrayList<AtividadeVeterinaria> atividadesVeterinaria) {
        System.out.println("ATIVIDADES VETERINARIO: ");
        
        for (AtividadeVeterinaria at :atividadesVeterinaria ){
            System.out.println("NOME DA ATIVIDADE: "+ at.getNome());
            System.out.println("REMEDIO: "+at.getRemedio());
            System.out.println("SAUDE: "+at.getSaude());
            System.out.println("DATA DA ATIVIDADE: "+ at.getData());
            System.out.println("CPF DO USUARIO: "+ at.getCpfUsuario());
            System.out.println("TAREFAS: "+ at.getTarefas()); 
            System.out.println("--------------");
        }
    }

   
    
}