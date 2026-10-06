public abstract class PersonaP4 {
    
    //Atributos
    protected int id;
    protected String nombre;
    protected String correo;

    //Constructores
    public PersonaP4(){}
    public PersonaP4(int id, String nombre, String correo){
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    //Metodos
    public abstract void mostrarInformacion();
    public void setId(int id){
        this.id = id;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }
    public int getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public String getCorreo(){
        return correo;
    }
}