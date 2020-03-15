/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arbol;

/**
 *
 * @author invitado
 */
public class T {
    F f;
    T2 t2;
    T(int n,String[]s,int t){
        t+=2;
        Arbol.imprimirNiveles(t, this.getClass().getName());
        f=new F(n,s,t);
        Arbol.creadorDeT2(n, s, t);
    }
}
