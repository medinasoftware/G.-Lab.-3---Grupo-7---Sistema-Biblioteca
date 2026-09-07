package sistemabiblioteca;

public class Libro {

    private String titulo;
    private String autor;
    private String idLibro;
    private boolean disponible;

    public Libro(String titulo, String autor, String idLibro) {
        this.titulo = titulo;
        this.autor = autor;
        this.idLibro = idLibro;
        this.disponible = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIdLibro() {
        return idLibro;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void prestar() {
        if (disponible) {
            disponible = false;
            System.out.println("Libro prestado: " + titulo);
        } else {
            System.out.println("El libro " + titulo + " no está disponible.");
        }
    }

    public void devolver() {
        disponible = true;
        System.out.println("Libro devuelto: " + titulo);
    }

    public void mostrarInformacion() {
        System.out.println("ID: " + idLibro);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Estado: " + (disponible ? "Disponible" : "Prestado"));
    }
}
