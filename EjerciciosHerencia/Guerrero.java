// HERENCIA con SUPER y OVERRIDE
public class Guerrero extends Personaje {

    private int fuerza;

    public Guerrero(String nombre, int vida, int fuerza) {
        super(nombre, vida);          // SUPER
        this.fuerza = fuerza;
    }

    @Override                          // OVERRIDE
    public int atacar() {
        return super.atacar() + fuerza;
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("  Guerrero | Fuerza: " + fuerza);
    }
}