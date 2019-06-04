package br.ufsc.ine5605.trabalhodsoi.views;

import br.ufsc.ine5605.trabalhodsoi.control.ControladorAtividade;
import br.ufsc.ine5605.trabalhodsoi.exception.AnimalNaoEncontradoException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jefferson
 */
public class TelaAtividade {
    
    private Scanner teclado;
    private ControladorAtividade controladorAtividade;
    
    public TelaAtividade(ControladorAtividade controladorAtividade){
        teclado = new Scanner(System.in);
        this.controladorAtividade = controladorAtividade;
    }
    
    public void mostraMenuAtividades() throws AnimalNaoEncontradoException{
        
        int opcao;
        
        do { 
            System.out.println("-------ATIVIDADES------");
            System.out.println("1-ADICIONAR ATIVIDADE DO CUIDADOR DO ANIMAL");
            System.out.println("2-ADICIONAR ATIVIDADE DO VETERINARIO DO ANIMAL");
            System.out.println("3-EXCLUIR ATIVIDADE DO CUIDADOR DO ANIMAL");
            System.out.println("4-EXCLUIR ATIVIDADE DO VETERINARIO DO ANIMAL");
            System.out.println("5-EDITAR ATIVIDADE DO CUIDADOR");
            System.out.println("6-EDITAR ATIVIDADE DO VETERINARIO");
            System.out.println("0-VOLTAR");
            opcao = recebeValorInteiroMenu();
            
            switch(opcao){
                case 1: 
                    adicionarAtividadeCuidador();
                    break;
                case 2: 
                    adicionarAtividadeVeterinario();
                    break;
                case 3 :
                    excluirAtividadeCuidador();
                    break;
                case 4 :
                    excluirAtividadeVeterinaria();
                    break;
                case 5 :
                    editarAtividadeCuidador();
                    break;
                case 6 :
                    editarAtividadeVeterinaria();
                    break;
                case 0:;
                    break;
                default:System.out.println("digite apenas numeros inteiros no intervalo de 0 à 6");;
                    break;
            }
        }while (opcao != 0);      
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
    public void adicionarAtividadeCuidador() throws AnimalNaoEncontradoException {
        System.out.println("------ADICIONAR ATIVIDADE CUIDADOR------");
        System.out.println("DIGITE O CODIGO DO ANIMAL: ");
        int codigo = recebeValorInteiro();
        System.out.println("DIGITE O NOME DA ATIVIDADE: ");
        String nome = recebeValorString();
        
        boolean comeu = true;
        int opcao; 
        do{
            System.out.println("DIGITE SE O ANIMAL COMEU: ");
            System.out.println("1 - SIM");
            System.out.println("2 - NÃO");
            opcao = recebeValorInteiroMenu();
            switch(opcao){
            case 1 :
                comeu = true;
            case 2 :
                comeu = false;
            default:System.out.println("escolha 1 ou 2");;
            }
        }while(opcao != 1 && opcao != 2);       
        
        
        System.out.println("DIGITE O QUE O ANIMAL COMEU: ");
        String qualComida =recebeValorString();
        System.out.println("DIGITE A DATA: ");
        String data =recebeValorString();
        System.out.println("DIGITE O CPF: ");
        long cpfUsuario = recebeValorLong();
        System.out.println("DIGITE AS TAREFAS REALIZADAS: ");
        String tarefas = recebeValorString();
        System.out.println("DIGITE O CODIGO DO ANIMAL: ");
        try{
            controladorAtividade.cadastraAtividadeCuidador(codigo, nome, comeu, qualComida, data, cpfUsuario, tarefas);
        }catch(Exception e){
            System.out.println("nao foi possivel cadastrar atividade");
        }    
    
    }
    
    public void adicionarAtividadeVeterinario() throws AnimalNaoEncontradoException {
        System.out.println("------ADICIONAR ATIVIDADE VETERINARIO------");
        System.out.println("DIGITE O CODIGO DO ANIMAL: ");
        int codigo = recebeValorInteiro();
        System.out.println("DIGITE O NOME DA ATIVIDADE: ");
        String nome = recebeValorString();
        System.out.println("DIGITE O REMEDIO DADO: ");
        String remedioDado = recebeValorString();
        System.out.println("DIGITE A SAUDE DO ANIMAL: ");
        String saude = recebeValorString();
        System.out.println("DIGITE A DATA: ");
        String data = recebeValorString();
        System.out.println("DIGITE O CPF: ");
        long cpfUsuario = recebeValorLong();
        System.out.println("DIGITE AS TAREFAS REALIZADAS: ");
        String tarefas = recebeValorString();
        try{
            controladorAtividade.cadastraAtividadeVeterinario(codigo, nome, remedioDado, saude, data, cpfUsuario, tarefas);
        }catch(Exception e){
            System.out.println("nao foi possivel cadastrar atividade");
        }  
    }

    public void excluirAtividadeCuidador() throws AnimalNaoEncontradoException {
        System.out.println("------EXCLUIR ATIVIDADE CUIDADOR-----");
        System.out.println("DIGITE O CODIGO DO ANIMAL: ");
        int codigo = teclado.nextInt();
        System.out.println("DIGITE O NOME DA ATIVIDADE QUE DESEJA EXCLUIR: ");
        String nome = teclado.nextLine();
        controladorAtividade.excluirAtividadeCuidador(codigo, nome);
    }
    
    public void excluirAtividadeVeterinaria() throws AnimalNaoEncontradoException{
        System.out.println("------EXCLUIR ATIVIDADE VETERINARIO------");
        System.out.println("DIGITE O CODIGO DO ANIMAL: ");
        int codigo = teclado.nextInt();
        System.out.println("DIGITE O NOME DA ATIVIDADE QUE DESEJA EXCLUIR: ");
        String nome = teclado.nextLine();
        controladorAtividade.excluirAtividadeVeterinaria(codigo, nome);
    }

    public void editarAtividadeCuidador(){
        System.out.println("------EDITAR ATIVIDADE CUIDADOR------");
        System.out.println("DIGITE O CODIGO DO ANIMAL: ");
        int codigo = teclado.nextInt();
        System.out.println("DIGITE O NOME DA ATIVIDADE QUE DESEJA EDITAR");
        String nome = teclado.nextLine();
        System.out.println("DIGITE A NOVA TAREFA");
        String novaTarefa = teclado.nextLine();
        controladorAtividade.editarAtividadeCuidador(codigo, nome, novaTarefa);
    }
    
     public void editarAtividadeVeterinaria(){
        System.out.println("------EDITAR ATIVIDADE VETERINARIA------");
        System.out.println("DIGITE O CODIGO DO ANIMAL: ");
        int codigo = teclado.nextInt();
        System.out.println("DIGITE O NOME DA ATIVIDADE QUE DESEJA EDITAR");
        String nome = teclado.nextLine();
        System.out.println("DIGITE A NOVA TAREFA");
        String novaTarefa = teclado.nextLine();
        controladorAtividade.editarAtividadeVeterinaria(codigo, nome, novaTarefa);
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
    public long recebeValorLong() {
        long valor = 0;
        try{
            valor = teclado.nextLong();
            teclado.nextLine();
        }catch (Exception e) {
            System.out.println("valor invalido! Digite um numero inteiro");
        }
        return valor;
    }
}