package br.ufsc.ine5605.trabalhodsoi.control;

import br.ufsc.ine5605.trabalhodsoi.model.Cuidador;
import br.ufsc.ine5605.trabalhodsoi.model.Veterinario;
import br.ufsc.ine5605.trabalhodsoi.views.TelaFuncionario;
import java.util.ArrayList;
import br.ufsc.ine5605.trabalhodsoi.model.InterfaceListar;


/**
 *
 * @author jefferson
 */
public class ControladorFuncionario implements InterfaceListar{
    private ArrayList<Cuidador> cuidadores;
    private ArrayList<Veterinario> veterinarios;
    private TelaFuncionario telaFuncionario;
    private ControladorPrincipal controladorPrincipal;

    public ControladorFuncionario(ControladorPrincipal controladorPrincipal){
        cuidadores = new ArrayList<>();
        veterinarios = new ArrayList<>();
        this.controladorPrincipal = controladorPrincipal;
        this.telaFuncionario = new TelaFuncionario(this);
    }
    public void inicia(){
        telaFuncionario.inicia();
    }
    public void cadastrarCuidador(long CPF, int RG, String nome, int numContrato) {
        Cuidador cuidador = new Cuidador(CPF, RG, nome, numContrato);
        if(!verificaExisteCuidador(CPF)){
            telaFuncionario.exibeDadosCuidador(CPF, RG, nome, numContrato);
            telaFuncionario.exibeFuncionarioCadastrado();
            cuidadores.add(cuidador);
        }else{   
            telaFuncionario.exibeErroFuncionarioJaCadastrado();
        }    
    }
   
    public void cadastrarVeterinario(int CRMV, long CPF, int RG, String nome, int numContrato) {
        Veterinario veterinario = new Veterinario (CRMV, CPF, RG, nome, numContrato);
        if(!verificaExisteVeterinario(CPF)){
            telaFuncionario.exibeDadosVeterinario(CPF, RG, nome, numContrato, CRMV);
            telaFuncionario.exibeFuncionarioCadastrado();
            veterinarios.add(veterinario);
        }else{
        telaFuncionario.exibeErroFuncionarioJaCadastrado();
        }
    }
    
    public void addVeterinario(Veterinario veterinario){
        if(!veterinarios.contains(veterinario)){
            veterinarios.add(veterinario);
        }
    }
    public void delVeterinario(Veterinario veterinario){
        if(veterinarios.contains(veterinario)){
            veterinarios.remove(veterinario);
        }
       
    }
    public void addCuidador(Cuidador cuidador){
        if(!cuidadores.contains(cuidador)){
            cuidadores.add(cuidador);
        }
        
    }
    public void delCuidador(Cuidador cuidador){
        if(cuidadores.contains(cuidador)){
            cuidadores.remove(cuidador);
        }
    }
   
    public void listar(){
       telaFuncionario.mostrarListaCuidadores(cuidadores);
       telaFuncionario.mostrarListaVeterinarios(veterinarios);
        
    }
    public void listarCuidadoresCPF() {
        telaFuncionario.mostrarListaCuidadoresCPF(cuidadores);
    }
    public void listarVeterinariosCPF(){
        telaFuncionario.mostrarListaVeterinariosCPF(veterinarios);
    }


    public void listarCuidadores() {
        telaFuncionario.mostrarListaCuidadores(cuidadores);
    }
    public void listarVeterinarios(){
        telaFuncionario.mostrarListaVeterinarios(veterinarios);
    }

    public Cuidador buscaCuidadorCPF(long buscaCPF) {
        for(Cuidador c : cuidadores){
            if(c.getCPF() == buscaCPF){
                return c;
            }
            
        }
        return null;
    }

    public Veterinario buscaVeterinarioCPF(long buscaCPF) {
        for(Veterinario v : veterinarios){
            if(v.getCPF() == buscaCPF){
                return v;
            }
        }
        return null;    
    }

    public boolean verificaExisteCuidador(long buscaCPF) {
            for(Cuidador c : cuidadores){
                if(c.getCPF() == buscaCPF){
                    return true;
                }
        }
        return false;
    }

    public boolean verificaExisteVeterinario(long buscaCPF) {
        for(Veterinario v : veterinarios){
            if(v.getCPF() == buscaCPF){
            return true
                ;
            }
        }
        return false;    
    }

    public void excluiCuidadorCPF(long buscaCPF) {
        cuidadores.remove(buscaCuidadorCPF(buscaCPF));
    }

    public void excluiVeterinarioCPF(long buscaCPF) {
        veterinarios.remove(buscaVeterinarioCPF(buscaCPF));
    }

    public void exibeDadosCuidador(Cuidador cuidador) {
        telaFuncionario.exibeDadosCuidador(cuidador.getCPF(), cuidador.getRG(),cuidador.getNome(), cuidador.getNumContrato());
    }

    public void exibeDadosVeterinario(Veterinario veterinario) {
        telaFuncionario.exibeDadosVeterinario(veterinario.getCPF(), veterinario.getRG(),veterinario.getNome(),veterinario.getNumContrato(),veterinario.getCRMV());    
    }

    public void editaCPFCuidador(long CPF,long novoCPF) {
        buscaCuidadorCPF(CPF).setCPF(novoCPF);
    }

    public void editaRGCuidador(long CPF,int novoRG) {
        buscaCuidadorCPF(CPF).setRG(novoRG);
    }

    public void editaNomeCuidador(long CPF,String novoNome) {
        buscaCuidadorCPF(CPF).setNome(novoNome); 
    }

    public void editaNumContratoCuidador(long CPF,int novoNumContrato) {
        buscaCuidadorCPF(CPF).setNumContrato(novoNumContrato);
    }

    public void editaCRMVVeterinario(long CPF,int novoCRMV) {
        buscaVeterinarioCPF(CPF).setCRMV(novoCRMV);
    }

    public void editaNumContratoVeterinario(long CPF, int novoNumContrato) {
        buscaVeterinarioCPF(CPF).setNumContrato(novoNumContrato);
    }

    public void editaNomeVeterinario(long CPF,String novoNome) {
        buscaVeterinarioCPF(CPF).setNome(novoNome);
    }

    public void editaRGVeterinario(long CPF,int novoRG) {
        buscaVeterinarioCPF(CPF).setRG(novoRG);
    }

    public void editaCPFVeterinario(long CPF,long novoCPF) {
        buscaVeterinarioCPF(CPF).setCPF(novoCPF);
        
    }

   
    public void preCadastro(){
        long CPF = 001;
        int RG = 6891379;
        String Nome = "Pablo Silva";
        int numContrato = 88554;
        cadastrarCuidador(CPF, RG, Nome, numContrato);
        
        long CPF2 = 002;
        int RG2 = 6453791;
        String Nome2 = "Jefferson Bastos";
        int numContrato2 = 14934;
        cadastrarCuidador(CPF2, RG2, Nome2, numContrato2);
        
        long CPF3 = 003;
        int RG3 = 4628379;
        String Nome3 = "Ramon seugling";
        int numContrato3 = 88554;
        cadastrarCuidador(CPF3, RG3, Nome3, numContrato3);
        
        long CPF4 = 004;
        int RG4 = 4683458;
        String Nome4 = "Carlos almeida";
        int numContrato4 = 75842;
        int CRMV = 4005;
        cadastrarVeterinario(CRMV, CPF4, RG4, Nome4, numContrato4);
        
        long CPF5 =005;
        int RG5 = 6983214;
        String Nome5 = "Felipe Caetano";
        int numContrato5 = 974682;
        int CRMV2 = 4639;
        cadastrarVeterinario(CRMV2, CPF5, RG5, Nome5, numContrato5);
        
        long CPF6 =006;
        int RG6 = 6358794;
        String Nome6 = "Carlos Mendes";
        int numContrato6 = 854616;
        int CRMV3 = 7945;
        cadastrarVeterinario(CRMV3, CPF6, RG6, Nome6, numContrato6);
        
    }   

    
 
}