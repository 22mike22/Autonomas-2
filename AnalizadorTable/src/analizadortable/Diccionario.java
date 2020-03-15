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
public class Diccionario {
    protected List<List<String>> elementos;
    protected List<String> indice;
    Diccionario(){
        elementos=new ArrayList();
        indice=new ArrayList();
    }
    
    public void agregar(String nombre,List<String> elemento){
        if(indiceExistente(nombre))
            System.out.println("Error el nombre ya esta en uso");
        else{
            indice.add(nombre);
            elementos.add(elemento);
        }
    }
    
    
    
    public List<String> obtener(String nombre){
        List<String> aux=new ArrayList();
        if(indiceExistente(nombre)){
            for(int i=0;i<indice.size();i++){
                if(indice.get(i).contentEquals(nombre)){
                    return elementos.get(i);
                }
            }
            return aux;
        }else{
            return aux;
        }
    }
    
    
    public boolean indiceExistente(String nombre){
        for(String i:indice)
            if(nombre.contentEquals(i))return true;
        return false;
    }
}
