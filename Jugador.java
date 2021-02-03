import java.util.Scanner;

 

public class Jugador {
    private String nombre;
    private String apellidos;
    private int dorsal;
    private String posicion;

 

    public Jugador(String nombre, String apellidos, String posicion, int dorsal) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dorsal = dorsal;
        this.posicion = posicion;
    }

 

    public void setNombre(String nombre) {

 

        this.nombre = nombre;

 

    }

 

    public void setApellidos(String apellidos) {

 

        this.apellidos = apellidos;

 

    }

 

    public void setDorsal(int dorsal) {

 

        this.dorsal = dorsal;

 

    }

 

    public void setPosicion(String posicion) {

 

        this.posicion = posicion;

 

    }

 

    public String getNombre() {
        return this.nombre;
    }

 

    public String getApellidos() {
        return this.apellidos;
    }

 

    public String getPosicion() {
        return this.posicion;
    }

 

    public int getDorsal() {
        return this.dorsal;
    }

 

    public void imprimirJugador() {
        System.out.println(this.nombre + " " + this.apellidos + " " + this.posicion + " " + this.dorsal);
    }

 

}