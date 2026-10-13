// HERENCIA con SUPER y OVERRIDE
public class Mago extends Personaje {

    private int mana;

    public Mago(String nombre, int vida, int mana) {
        super(nombre, vida);
        this.mana = mana;
    }

    @Override
    public int atacar() {
        return super.atacar() + mana / 2;
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("  Mago | Maná: " + mana);
    }
}