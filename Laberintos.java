
package laberintos;

import java.io.FileNotFoundException;


public class Laberintos {

  
    public static void main(String[] args) throws FileNotFoundException {
       Tablero tab1=new Tablero("C:\\Users\\ijgm9\\OneDrive\\Escritorio\\Tablero1.txt");
     //  tab1.imprimir();
    
    Back_tracking juego=new Back_tracking(tab1.getTablero());
   juego.play();
    
    
    }
    
}
