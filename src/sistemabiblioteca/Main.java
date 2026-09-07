package sistemabiblioteca;

public class Main {

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println("   SISTEMA DE BIBLIOTECA");
        System.out.println("================================");

        // 1. Crear biblioteca
        Biblioteca biblioteca = new Biblioteca(
                "Biblioteca UPN",
                "Av. Universitaria - Lima",
                "08:00 AM - 08:00 PM"
        );

        // 2. COMPOSICIÓN: Biblioteca - Seccion
        Seccion programacion = biblioteca.crearSeccion(
                "Programación",
                "Tecnología",
                "Primer Piso"
        );

        Seccion literatura = biblioteca.crearSeccion(
                "Literatura",
                "Novelas",
                "Segundo Piso"
        );

        // 3. Crear libros
        Libro libro1 = new Libro(
                "Clean Code",
                "Robert C. Martin",
                "L001"
        );

        Libro libro2 = new Libro(
                "Java Básico",
                "Juan Pérez",
                "L002"
        );

        Libro libro3 = new Libro(
                "Don Quijote de la Mancha",
                "Miguel de Cervantes",
                "L003"
        );

        // 4. AGREGACIÓN: Seccion - Libro
        biblioteca.registrarLibro(libro1, programacion);
        biblioteca.registrarLibro(libro2, programacion);
        biblioteca.registrarLibro(libro3, literatura);

        // 5. RECORRER / MOSTRAR las colecciones
        biblioteca.mostrarSecciones();
        programacion.mostrarLibros();
        literatura.mostrarLibros();

        // 6. ELIMINAR un elemento de la colección
        System.out.println("\n=== ELIMINANDO LIBRO ===");
        programacion.eliminarLibro(libro2);
        programacion.mostrarLibros();

        // 7. Crear cliente
        Cliente cliente = new Cliente(
                "Carlos Ramirez",
                "C001",
                "987654321"
        );

        // 8. ASOCIACIÓN: Cliente - Pedido
        Pedido pedido = cliente.realizarPedido(libro1);
        pedido.mostrarInformacion();
        cliente.mostrarPedidos();

        // 9. Crear empleados
        Empleado recepcionista = new Empleado(
                "María Torres",
                "E001",
                "Recepcionista"
        );

        Empleado auxiliar = new Empleado(
                "Luis López",
                "E002",
                "Auxiliar"
        );

        // 10. REFLEXIVIDAD: Empleado - Empleado
        auxiliar.establecerSupervisor(recepcionista);

        recepcionista.mostrarSupervisor();
        auxiliar.mostrarSupervisor();
        recepcionista.mostrarSupervisados();

        // 11. Empleado busca el libro solicitado
        recepcionista.buscarLibroSolicitado(libro1);

        // 12. Empleado valida y entrega el pedido
        System.out.println("\n=== ENTREGA DEL LIBRO ===");
        recepcionista.entregarLibro(pedido);

        // 13. Comprobar estado del libro
        System.out.println("\n=== ESTADO DEL LIBRO ===");
        libro1.mostrarInformacion();

        // 14. Devolución
        System.out.println("\n=== DEVOLUCIÓN ===");
        libro1.devolver();
        libro1.mostrarInformacion();

        System.out.println("\n================================");
        System.out.println("Programa finalizado correctamente.");
        System.out.println("================================");
    }
}
