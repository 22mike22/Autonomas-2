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
public class T2 {
    F f;
    T2 t2;
    T2(int n,String[]s,int t){
        t+=2;
        Arbol.imprimirNiveles(t, this.getClass().getName());
        if(s[n+1]=="*"){
            f=new F(n+2,s,t);
            t2=new T2(n+2,s,t);
        }
    }
    T2(){
        
    }
}
