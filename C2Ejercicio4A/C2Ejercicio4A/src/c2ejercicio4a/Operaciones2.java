
package c2ejercicio4a;

import javax.swing.JOptionPane;
public class Operaciones2 {
    //Atributos
    public Bebida[][] estanteria;

    
    //Constructores
    public Operaciones2(int filas, int columnas) {
        estanteria = new Bebida[filas][columnas];
    }

    public Operaciones2() {
        estanteria = new Bebida[5][5];
    }

    //Metodos
    
    /**
     * Agega una bebida, primera posicion que encuentre
     * @param b 
     */
    public void agregarBebida(Bebida b) {
        try {
           boolean encontrado = false;
        //System.out.println("\n Longitud del arreglo: "+estanteria.length);
        for (int i=0; i <= estanteria.length && !encontrado; i++) {
            for (int j = 0; j <= estanteria[0].length && !encontrado; j++) {
                if (estanteria[i][j] == null) {
                    estanteria[i][j] = b; //inserto la bebida
                    //System.out.println(estanteria[i][j]);
                    encontrado = true; //Salgo
                }
            }  
        }
         
        //Indico si se ha añadiddo la bebida o no
        if (encontrado) {
            JOptionPane.showMessageDialog(null, "Bebida Añadida");
            //System.out.println("Bebida añadida");
        } else {
            JOptionPane.showMessageDialog(null, "No se ha podido añadir la bebida");
            //System.out.println("No se ha podido añadir la bebida");
        }
      } catch (Exception e){
          JOptionPane.showMessageDialog(null, "Almacen lleno...");
      }
    }

    /**
     * Elimina la bebida con el id que le pasen, sino esta se indica
     * @param id 
     */
    public void eliminarBebida(int id) {
        boolean encontrado = false;
        for (int i = 0; i < estanteria.length && !encontrado; i++) {
            for (int j = 0; j < estanteria[0].length && !encontrado; j++) {
                if (estanteria[i][j] != null) {
                    if (estanteria[i][j].getId() == id) {
                        estanteria[i][j] = null; //Elimino la bebida
                        encontrado = true; //Salgo
                    }
                }
            }
        }

        //Indico si se ha eliminado
        if (encontrado) {
            JOptionPane.showMessageDialog(null, "Bebida eliminada");
        } else {
            JOptionPane.showMessageDialog(null, "No existe la bebida");
            System.out.println("No existe la bebida");
        }

    }

    /**
     * Recorro las estantenrias y muestro las bebidas
     * @return 
     */
    public String mostrarBebidas() {
        String salidaBebida = "";
        for (int i = 0; i < estanteria.length; i++) {
            for (int j = 0; j < estanteria[0].length; j++) {
                if (estanteria[i][j] != null) {//controlo nulos
                    //System.out.println("fila " + i + ", columna: " + j + " Bebida: " + estanteria[i][j].toString());
                     salidaBebida += "fila " + i + ", columna: " + j + " Bebida: " + estanteria[i][j].toString() + "\n";
                }
            }
        }
        return salidaBebida;
    }

    /**
     * Calcula el precio de todas las bebidas
     * @return 
     */
    public double calcularPrecioBebidas() {

        double precioTotal = 0;
        for (int i = 0; i < estanteria.length; i++) {
            for (int j = 0; j < estanteria[0].length; j++) {
                if (estanteria[i][j] != null) {//controlo nulos
                    precioTotal += estanteria[i][j].getPrecio();//acumulo el precio
                }
            }
        }

        return precioTotal;

    }

    /**
     * Calcula el precio de todas las bebidas de una marca
     * @param marca
     * @return 
     */
    public double calcularPrecioBebidas(String marca) {

        double precioTotal = 0;
        for (int i = 0; i < estanteria.length; i++) {
            for (int j = 0; j < estanteria[0].length; j++) {
                if (estanteria[i][j] != null) {//controlo nulos

                    if (estanteria[i][j].getMarca().equalsIgnoreCase(marca)) {
                        precioTotal += estanteria[i][j].getPrecio(); //acumulo el precio
                    }

                }
            }

        }

        return precioTotal;
    }

    /**
     * Calcula el precio de todas las bebidas de una determinada columna
     * @param columna
     * @return 
     */
    public double calcularPrecioBebidas(int columna) {

        double precioTotal = 0;
        if (columna >= 0 && columna < estanteria[0].length) {

            for (int i = 0; i < estanteria.length; i++) {

                if (estanteria[i][columna] != null) { //controlo nulos
                    precioTotal += estanteria[i][columna].getPrecio(); //acumulo el precio
                }

            }

        } else {
            System.out.println("La columna debe estar entre 0 y " + estanteria[0].length);
        }

        return precioTotal;

    }
}
