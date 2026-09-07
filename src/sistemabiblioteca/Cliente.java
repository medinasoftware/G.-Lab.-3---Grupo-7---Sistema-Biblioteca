package sistemabiblioteca;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombreCliente;
    private String idCliente;
    private String telefono;
    private List<Pedido> pedidos;

    public Cliente(String nombreCliente, String idCliente, String telefono) {
        this.nombreCliente = nombreCliente;
        this.idCliente = idCliente;
        this.telefono = telefono;
        this.pedidos = new ArrayList<>();
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public Pedido realizarPedido(Libro libro) {
        Pedido pedido = new Pedido(libro);
        pedidos.add(pedido);

        System.out.println(
            nombreCliente + " realizó un pedido del libro: " + libro.getTitulo()
        );

        return pedido;
    }

    public void mostrarPedidos() {
        System.out.println("\nPedidos del cliente " + nombreCliente + ":");

        if (pedidos.isEmpty()) {
            System.out.println("No tiene pedidos.");
            return;
        }

        for (Pedido pedido : pedidos) {
            System.out.println("- " + pedido.getLibro().getTitulo());
        }
    }
}
