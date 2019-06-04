package br.ufsc.ine5605.trabalhodsoi.views;

import br.ufsc.ine5605.trabalhodsoi.control.ControladorAtividade;
import br.ufsc.ine5605.trabalhodsoi.control.ControladorPrincipal;
import br.ufsc.ine5605.trabalhodsoi.exception.AnimalNaoEncontradoException;
import java.util.Scanner;

/**
 *
 * @author jefferson
 */
public class TelaPrincipal {
     
    private Scanner teclado;
    private ControladorPrincipal controladorPrincipal;

    

    

    public TelaPrincipal(ControladorPrincipal controladorPrincipal) {
        teclado = new Scanner(System.in);
        this.controladorPrincipal = controladorPrincipal;   
    }

    
    public void inicia() throws AnimalNaoEncontradoException{
        int escolha;
        do{
            System.out.println("---------ZOOLOGICO-----------");
            System.out.println("1-ANIMAIS");
            System.out.println("2-FUNCIONARIOS");
            System.out.println("3-HABITATS");
            System.out.println("4-ATIVIDADES");
            System.out.println("5-PRE-CADASTRO");
            System.out.println("0-SAIR");

            escolha = recebeValorInteiroMenu();

            switch(escolha){
                case 1: controladorPrincipal.iniciaTelaAnimal();
                    break;
                case 2:controladorPrincipal.iniciaTelaFuncionario();
                    break;
                case 3:controladorPrincipal.iniciaTelaHabitat();
                    break;
                case 4:controladorPrincipal.iniciaTelaAtividade();
                    break;
                case 5:controladorPrincipal.iniciaPreCadastro();
                    break;
                case 0:System.out.println("--------OBRIGADO POR USAR NOSSO PROGRAMA---------");
                break;
                default:System.out.println("Digite apenas de 0 ate 5.");
                this.inicia();
                    break;
            }
        }while( escolha != -1);
        
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

}