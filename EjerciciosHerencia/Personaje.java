// Clase base
public class Personaje {

    private String nombre;
    private int vida;

    // Constructor vacío (lo usa la herencia simple)
    public Personaje() {
        nombre = "Sin nombre";
        vida = 50;
    }

    public Personaje(String nombre, int vida) {
        this.nombre = nombre;
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public int atacar() {
        return 5;
    }

    public void recibirDanio(int danio) {
        vida = Math.max(0, vida - danio);
    }

    public void mostrar() {
        System.out.println(nombre + " | Vida: " + vida);
    }

    // ----- SOBRECARGA: mismo nombre, distintos parámetros -----
    public void curar() {
        curar(10);
    }

    public void curar(int cantidad) {
        vida = Math.min(100, vida + cantidad);
    }

    public void curar(int cantidad, String pocion) {
        System.out.println(nombre + " bebe " + pocion);
        curar(cantidad);
    }
}