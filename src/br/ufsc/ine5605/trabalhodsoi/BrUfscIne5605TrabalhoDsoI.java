/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodsoi;

import br.ufsc.ine5605.trabalhodsoi.control.ControladorPrincipal;
import br.ufsc.ine5605.trabalhodsoi.exception.AnimalNaoEncontradoException;


public class BrUfscIne5605TrabalhoDsoI {

 
    public static void main(String[] args) throws AnimalNaoEncontradoException {
        ControladorPrincipal controle = new ControladorPrincipal();
        controle.inicia();
    }
    
}
