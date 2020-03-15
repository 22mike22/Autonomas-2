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
public class Analizador {
    
    private final List<String> cadena;
    private final PilaManegador pila;
    private final Tabla tabla;
    
    Analizador(List<String>cadena){
        this.cadena=cadena;
        tabla=new Tabla();
        List<String> aux=new ArrayList();
        aux.add("$");
        aux.add("E");
        pila=new PilaManegador(aux);
    }
    
    public void ejecutar(){
        int aux,k=0;
        pila.imprimirPila();
        System.out.println("cadena "+cadena);
        while(!pila.comparar("$")||!cadenaFin()&&k<1000){
            k++;
            aux=pila.tamaño()-1;
            pila.Agregar(tabla.obtener(pila.obtener(), cadena.get(0)));
            pila.remover(aux);
            pila.imprimirPila();
            if(pila.comparar(cadena.get(0))&&!pila.comparar("$")){
                    pila.remover(); 
                    cadena.remove(0);
                pila.imprimirPila();
            System.out.println("cadena "+cadena);
            }
        }
        if(pila.tamaño()!=1||cadena.size()!=1){
            System.out.println("Cadena no valida.");
        }
    }
    
    public boolean cadenaFin(){
        return cadena.get(0).contentEquals("$");
    }
}
