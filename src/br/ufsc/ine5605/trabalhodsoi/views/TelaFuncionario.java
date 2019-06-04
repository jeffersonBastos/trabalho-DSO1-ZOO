package br.ufsc.ine5605.trabalhodsoi.views;

import br.ufsc.ine5605.trabalhodsoi.control.ControladorFuncionario;
import java.util.ArrayList;
import java.util.Scanner;

import br.ufsc.ine5605.trabalhodsoi.model.Cuidador;
import br.ufsc.ine5605.trabalhodsoi.model.Veterinario;
/**
 *
 * @author jefferson
 */
public class TelaFuncionario {
    private Scanner teclado;
    private ControladorFuncionario controladorFuncionario;

    public TelaFuncionario(ControladorFuncionario controladorFuncionario) {
        teclado = new Scanner(System.in);
        this.controladorFuncionario = controladorFuncionario;
    }

    public void inicia() {
        int escolha;
        do{
            System.out.println("--------FUNCIONARIOS--------");
            System.out.println("1-CADASTRAR FUNCIONARIO");
            System.out.println("2-LISTAR TODOS OS FUNCIONARIOS");
            System.out.println("3-LISTAR CUIDADORES");
            System.out.println("4-LISTAR VETRINARIOS");
            System.out.println("5-BUSCAR FUNCIONARIO");
            System.out.println("6-EXCLUIR FUNCIONARIO");
            System.out.println("7-EDITAR CADASTRO");
            System.out.println("0-VOLTAR");

            escolha = recebeValorInteiroMenu();
            switch(escolha){
                case 1: this.cadastrarFuncionario();
                    break;
                case 2: controladorFuncionario.listar();
                    break;
                case 3: controladorFuncionario.listarCuidadores();
                    break;
                case 4: controladorFuncionario.listarVeterinarios();
                    break;
                case 5: this.buscaFuncionario();
                    break;
                case 6: this.telaExcluirFuncionario();
                    break;
                case 7: this.telaEditarFuncionario();
                    break;    
                case 0:;
                    break;
                default:System.out.println("digite apenas numeros inteiros no intervalo de 0 à 7");;
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
    public int recebeValorCRMV() {
        int valor = recebeValorInteiro();
        int cont = 0;
        int valorb = valor;      
        while( valorb !=0) {
            valorb = valorb/10;
             cont++;
           } 
        if(cont != 4){
            System.out.println("seu CRMV nao tem 4 digitos");
        }
        return valor;
        }
   
    public long recebeValorCPF() {
        long valor = recebeValorLong();
                int cont = 0;
        long valorb = valor;      
        while( valorb != 0) {
            valorb = valorb/10;
             cont++;
           } 
        if(cont != 11){
            System.out.println("seu CPF não tem 11 digitos");
        }
        if(valor == 0){
            System.out.println("E ESTA COM VALOR 0");
        }
        return valor;
    }

    public int recebeValorRG() {
    int valor = recebeValorInteiro();
        int cont = 0;
        int valorb = valor;      
        while( valorb !=0) {
            valorb = valorb/10;
             cont++;
           } 
        if(cont != 7){
            System.out.println("seu RG não tem 7 digitos");
        }
        return valor;
    }

    public void cadastrarFuncionario() {
            
        int escolha;
        do{
            System.out.println("--------CADASTRO DE FUNCIONARIOS--------");
            System.out.println("1-CADASTRAR CUIDADOR");
            System.out.println("2-CADASTRAR VETERINARIO");
            System.out.println("0-VOLTAR");
            
            escolha = recebeValorInteiroMenu();
            switch(escolha){
                case 1: this.cadastrarCuidador();
                    break;
                case 2: this.cadastrarVeterinario();
                    break;
                case 0: escolha =0;
                    break;
                default:System.out.println("digite apenas o numero 0, 1 OU 2");;
                    break;
            }    
        } while(escolha != 0);    
    }        
  

    public void cadastrarCuidador() {
        System.out.println("-------CADASTRAR CUIDADOR---------");
        System.out.println("digite o CPF:");
        long CPF = recebeValorCPF();
        System.out.println("Digite seu RG:");
        int RG = recebeValorRG();
        System.out.println("Digite seu Nome:");
        String nome = recebeValorString();
        System.out.println("Numero do contrato:");
        int numContrato =recebeValorInteiro();
        if(CPF != 0){
            try {
                controladorFuncionario.cadastrarCuidador(CPF, RG, nome, numContrato);
            } catch (Exception e) {
                System.out.println("NAO FOI POSSIVEL CADASTRAR CUIDADOR");
            }
        }else{
            System.out.println("NAO È POSSIVEL CADASTRAR SEM CPF!");
            cadastrarCuidador();
        }    
    }
    public void cadastrarVeterinario() {
        System.out.println("-------CADASTRAR VETERINARIO---------");
        System.out.println("digite o CPF:");
        long CPF = recebeValorCPF();
        System.out.println("Digite seu RG:");
        int RG = recebeValorRG();
        System.out.println("Digite seu Nome:");
        String nome = recebeValorString();
        System.out.println("Numero do contrato:");
        int numContrato = recebeValorInteiro();
        System.out.println("Digite seu CRMV");
        int CRMV = recebeValorCRMV();
        if(CPF != 0){
            try{
                controladorFuncionario.cadastrarVeterinario(CRMV, CPF, RG, nome, numContrato);
                
            }catch(Exception e){
                System.out.println("NAO FOI POSSIVEL CADASTRAR VETERINARIO");
            }
        }else{
            System.out.println("NAO È POSSIVEL CADASTRAR SEM CPF!");
            cadastrarVeterinario();
        }
    }

    public void exibeDadosCuidador(long CPF, int RG, String nome, int numContrato) {
        System.out.println("------DADOS FUNCIONARIO----");
        System.out.println("CPF: "+ CPF);
        System.out.println("RG: "+ RG);
        System.out.println("Nome: "+ nome);
        System.out.println("Numero Contrato "+ numContrato);
        System.out.println("----------");
    }
    public void exibeDadosVeterinario(long CPF, int RG, String nome, int numContrato, int CRMV) {
        System.out.println("------DADOS FUNCIONARIO----");
        System.out.println("CPF: "+ CPF);
        System.out.println("RG: "+ RG);
        System.out.println("Nome: "+ nome);
        System.out.println("Numero Contrato "+ numContrato);
        System.out.println("CRMV:" + CRMV);
        System.out.println("----------");
    }


    public void mostrarListaCuidadores(ArrayList<Cuidador> cuidadores) {
        System.out.println("-------LISTA CUIDADORES-------");
        for(Cuidador c : cuidadores){
            System.out.println("Nome:"+ c.getNome());
            System.out.println("CPF:"+c.getCPF());
            System.out.println("RG:"+ c.getRG());
            System.out.println("Numero do Contrato:"+ c.getNumContrato());
            System.out.println("----------");
        }
    }
    public void mostrarListaVeterinarios(ArrayList<Veterinario> veterinarios) {
        System.out.println("-------LISTA VETERINARIOS-------");
        for(Veterinario v : veterinarios){
            System.out.println("Nome:"+ v.getNome());
            System.out.println("CPF:"+v.getCPF());
            System.out.println("RG:"+ v.getRG());
            System.out.println("Numero do Contrato:"+ v.getNumContrato());
            System.out.println("CRMV:"+ v.getCRMV());
            System.out.println("----------");
        }
    }

    public void buscaFuncionario() {
        int escolha;
        do{
            System.out.println("-------BUSCA DE FUNCIONARIO------");
            System.out.println("1-CUIDADOR");
            System.out.println("2-VETERINARIO");
            System.out.println("0-VOLTAR");
            
            escolha = recebeValorInteiroMenu();
            switch(escolha){
                case 1: System.out.println("Digite o CPF do cuidador:"); 
                    long buscaCPFc = recebeValorCPF();
                    if(!controladorFuncionario.verificaExisteCuidador(buscaCPFc)){
                        System.out.println("Nao existe cuidador com esse CPF");
                        System.out.println("");
                        controladorFuncionario.listarCuidadoresCPF();
                    }else{
                        controladorFuncionario.exibeDadosCuidador(controladorFuncionario.buscaCuidadorCPF(buscaCPFc));
                    }
                    break;
                case 2: System.out.println("Digite o CPF do veterinario:"); 
                    long buscaCPFv = recebeValorCPF();
                    if(!controladorFuncionario.verificaExisteVeterinario(buscaCPFv)){
                        System.out.println("Nao existe veterinario com esse CPF");
                        System.out.println("");
                        controladorFuncionario.listarVeterinariosCPF();
                    }else{
                    controladorFuncionario.exibeDadosVeterinario(controladorFuncionario.buscaVeterinarioCPF(buscaCPFv)); 
                    }
                    break;
                case 0:;
                default:System.out.println("digite apenas os numeros  0, 1 ou 2");;
                    break; 
            }        
        }while(escolha != 0);  
    }
    
    public void mostrarListaCuidadoresCPF(ArrayList<Cuidador> cuidadores) {
        System.out.println("-------LISTA CUIDADORES CPF-------");
        for(Cuidador c : cuidadores){
            System.out.println("Nome:"+ c.getNome());
            System.out.println("CPF:"+c.getCPF());
            System.out.println("--------------");
        }
    }
     public void mostrarListaVeterinariosCPF(ArrayList<Veterinario> veterinarios) {
        System.out.println("-------LISTA VETERINARIOS CPF-------");
        for(Veterinario v : veterinarios){
            System.out.println("Nome:"+ v.getNome());
            System.out.println("CPF:"+v.getCPF());
            System.out.println("--------------");
        }
    }
    public void exibeErroFuncionarioJaCadastrado() {
        System.out.println("Esse funcionario ja esta cadastrado, NAO FOI POSSIVEL CADASTRA-LO");
    }
    public void exibeFuncionarioCadastrado() {
        System.out.println("FUNCIONARIO CADASTRADO COM SUCESSO");
    }

    public void telaExcluirFuncionario() {
        int escolha;
        do{
            System.out.println("-------EXCLUIR FUNCIONARIO------");
            System.out.println("1-CUIDADOR");
            System.out.println("2-VETERINARIO");
            System.out.println("0-VOLTAR");
            
            escolha = recebeValorInteiroMenu();
            switch(escolha){
                case 1: System.out.println("Digite o CPF do cuidador:"); 
                    long buscaCPFc = recebeValorInteiro();
                    if(!controladorFuncionario.verificaExisteCuidador(buscaCPFc)){
                        System.out.println("Nao existe cuidador com esse CPF");
                        System.out.println("");
                        controladorFuncionario.listarCuidadoresCPF();
                    }else{
                    controladorFuncionario.excluiCuidadorCPF(buscaCPFc);
                    System.out.println("FUNCIONARIO EXCLUIDO COM SUCESSO");
                    }
                    break;
                case 2: System.out.println("Digite o CPF do veterinario:"); 
                    long buscaCPFv = recebeValorInteiro();
                    if(!controladorFuncionario.verificaExisteVeterinario(buscaCPFv)){
                        System.out.println("Nao existe veterinario com esse CPF");
                        System.out.println("");
                        controladorFuncionario.listarVeterinariosCPF();
                    }else{
                    controladorFuncionario.excluiVeterinarioCPF(buscaCPFv);
                    System.out.println("FUNCIONARIO EXCLUIDO COM SUCESSO");
                    }
                    break;
                case 0:;
                default:System.out.println("digite apenas os numeros 0, 1 ou 2");;
                    break; 
            }        
        }while(escolha != 0);     
    }

    private void telaEditarFuncionario() {
        int escolha;
        do{
            System.out.println("-------EDITAR FUNCIONARIO------");
            System.out.println("1-CUIDADOR");
            System.out.println("2-VETERINARIO");
            System.out.println("0-VOLTAR");
            
            escolha = recebeValorInteiroMenu();
            switch(escolha){
                case 1: System.out.println("Digite o CPF do cuidador:"); 
                    long buscaCPFc = recebeValorCPF();
                    if(!controladorFuncionario.verificaExisteCuidador(buscaCPFc)){
                        System.out.println("Nao existe cuidador com esse CPF");
                        System.out.println("");
                        controladorFuncionario.listarCuidadoresCPF();
                    }else{
                        controladorFuncionario.exibeDadosCuidador(controladorFuncionario.buscaCuidadorCPF(buscaCPFc));
                        this.editaCuidador(buscaCPFc);
                    }
                    break;
                case 2: System.out.println("Digite o CPF do veterinario:"); 
                    long buscaCPFv = recebeValorCPF();
                    if(!controladorFuncionario.verificaExisteVeterinario(buscaCPFv)){
                        System.out.println("Nao existe veterinario com esse CPF");
                        System.out.println("");
                        controladorFuncionario.listarVeterinariosCPF();
                    }else{
                    controladorFuncionario.exibeDadosVeterinario(controladorFuncionario.buscaVeterinarioCPF(buscaCPFv));
                        this.editaVeterinario(buscaCPFv);
                    }
                    break;
                case 0:;
                default:System.out.println("digite apenas os numeros 0, 1 ou 2");;
                    break; 
            }        
        }while(escolha != 0);     
    }

    

    public void editaCuidador(long buscaCPFc) {
        int escolha;
        do{
            System.out.println("------SELECIONE O QUE DESEJA EDITAR DO: "+controladorFuncionario.buscaCuidadorCPF(buscaCPFc).getNome() +"------------");
            System.out.println("1-CPF");
            System.out.println("2-RG");
            System.out.println("3-Nome");
            System.out.println("4-Numero Contrato");
            System.out.println("0-VOLTAR");
            
            escolha = recebeValorInteiroMenu();
            switch(escolha){
                case 1: System.out.println("Digite o novo CPF do cuidador:"); 
                    long novoCPF = recebeValorCPF();
                    if(novoCPF != 0){
                        controladorFuncionario.editaCPFCuidador(buscaCPFc, novoCPF);
                        System.out.println("CPF editado com sucesso.");
                    }else{
                        editaCuidador(buscaCPFc);
                    }    
                    break;
                case 2: System.out.println("Digite o novo RG do cuidador:"); 
                    int novoRG = recebeValorInteiro();
                    controladorFuncionario.editaRGCuidador(buscaCPFc, novoRG);
                    System.out.println("RG editado com sucesso");
                    break;
                case 3: System.out.println("Digite o novo nome do cuidador:"); 
                    String novoNome = recebeValorString();
                    controladorFuncionario.editaNomeCuidador(buscaCPFc, novoNome);
                    System.out.println("Nome editado com sucesso");
                    break;
                case 4: System.out.println("Digite o novo numero de contrato do cuidador:"); 
                    int novoNumContrato = recebeValorInteiro();
                    controladorFuncionario.editaNumContratoCuidador(buscaCPFc, novoNumContrato);
                    System.out.println("Numero de contrato editado com sucesso");
                    break;
                case 0:;
                default:System.out.println("digite apenas os numeros entre 0 e 4");
                    break; 
            }    
        }while(escolha != 0 );     
    }
    public void editaVeterinario(long buscaCPFv) {
        int escolha;
        do{
            System.out.println("-------EDITAR "+controladorFuncionario.buscaVeterinarioCPF(buscaCPFv).getNome()+"-------");
            System.out.println("1-CPF");
            System.out.println("2-RG");
            System.out.println("3-Nome");
            System.out.println("4-Numero Contrato");
            System.out.println("5-Numero CRMV");
            System.out.println("0-VOLTAR");
            
            escolha = recebeValorInteiroMenu();
            switch(escolha){
                case 1: System.out.println("Digite o novo CPF do veterinario:"); 
                    long novoCPF = recebeValorCPF();
                    if(novoCPF != 0){
                        controladorFuncionario.editaCPFVeterinario(buscaCPFv, novoCPF);
                        System.out.println("CPF editado com sucesso.");
                    }else{
                        editaVeterinario(buscaCPFv);
                    }
                    break;
                case 2: System.out.println("Digite o novo RG do veterinario:"); 
                    int novoRG = recebeValorInteiro();
                    controladorFuncionario.editaRGVeterinario(buscaCPFv, novoRG);
                    System.out.println("RG editado com sucesso");
                    break;
                case 3: System.out.println("Digite o novo nome do veterinario:"); 
                    String novoNome = recebeValorString();
                    controladorFuncionario.editaNomeVeterinario(buscaCPFv, novoNome);
                    System.out.println("Nome editado com sucesso");
                    break;
                case 4: System.out.println("Digite o novo numero de contrato do veterinario:"); 
                    int novoNumContrato = recebeValorInteiro();
                    controladorFuncionario.editaNumContratoVeterinario(buscaCPFv, novoNumContrato);
                    System.out.println("Numero de contrato editado com sucesso");
                    break;
                case 5: System.out.println("Digite o novo numero da CRMV:");
                    int novoCRMV = recebeValorInteiro();
                    controladorFuncionario.editaCRMVVeterinario(buscaCPFv, novoCRMV);
                    System.out.println("CRMV editado com sucesso");
                case 0:;
                default:System.out.println("digite apenas os numeros entre 0 e 5");
                    break; 
            }    
        }while(escolha != 0);     
    }

    
}