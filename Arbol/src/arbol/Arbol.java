/*
 Usar el debug project ya que este codigo no cuenta con una funcion para imprimir el arbol
 */

package arbol;

/**
 *
 * @author Miguel Angel
 */
public class Arbol {
    public static int p=0;
        String[][]a=new String[1][1];
    public static void main(String[] args) {
        // TODO code application logic here
        String[]s={"(","i","+","i","*","i",")","+","i","*","i","$"};
        E e=new E(0,s,0);
        System.out.println();
    }
    public static void imprimirNiveles(int n,String letra){
        n-=2;
        for(int i=0;i<n;i++)
            if(i%2==0)System.out.print("|");
            else System.out.print(" ");
        System.out.println(letra.substring(6));
    }
    
    public void agregar(String s,int nivel){
        String[]t=a[nivel];
        String[]aux=new String[a.length+1];
        System.arraycopy(t, 0, aux, 0, t.length);
        aux[aux.length-1]=s;
        t=aux;
    }
    
    public static E2 creadorDeE2(int n,String[]s,int p){
        E2 e2=new E2();
        boolean t=false;
        for(int i=n;i<s.length;i++){
            if("(".equals(s[i])){
                t=true;
                break;
            }
        }
        if(t){
            for(int i=n;i<=s.length;i++){
                if(i==s.length)System.out.println("No se cierra el (");
                else if(")".equals(s[i])){
                    e2=new E2(i,s,p);
                    break;
                }
            }
        }else e2=new E2(n,s,p);
        return e2;
    }
    public static T2 creadorDeT2(int n,String[]s,int p){
        T2 t2=new T2();
        boolean t=false;
        for(int i=n;i<s.length;i++){
            if("(".equals(s[i])){
                t=true;
                break;
            }
        }
        if(t){
            for(int i=n;i<=s.length;i++){
                if(i==s.length)System.out.println("No se cierra el (");
                else if(")".equals(s[i])){
                    t2=new T2(i,s,p);
                    break;
                }
            }
        }else t2=new T2(n,s,p);
        return t2;
    }
}
