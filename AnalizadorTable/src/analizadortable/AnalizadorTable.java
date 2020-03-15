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
public class AnalizadorTable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<String> array;
        array=conversor("i+i*i+(i*i)$");
        
        Analizador a=new Analizador(array);
        a.ejecutar();
    }
    
    private static List<String> conversor(String cadena){
        List<String> aux=new ArrayList();
        for(int i=0;i<cadena.length();i++){
            aux.add(cadena.substring(i, i+1));
        }
        return aux;
    }
    
}
