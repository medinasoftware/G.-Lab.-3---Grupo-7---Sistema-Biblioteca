package sistemabiblioteca;

import java.util.Date;

public class Pedido {

    private Date fechaSolicitud;
    private Boolean aprobado;
    private Libro libro;

    public Pedido(Libro libro) {
        this.libro = libro;
        this.fechaSolicitud = new Date();
        this.aprobado = false;
    }

    public Libro getLibro() {
        return libro;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public Boolean getAprobado() {
        return aprobado;
    }

    public void confirmar() {
        aprobado = true;
        System.out.println("Pedido confirmado para el libro: " + libro.getTitulo());
    }

    public void cancelar() {
        aprobado = false;
        System.out.println("Pedido cancelado para el libro: " + libro.getTitulo());
    }

    public void mostrarInformacion() {
        System.out.println("\n--- PEDIDO ---");
        System.out.println("Libro: " + libro.getTitulo());
        System.out.println("Fecha: " + fechaSolicitud);
        System.out.println("Aprobado: " + aprobado);
    }
}
