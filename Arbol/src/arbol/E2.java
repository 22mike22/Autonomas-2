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
public class E2 {
    T t;
    E2 e2;
    E2(int n,String[]s,int p){
        p+=2;
        Arbol.imprimirNiveles(p, this.getClass().getName());
        if(s[n+1]=="+"){
            t=new T(n+2,s,p);
            e2=new E2(n+2,s,p);
        }
    }
    E2(){
        
    }
}
