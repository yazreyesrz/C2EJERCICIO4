
package c2ejercicio4a;

public class AguaMineral extends Bebida{
    //Atributos
    private String manatial;

    //Constructores
    public AguaMineral(String manatial, double cantidad, double precio, String marca) {
        super(cantidad, precio, marca);
        this.manatial = manatial;
    }

    //Metodos
    public String getManatial() {
        return manatial;
    }

    public void setManatial(String manatial) {
        this.manatial = manatial;
    }

    @Override
    public String toString() {
        return super.toString() + " Agua Mineral Natural= " + manatial;
    }
}
