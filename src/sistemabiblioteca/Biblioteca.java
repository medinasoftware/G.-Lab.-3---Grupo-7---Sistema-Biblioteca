package sistemabiblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private String nombre;
    private String direccion;
    private String horarioAtencion;
    private List<Seccion> secciones;

    public Biblioteca(String nombre, String direccion, String horarioAtencion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horarioAtencion = horarioAtencion;
        this.secciones = new ArrayList<>();
    }

    public Seccion crearSeccion(String nombre, String tipoLibro, String ubicacion) {
        Seccion seccion = new Seccion(nombre, tipoLibro, ubicacion);
        secciones.add(seccion);
        return seccion;
    }

    public void registrarLibro(Libro libro) {
        if (secciones.isEmpty()) {
            System.out.println("No existen secciones para registrar el libro.");
            return;
        }
        secciones.get(0).agregarLibro(libro);
    }

    public void registrarLibro(Libro libro, Seccion seccion) {
        seccion.agregarLibro(libro);
    }

    public void mostrarSecciones() {
        System.out.println("\n=== BIBLIOTECA " + nombre + " ===");
        System.out.println("Dirección: " + direccion);
        System.out.println("Horario: " + horarioAtencion);
        System.out.println("\nSecciones:");

        for (Seccion seccion : secciones) {
            System.out.println("- " + seccion.getNombre());
        }
    }
}
