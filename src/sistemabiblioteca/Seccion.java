package sistemabiblioteca;

import java.util.ArrayList;
import java.util.List;

public class Seccion {

    private String nombre;
    private String tipoLibro;
    private String ubicacion;
    private List<Libro> libros;

    public Seccion(String nombre, String tipoLibro, String ubicacion) {
        this.nombre = nombre;
        this.tipoLibro = tipoLibro;
        this.ubicacion = ubicacion;
        this.libros = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoLibro() {
        return tipoLibro;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado a la sección " + nombre + ": " + libro.getTitulo());
    }

    public void eliminarLibro(Libro libro) {
        if (libros.remove(libro)) {
            System.out.println("Libro eliminado de la sección: " + libro.getTitulo());
        } else {
            System.out.println("El libro no se encuentra en la sección.");
        }
    }

    public List<Libro> listarLibros() {
        return new ArrayList<>(libros);
    }

    public void mostrarLibros() {
        System.out.println("\n--- SECCIÓN: " + nombre + " ---");
        System.out.println("Tipo: " + tipoLibro);
        System.out.println("Ubicación: " + ubicacion);

        if (libros.isEmpty()) {
            System.out.println("No existen libros registrados.");
            return;
        }

        for (Libro libro : libros) {
            System.out.println("- " + libro.getTitulo() + " | " + libro.getAutor());
        }
    }
}
