package laberintos;

public class Back_tracking {

    private Array2d Espacios;
    private Pila anteriores;
    private Pila posiciones;
    private Pila direcciones;
    private posicion inicio, fin, actual, anterior;

    public Back_tracking(Array2d casillas) {
        this.Espacios = casillas;
        this.actual = new posicion(-1, -1);
        this.anterior = new posicion(-1, -1);
        this.posiciones = new Pila();
        this.anteriores = new Pila();
        this.direcciones=new Pila();
        anteriores.push(new posicion(-1, -1));

        for (int i = 0; i < casillas.get_fila_tamaño(); i++) {
            for (int j = 0; j < casillas.getNumcolumnas(); j++) {
                //System.out.println(casillas.get_item(i, j));
                if (casillas.get_item(i, j).equals("E")) {
                    inicio = new posicion(i, j);
                    this.posiciones.push(inicio);

                }
                if (casillas.get_item(i, j).equals("S")) {
                    this.fin = new posicion(i, j);

                }
            }

        }
        //  System.out.println("final es"+fin);
        imprimir();
        System.out.println("");
        casillas.set_item(fin.getX(), fin.getY(), "0");
    }
    boolean accion;

    public void movimiento() {
        actual = (posicion) posiciones.peek();
        anterior = (posicion) anteriores.peek();
        accion = true;
        //*1
        if (validacion(actual.getX() - 1, actual.getY()) && accion) {
            //Esta dentro de las casillas 
            if (Espacios.get_item(actual.getX() - 1, actual.getY()).equals("0")) {
                // La casilla esta libre 
                posicion auxil = new posicion(actual.getX() - 1, actual.getY());
                // no sea igual al anterior 

                if (auxil.getX() == anterior.getX() && auxil.getY() == anterior.getY()) {
                    // System.out.println("REGREASA AL ANTERIOR");
                } else {
                    //acciones
                    posiciones.push(auxil);
                    direcciones.push("|");
                    anteriores.push(actual);
                    accion = false;
                }

            }

        }

        //2
        if (validacion(actual.getX(), actual.getY() + 1) && accion) {
            //Esta dentro de las casillas 
            if (Espacios.get_item(actual.getX(), actual.getY() + 1).equals("0")) {
                // La casilla esta libre 
                posicion auxil = new posicion(actual.getX(), actual.getY() + 1);
                // no sea igual al anterior 

                if (auxil.getX() == anterior.getX() && auxil.getY() == anterior.getY()) {
                    //   System.out.println("REGREASA AL ANTERIOR");
                } else {
                    //acciones
                    posiciones.push(auxil);
                    anteriores.push(actual);
                    direcciones.push(">");
                    accion = false;
                }

            }

        }
        //3
        if (validacion(actual.getX() + 1, actual.getY()) && accion) {
            //Esta dentro de las casillas 
            if (Espacios.get_item(actual.getX() + 1, actual.getY()).equals("0")) {
                // La casilla esta libre 
                posicion auxil = new posicion(actual.getX() + 1, actual.getY());
                // no sea igual al anterior 

                if (auxil.getX() == anterior.getX() && auxil.getY() == anterior.getY()) {
                    //    System.out.println("regresa");
                } else {
                    //acciones
                    posiciones.push(auxil);
                    anteriores.push(actual);
                    direcciones.push("|");
                    accion = false;
                }

            }

        }
        //4
        if (validacion(actual.getX(), actual.getY() - 1) && accion) {
            //Esta dentro de las casillas 
            if (Espacios.get_item(actual.getX(), actual.getY() - 1).equals("0")) {
                // La casilla esta libre 
                posicion auxil = new posicion(actual.getX(), actual.getY() - 1);
                // no sea igual al anterior 

                if (auxil.getX() == anterior.getX() && auxil.getY() == anterior.getY()) {

                } else {
                    //acciones
                    posiciones.push(auxil);
                    anteriores.push(actual);
                    direcciones.push("<");
                    accion = false;
                }

            }

        }
        if (accion) {
            // si no se logro ninguna 
            Espacios.set_item(actual.getX(), actual.getY(), "*");
            anteriores.pop();
            posiciones.pop();
            direcciones.pop();

        }
        actual = (posicion) posiciones.peek();
       // System.out.println("LA POSICION ACTUAL ES "+posiciones.peek());
        
    }

    public void play() {
        posicion aux = (posicion) posiciones.peek();

        //  System.out.println(posiciones.peek() + "=" + this.fin);
        while (actual.getX() != fin.getX() || actual.getY() != fin.getY()) {

            movimiento();

        }
        
        
        System.out.println(posiciones);
        for(int i=1;i<posiciones.length();){
posicion aux2=(posicion) posiciones.pop();
Espacios.set_item(aux2.getX(), aux2.getY(),direcciones.pop());

        }
Espacios.set_item(fin.getX(), fin.getY(), "S");
        imprimir();
    }

    public boolean validacion(int filas, int columnas) {

        return !(filas < 0 || filas >= Espacios.get_fila_tamaño() || columnas < 0 || columnas >= Espacios.get_columna_tamaño());
    }

    public void imprimir() {
        for (int i = 0; i < Espacios.get_fila_tamaño(); i++) {
            for (int j = 0; j < Espacios.getNumcolumnas(); j++) {
                System.out.print("{" + Espacios.get_item(i, j) + "]");
            }
            System.out.println();

        }
    }

}
