package laberintos;

import java.util.ArrayList;

public class Pila<T> {

    private ArrayList<T> datos;
    private int limitador;

    public Pila(int limitador) {
        this.datos = new ArrayList<>();
        this.limitador = limitador;
    }

    public Pila() {
        this.datos = new ArrayList<>();
     
    }

    public boolean EstaVacia() {
        return !this.datos.isEmpty();
    }

    public int length() {
        return this.datos.size();
    }

    public T pop() {
        if (!EstaVacia()) {
            System.out.println("Esta vacia");
            return null;
        } else {
            T aux = datos.get(datos.size()-1);
           // System.out.println(datos.size());

            datos.remove(datos.size()-1);
            return aux;
        }
    }

    public T peek(  ) {
        if (!EstaVacia()) {
            System.out.println("Esta vacia");
            return null;
        } else {
           // System.out.println(datos.size()-1);
            return datos.get(datos.size()-1);
        }
    }

    public void push(T valor) {
       if(limitador==0){
           datos.add(valor);
           
       }else{
         
           if(limitador>datos.size()){
              datos.add(valor);
           }else{
               System.out.println("Solo puedes agregar"+limitador+"Datos");
           }
       }

    }

    @Override
    public String toString() {
      for(int i=1;i<length();i++){
          
        System.out.println(datos.get((datos.size()) - i));  
      }
        return "";
    }

}
