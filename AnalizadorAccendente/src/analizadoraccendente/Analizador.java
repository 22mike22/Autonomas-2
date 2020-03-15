/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadoraccendente;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author migue
 */
public class Analizador {

    List<String> cadena;
    List pila;
    List<String> in;
    Tabla t;

    Analizador(List<String> cadena) {
        this.cadena = cadena;
        pila = new ArrayList();
        t = new Tabla();
        pila.add(0);
        in = new ArrayList();
    }

    public void ejecutar() {
        int c;
        List aux;
        in.add("$");
        imprimir();
        OUTER:
        while (true) {
            aux = t.obtener(obtener(), cadena.get(0));
            c = aux.size();
            switch (c) {
                case 2:
                    in.add(cadena.get(0));
                    pila.add(t.obtener(obtener(), cadena.get(0)).get(1));
                    cadena.remove(0);
                    imprimir();
                    break;
                case 1:
                    if (in.size() >= 3) {
                        if(datos(0).equals("F")&&datos(1).equals("*")&&datos(2).equals("T")){
                            remplazar("T");
                            imprimir();
                            continue;
                        }if(datos(0).equals("T")&&datos(1).equals("+")&&datos(2).equals("E")){
                            remplazar("E");
                            imprimir();
                            continue;
                        }if(datos(0).equals(")")&&datos(1).equals("E")&&datos(2).equals("(")){
                            remplazar("F");
                            imprimir();
                            continue;
                        }
                    }   switch (datos(0)) {
                    case "i":
                        pila.remove(pila.size() - 1);
                        in.remove(in.size() - 1);
                        in.add("F");
                        pila.add(t.obtener(obtener(), in.get(in.size() - 1)).get(0));
                        imprimir();
                        break;
                    case "F":
                        pila.remove(pila.size() - 1);
                        in.remove(in.size() - 1);
                        in.add("T");
                        pila.add(t.obtener(obtener(), in.get(in.size() - 1)).get(0));
                        imprimir();
                        break;
                    case "T":
                        pila.remove(pila.size() - 1);
                        in.remove(in.size() - 1);
                        in.add("E");
                        pila.add(t.obtener(obtener(), in.get(in.size() - 1)).get(0));
                        imprimir();
                        break;
                    default:
                        break;
                }
                break;
                case 3:
                    System.out.println("Cadena Aceptada");
                    break OUTER;
                default:
                    System.out.println("Cadena Rechazada");
                    break OUTER;
            }
        }
    }

    private void remplazar(String s){
        pila.remove(pila.size()-1);
                        pila.remove(pila.size()-1);
                        pila.remove(pila.size()-1);
                        in.remove(in.size()-1);
                        in.remove(in.size()-1);
                        in.remove(in.size()-1);
                        in.add(s);
                        pila.add(t.obtener(obtener(), in.get(in.size()-1)).get(0));

    }

    private int obtener() {
        return (int) pila.get(pila.size() - 1);
    }

    private String datos(int i) {
        return in.get(in.size() - 1 - i);
    }

    private void imprimir() {
        System.out.println("Pila " + pila + " Cadena " + cadena + " Intermediario " + in);
    }
}

class Tabla {

    List<String> accionesOIr;
    List<List<String>> accion;
    List<String> cadena;
    List<String> pila;
    Diccionario[] d = new Diccionario[12];

    Tabla() {
        accion = new ArrayList();
        pila = new ArrayList();
        accionesOIr = new ArrayList();
        agregar();
    }

    private void agregar() {

        Diccionario d2 = new Diccionario();
        List elemt = new ArrayList();

        //elementos de 0
        elemt.add(true);
        elemt.add(5);
        d2.agregar("i", elemt);
        elemt = new ArrayList();
        elemt.add(true);
        elemt.add(4);
        d2.agregar("(", elemt);
        elemt = new ArrayList();
        elemt.add(1);
        d2.agregar("E", elemt);
        elemt = new ArrayList();
        elemt.add(2);
        d2.agregar("T", elemt);
        elemt = new ArrayList();
        elemt.add(3);
        d2.agregar("F", elemt);
        d[0] = d2;

        //elementos de 1
        d2 = new Diccionario();
        elemt = new ArrayList();
        elemt.add(true);
        elemt.add(6);
        d2.agregar("+", elemt);
        elemt = new ArrayList();
        elemt.add("");
        elemt.add("");
        elemt.add("aceptado");
        d2.agregar("$", elemt);
        d[1] = d2;

        //elementos de 2
        d2 = new Diccionario();
        elemt = new ArrayList();
        elemt.add(false);
        d2.agregar("+", elemt);
        elemt = new ArrayList();
        elemt.add(true);
        elemt.add(7);
        d2.agregar("*", elemt);
        elemt = new ArrayList();
        elemt.add(false);
        d2.agregar(")", elemt);
        d2.agregar("$", elemt);
        d[2] = d2;

        d2 = new Diccionario();
        elemt = new ArrayList();

        //elementos de 3
        elemt.add(false);
        d2.agregar("+", elemt);
        d2.agregar("*", elemt);
        d2.agregar(")", elemt);
        d2.agregar("$", elemt);
        d[3] = d2;

        d2 = new Diccionario();
        elemt = new ArrayList();

        //elementos de 4
        elemt.add(true);
        elemt.add(5);
        d2.agregar("i", elemt);
        elemt = new ArrayList();
        elemt.add(true);
        elemt.add(4);
        d2.agregar("(", elemt);
        elemt = new ArrayList();
        elemt.add(8);
        d2.agregar("E", elemt);
        elemt = new ArrayList();
        elemt.add(2);
        d2.agregar("T", elemt);
        elemt = new ArrayList();
        elemt.add(3);
        d2.agregar("F", elemt);
        d[4] = d2;

        d2 = new Diccionario();
        elemt = new ArrayList();

        //elementos de 5
        elemt.add(false);
        d2.agregar("+", elemt);
        d2.agregar("*", elemt);
        d2.agregar(")", elemt);
        d2.agregar("$", elemt);
        d[5] = d2;

        d2 = new Diccionario();
        elemt = new ArrayList();

        //elementos de 6
        elemt.add(true);
        elemt.add(5);
        d2.agregar("i", elemt);
        elemt = new ArrayList();
        elemt.add(true);
        elemt.add(4);
        d2.agregar("(", elemt);
        elemt = new ArrayList();
        elemt.add(9);
        d2.agregar("T", elemt);
        elemt = new ArrayList();
        elemt.add(3);
        d2.agregar("F", elemt);
        d[6] = d2;

        elemt = new ArrayList();
        d2 = new Diccionario();

        //elementos de 7
        elemt.add(true);
        elemt.add(5);
        d2.agregar("i", elemt);
        elemt = new ArrayList();
        elemt.add(true);
        elemt.add(4);
        d2.agregar("(", elemt);
        elemt = new ArrayList();
        elemt.add(10);
        d2.agregar("F", elemt);
        d[7] = d2;

        elemt = new ArrayList();
        d2 = new Diccionario();

        //elementos de 8
        elemt.add(true);
        elemt.add(6);
        d2.agregar("+", elemt);
        elemt = new ArrayList();
        elemt.add(true);
        elemt.add(11);
        d2.agregar(")", elemt);
        d[8] = d2;

        elemt = new ArrayList();
        d2 = new Diccionario();

        //elementos de 9
        elemt.add(true);
        elemt.add(7);
        d2.agregar("*", elemt);
        elemt = new ArrayList();
        elemt.add(false);
        d2.agregar("+", elemt);
        d2.agregar(")", elemt);
        d2.agregar("$", elemt);
        d[9] = d2;

        //elementos de 10
        d2 = new Diccionario();
        d2.agregar("+", elemt);
        d2.agregar("*", elemt);
        d2.agregar(")", elemt);
        d2.agregar("$", elemt);
        d[10] = d2;

        //elemtentos de 11
        d[11] = d2;

    }

    public List obtener(int i, String s) {
        return d[i].obtener(s);
    }
}

class Diccionario {

    private final List indice = new ArrayList();
    private final List<List> elementos = new ArrayList();

    public void agregar(String s, List a) {
        indice.add(s);
        elementos.add(a);
    }

    public List obtener(String s) {
        for (int i = 0; i < tamaño(); i++) {
            if (indice.get(i).equals(s)) {
                return elementos.get(i);
            }
        }
        return new ArrayList();
    }

    public void borrar(String s) {
        for (int i = 0; i < tamaño(); i++) {
            if (indice.get(i).equals(s)) {
                indice.remove(i);
                elementos.remove(i);
            }
        }
    }

    public void agregar(int s, List a) {
        this.agregar("" + s, a);
    }

    public List obtener(int s) {
        return this.obtener("" + s);
    }

    public void borrar(int s) {
        this.borrar("" + s);
    }

    public int tamaño() {
        return indice.size();
    }
}
