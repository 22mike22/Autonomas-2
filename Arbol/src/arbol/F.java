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
public class F {
    E e;
    F(int n,String[]s,int t){
        t+=2;
        Arbol.imprimirNiveles(t, this.getClass().getName());
        if(s[n]=="("){
            e=new E(n+1,s,t);
        }
    }
}
