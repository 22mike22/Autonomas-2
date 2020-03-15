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
public class E {
T t;
E2 e2;
    E(int n,String[] s,int p){
        p+=2;
        Arbol.imprimirNiveles(p, this.getClass().getName());
        t=new T(n,s,p);
        Arbol.creadorDeE2(n, s, p);
    }
}
