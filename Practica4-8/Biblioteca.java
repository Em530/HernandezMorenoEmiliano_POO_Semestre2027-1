/** Práctica 4-8: Sistema de Gestión de Biblioteca
 * Código 3: Clase Biblioteca
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Programa que engloba toda la biblioteca y los "sub"-programas que ya hicimos. 
 */
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Bibliotecario> empleados;
    private ArrayList<Prestamo> prestamos;

    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    //Metodos
    public Libro buscarLibro(String isbn){
        for (Libro libro : libros){
            if (libro.getIsbn().equals(isbn)){
                return libro;
            }
        }
        return null;
    }

    //Sobrecarga Metodos
    public Libro buscarLibro(String titulo, String autor){
        for (Libro libro : libros){
            if (libro.getTitulo().equalsIgnoreCase(titulo)
                && libro.getAutor().equalsIgnoreCase(autor)){
                return libro;
            }
        }
        return null;
    }

    public void agregarLibro(Libro libro){
        if (buscarLibro(libro.getIsbn()) != null){
            System.out.println("El libro que desea agregar ya existe.");
        } else{
            libros.add(libro);
            System.out.println("Se ha agregado el libro correctamente al catalogo. ;)");
        }
    }

    public void eliminarLibro(String isbn){
        Libro libro = buscarLibro(isbn);
        if (libro == null){
            System.out.println("El libro que intenta eliminar no existe. :(");
        } else{
            libros.remove(libro);
            System.out.println("El libro se ha eliminado correctamente. ;)");
        }
    }

    public void mostrarCatalogo(){
        if (libros.isEmpty()){
            System.out.println("El catalogo esta vacio. :(");
        } else{
            for (Libro libro : libros){
                System.out.println(libro);
            }
        }
    }

    public Usuario buscarUsuario(int id){
        for (Usuario usuario : usuarios){
            if (usuario.getId() == id){
                return usuario;
            }
        }
        return null;
    }

    public void registrarUsuario(Usuario usuario){
        if (buscarUsuario(usuario.getId()) != null){
            System.out.println("El ID del usuario que desea registrar ya se encuentra en el sistema.");
        } else{
            usuarios.add(usuario);
            System.out.println("El ID del usuario nuevo a sido registrado con exito.");
        }
    }

    public void mostrarUsuarios(){
        if (usuarios.isEmpty()){
            System.out.println("No se han encontrado usuarios registrados en el sistema.");
        } else{
            for (Usuario usuario : usuarios){
                usuario.mostrarInformacion();
            } 
        }
    }

    public void registrarBibliotecario(Bibliotecario bibliotecario){
        for (Bibliotecario empleado : empleados){
            if (empleado.getId() == bibliotecario.getId()){
                System.out.println("Ya existe un empleado con ese ID.");
                return;
            }
        }

        empleados.add(bibliotecario);
        System.out.println("Empleado registrado correctamente.");

    }

    public void mostrarBibliotecarios(){
        if (empleados.isEmpty()){
            System.out.println("No hay empleados registrados.");
        } else{
            for (Bibliotecario bibliotecario : empleados){
                bibliotecario.mostrarInformacion();
            }
        }
    }

    public Prestamo buscarPrestamo(String isbn){
        for (Prestamo prestamo : prestamos){
            if (prestamo.estaActivo() && prestamo.getLibro() != null &&
                prestamo.getLibro().getIsbn() != null && prestamo.getLibro().getIsbn().equalsIgnoreCase(isbn)){
                    return prestamo;
                }
        }

        return null;
    }

    public void realizarPrestamo(Usuario usuario, Libro libro){
        if (! libro.estaDisponible()){
            System.out.println("El libro no esta disponible por el momento.");
            return;
        }
        if (! usuario.getActivo()){
            System.out.println("El usuario no esta activo, no se le puede hacer un prestamo.");
            return;
        } 
        Prestamo prestamo = new Prestamo(usuario, libro);
        prestamo.iniciarPrestamo();
        prestamos.add(prestamo);
    }

    public void devolverLibro(Prestamo prestamo){
        if (! prestamo.estaActivo()){
            System.out.println("El libro que se intenta devolver ya ha sido devuelto.");
        } else{
            prestamo.finalizarPrestamo();
        }
    }

    public void mostrarPrestamos(){
        if (prestamos.isEmpty()){
            System.out.println("No hay ningun prestamo, todos los libros se encuentran seguros. :)");
        } else{
            for (Prestamo prestamo : prestamos){
                System.out.println(prestamo);
            }
        }
    }
}