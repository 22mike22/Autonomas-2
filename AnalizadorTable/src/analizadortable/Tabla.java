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
public final class Tabla {
    List<String> elementos;
    List<Diccionario>acciones;
    Tabla(){
        acciones=new ArrayList();
        elementos=new ArrayList();
        agregarElementos();
    }
    
    public void agregarElementos(){
        elementosE();
        elementosE2();
        elementosT();
        elementosT2();
        elementosF();
    }
    
    private void elementosE(){
        elementos.add("E");
        Diccionario aux=new Diccionario();
        List<String> aux1=new ArrayList();
        aux1.add("E'");
        aux1.add("T");
        aux.agregar("(", aux1);
        aux.agregar("i", aux1);
        acciones.add(aux);
    }
    
    private void elementosE2(){
        elementos.add("E'");
        Diccionario aux=new Diccionario();
        List<String> aux1=new ArrayList();
        aux1.add("E'");
        aux1.add("T");
        aux1.add("+");
        aux.agregar("+", aux1);
        aux.agregar(")", new ArrayList());
        aux.agregar("$",new ArrayList());
        acciones.add(aux);
    }
    
    private void elementosT(){
        elementos.add("T");
        Diccionario aux=new Diccionario();
        List<String> aux1=new ArrayList();
        aux1.add("T'");
        aux1.add("F");
        aux.agregar("(", aux1);
        aux.agregar("i", aux1);
        acciones.add(aux);
    }
    
    private void elementosT2(){
        elementos.add("T'");
        Diccionario aux=new Diccionario();
        List<String> aux1=new ArrayList();
        aux1.add("T'");
        aux1.add("F");
        aux1.add("*");
        aux.agregar("*", aux1);
        aux.agregar("+", new ArrayList());
        aux.agregar(")",new ArrayList());
        aux.agregar("$",new ArrayList());
        acciones.add(aux);
    }
    
    private void elementosF(){
        elementos.add("F");
        Diccionario aux=new Diccionario();
        List<String> aux1=new ArrayList();
        aux1.add(")");
        aux1.add("E");
        aux1.add("(");
        aux.agregar("(", aux1);
        aux1=new ArrayList();
        aux1.add("i");
        aux.agregar("i",aux1);
        acciones.add(aux);
    }
    
    public List<String> obtener(String simbolo,String s){
        for(int i=0;i<elementos.size();i++){
            if(elementos.get(i).contentEquals(simbolo)){
                return acciones.get(i).obtener(s);
            }
        }
        
        return new ArrayList();
    }
}
