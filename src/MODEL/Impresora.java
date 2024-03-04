/**
 * 
 */
package MODEL;

/**
 * @author ofici
 *
 */
public class Impresora {

	private String modelo;
    private long serie;
    private float precio;

    public Impresora(String modelo, long serie, float precio) {
        this.modelo = modelo;
        this.serie = serie;
        this.precio = precio;
    }

    // Getters y setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public long getSerie() {
        return serie;
    }

    public void setSerie(long serie) {
        this.serie = serie;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Modelo: " + modelo + ", Serie: " + serie + ", Precio: " + precio;
    }
}
