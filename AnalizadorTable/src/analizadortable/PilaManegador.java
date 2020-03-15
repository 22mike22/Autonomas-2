/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadortable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author migue
 */
public class PilaManegador {
    private List<String> pila;
    PilaManegador(List<String> s){
        pila=new ArrayList();
        Agregar(s);
    }
    
    public void Agregar(List<String> s){
        for(int i=0;i<s.size();i++){
            pila.add(s.get(i));
        }
    }
    
    public String obtener(){
        return pila.get(pila.size()-1);
    }
    
    public void imprimirPila(){
        System.out.println(pila);
    }
    
    public void remover(int i){
        pila.remove(i);
    }
    
    public void remover(){
        pila.remove(tamaño()-1);
    }
    
    public String obtener(int i){
        return pila.get(i);
    }
    
    public int tamaño(){
        return pila.size();
    }
    
    public boolean comparar(String s){
        return pila.get(tamaño()-1).contentEquals(s);
    }
}
