package sistemabiblioteca;

import java.util.ArrayList;
import java.util.List;

public class Empleado {

    private String nombreEmpleado;
    private String idEmpleado;
    private String cargo;

    // Relación reflexiva: un Empleado puede tener otro Empleado como supervisor.
    private Empleado supervisor;
    private List<Empleado> empleadosSupervisados;

    // Asociación con Pedido: un empleado puede atender varios pedidos.
    private List<Pedido> pedidosAtendidos;

    public Empleado(String nombreEmpleado, String idEmpleado, String cargo) {
        this.nombreEmpleado = nombreEmpleado;
        this.idEmpleado = idEmpleado;
        this.cargo = cargo;
        this.empleadosSupervisados = new ArrayList<>();
        this.pedidosAtendidos = new ArrayList<>();
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public String getCargo() {
        return cargo;
    }

    public void establecerSupervisor(Empleado supervisor) {
        this.supervisor = supervisor;
        if (supervisor != null && !supervisor.empleadosSupervisados.contains(this)) {
            supervisor.empleadosSupervisados.add(this);
        }
    }

    public void mostrarSupervisor() {
        if (supervisor != null) {
            System.out.println(
                nombreEmpleado + " es supervisado por " + supervisor.getNombreEmpleado()
            );
        } else {
            System.out.println(nombreEmpleado + " no tiene supervisor.");
        }
    }

    public void mostrarSupervisados() {
        System.out.println("\nEmpleados supervisados por " + nombreEmpleado + ":");

        if (empleadosSupervisados.isEmpty()) {
            System.out.println("No supervisa empleados.");
            return;
        }

        for (Empleado empleado : empleadosSupervisados) {
            System.out.println("- " + empleado.getNombreEmpleado());
        }
    }

    public Libro buscarLibroSolicitado(Libro libro) {
        System.out.println(
            nombreEmpleado + " está buscando el libro " + libro.getTitulo()
        );

        if (libro.isDisponible()) {
            System.out.println("Libro encontrado y disponible.");
            return libro;
        }

        System.out.println("El libro no está disponible.");
        return null;
    }

    public boolean validarSolicitud(Pedido pedido) {
        if (pedido.getLibro().isDisponible()) {
            System.out.println("Solicitud validada por " + nombreEmpleado);
            return true;
        }

        System.out.println("Solicitud rechazada. Libro no disponible.");
        return false;
    }

    public void atenderPedido(Pedido pedido) {
        pedidosAtendidos.add(pedido);
    }

    public void entregarLibro(Pedido pedido) {
        if (validarSolicitud(pedido)) {
            pedido.confirmar();
            pedido.getLibro().prestar();
            atenderPedido(pedido);
            System.out.println(nombreEmpleado + " entregó el libro a préstamo.");
        } else {
            pedido.cancelar();
        }
    }
}
