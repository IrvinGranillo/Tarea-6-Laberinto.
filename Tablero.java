
package laberintos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablero {
     private Array2d tablero;
     private String direccion;

    public Tablero( String direccion) throws FileNotFoundException {
        this.direccion = direccion;
        int filas=0,columnas = 0;
         String linea;

        
        try {
            BufferedReader bufer = new BufferedReader(new FileReader(this.direccion));

            linea = "";
           
            while (linea != null) {
               
                linea = bufer.readLine();
                if (linea == null) {
                    break;
                }
                filas++;
                String datos[] = linea.split(",");
                columnas=datos.length;

                

            }
          
        } catch (FileNotFoundException ex) {

            System.err.print(ex);
        } catch (IOException ex) {

            Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
        }
       ///////////////////////////////////////////////////////// 
        this.tablero =new Array2d(columnas, new Array(filas));
       // System.out.println(columnas+" ,,,,, "+filas);
        filas=0;
           try {
            BufferedReader bufer = new BufferedReader(new FileReader(this.direccion));

            linea = "";
           
            while (linea != null) {
               
              
                linea = bufer.readLine();
                if (linea == null) {
                    break;
                }
                
                  String datos[] = linea.split(",");
                  
               for(int i=0;i<tablero.get_columna_tamaño();i++){
                   tablero.set_item(filas, i, datos[i]);
                   
               }
               filas++;

            }
            
          
        } catch (FileNotFoundException ex) {

            System.err.print(ex);
        } catch (IOException ex) {

            Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);

        }
        
    }
  /*  public void imprimir(){
        for(int i=0;i<tablero.get_fila_tamaño();i++){
            for(int j=0;j<tablero.getNumcolumnas();j++){
                System.out.print("{"+tablero.get_item(i, j)+"]");
            }
            System.out.println();
            
        }
    }*/

    public Array2d getTablero() {
        return tablero;
    }
    
     
    
}
