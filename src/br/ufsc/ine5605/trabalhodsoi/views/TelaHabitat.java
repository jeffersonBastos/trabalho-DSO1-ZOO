package br.ufsc.ine5605.trabalhodsoi.views;
import java.util.Scanner;
import br.ufsc.ine5605.trabalhodsoi.control.ControladorHabitat;
import br.ufsc.ine5605.trabalhodsoi.exception.AnimalNaoEncontradoException;
import br.ufsc.ine5605.trabalhodsoi.model.Animal;
import br.ufsc.ine5605.trabalhodsoi.model.Habitat;
import br.ufsc.ine5605.trabalhodsoi.model.TipoAnimal;
import java.util.ArrayList;

/**
 *
 * @author jefferson
 */
public class TelaHabitat {
    private Scanner teclado;
    private ControladorHabitat controladorHabitat;

    public TelaHabitat(ControladorHabitat controladorHabitat) {
        teclado = new Scanner(System.in);
        this.controladorHabitat = controladorHabitat;
    }

    public void inicia() throws AnimalNaoEncontradoException {
        int escolha;
        do{
            System.out.println("--------HABITAT--------");
            System.out.println("1-CADASTRAR HABITAT");
            System.out.println("2-INCLUIR ANIMAL NO HABITAT");
            System.out.println("3-LISTAR ANIMAIS DO HABITAT");
            System.out.println("4-LISTAR HABITATS");
            System.out.println("5-EXCLUIR HABITAT");
            System.out.println("0-VOLTAR");

            escolha = recebeValorInteiroMenu();
            switch(escolha){
                case 1: this.cadastrarHabitat();
                    break;
                case 2: this.incluirAnimal();
                    break;
                case 3: this.listarAnimaisDoHabitat();
                    break;
                case 4: controladorHabitat.listar();
                    break;
                case 5: this.excluirHabitat();
                    break;
                case 0:;
                    break;
                default:System.out.println("digite apenas numeros inteiros no intervalo de 0 à 5");;
                    break;
            }
        }while(escolha != 0);
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
    public String recebeValorString() {
        return teclado.nextLine();
        
    }
    public int recebeValorInteiro() {
        int valor = 0;
        try{
            valor = teclado.nextInt();
            teclado.nextLine();
        }catch (Exception e) {
            System.out.println("valor invalido! Digite um numero inteiro");
        }
        return valor;
    }

    public void cadastrarHabitat() {
        System.out.println("--------CADASTRO DE HABITAT--------");
        System.out.println("digite o Nome:");
        String nome = recebeValorString();
        int escolha;
        TipoAnimal tipo = null;
        do{
            System.out.println("tipo do habitat (0-Mamifero, 1- Ave, 2- Reptil)");
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
        try {
        controladorHabitat.inserirHabitat(nome, tipo);
        }catch (Exception e) {
            System.out.println("NAO FOI POSSIVEL CADASTRAR HABITAT");
        }
    }
    
    public  void incluirAnimal() throws AnimalNaoEncontradoException {
            System.out.println("------INCLUIR ANIMAL-----");
            System.out.println("Digite o nome do habitat:");
            String nome = recebeValorString();
                if(!controladorHabitat.verificaExisteHabitat(nome)){
                        System.out.println("Nao existe habitat com esse nome");
                        System.out.println("");
                        controladorHabitat.listar();
                }else{
                    System.out.println("Digite o codigo do Animal para no Habitat: ");
                    int codigo = recebeValorInteiro();
                    if(!controladorHabitat.incluiAnimal(codigo, nome)){
                        System.out.println("NAO FOI POSSIVEL INCLUIR ANIMAL!!!");
                        System.out.println("VERIFIQUE SE EXISTE ANIMAL COM ESSE CODIGO!!");
                        controladorHabitat.listarAnimais();
                    }else{
                        System.out.println("ANIMAL INCLUIDO COM SUCESSO");
                    }
                }
        }

    public void listarAnimaisDoHabitat() {
        System.out.println("Digite o nome do habitat:");
        String nome = recebeValorString();
            if(!controladorHabitat.verificaExisteHabitat(nome)){
                    System.out.println("Nao existe habitat com esse nome");
                    System.out.println("");
                    controladorHabitat.listar();
                }else{
                    controladorHabitat.listaAnimalHabitat(nome);
                }
    }    

    public void excluirHabitat() {
        System.out.println("Digite o nome do habitat:");
        String nome = recebeValorString();
            if(!controladorHabitat.verificaExisteHabitat(nome)){
                    System.out.println("Nao existe habitat com esse nome");
                    System.out.println("");
                    controladorHabitat.listar();
                }else{
                    controladorHabitat.excluiHabitat(nome);
                }
           
    }

    public void mostrarListaHabitat(ArrayList<Habitat> habitats) {
        System.out.println("-------LISTA HABITAT-------");
        for(Habitat h : habitats){
            System.out.println("Nome:"+ h.getNome());
            System.out.println("tipo:"+h.getTipo());
            System.out.println("----------");
        }
    }    

    public void exibeErroHabitatJaCadastrado() {
        System.out.println("Esse Habitat ja esta cadastrado");
    }

    public void exibeListaAnimal(ArrayList<Animal> animais) {
        System.out.println("-------LISTA DE ANIMAIS-------");
        for(Animal a : animais){
            System.out.println("Nome:"+ a.getNome());
            System.out.println("Codigo:"+a.getCodigo());
            System.out.println("----------");
        }
    }
}   
    
    
