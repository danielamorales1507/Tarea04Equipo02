import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TiendaEnLinea {
    public static void main(String[] args) {
        // Crear la cola de pedidos
        Queue<Pedido> colaPedidos = new LinkedList<>();

        // Supongamos que estos son los pedidos recibidos durante el día
        colaPedidos.add(new Pedido("Cliente1", 2));
        colaPedidos.add(new Pedido("Cliente2", 5));
        colaPedidos.add(new Pedido("Cliente3", 7));
        colaPedidos.add(new Pedido("Cliente4", 1));
        colaPedidos.add(new Pedido("Cliente5", 10));

        // Mostrar la cola original
        System.out.println("Cola original de pedidos:");
        for (Pedido pedido : colaPedidos) {
            System.out.println(pedido);
        }

        // Procesar la cola y dividir en dos nuevas colas
        Queue<Pedido> colaMenosDeCinco = new LinkedList<>();
        Queue<Pedido> colaSeisOMas = new LinkedList<>();

        while (!colaPedidos.isEmpty()) {
            Pedido actual = colaPedidos.poll();
            if (actual.getCantidadArticulos() <= 5) {
                colaMenosDeCinco.add(actual);
            } else {
                colaSeisOMas.add(actual);
            }
        }

        // Mostrar las nuevas colas y el tamaño de la cola original
        System.out.println("\nPedidos con máximo de 5 artículos:");
        for (Pedido pedido : colaMenosDeCinco) {
            System.out.println(pedido);
        }

        System.out.println("\nPedidos con 6 o más artículos:");
        for (Pedido pedido : colaSeisOMas) {
            System.out.println(pedido);
        }

        System.out.println("\nTamaño de la cola original: " + colaPedidos.size());
    }
}

class Pedido {
    private String nombreCliente;
    private int cantidadArticulos;

    public Pedido(String nombreCliente, int cantidadArticulos) {
        this.nombreCliente = nombreCliente;
        this.cantidadArticulos = cantidadArticulos;
    }

    public int getCantidadArticulos() {
        return cantidadArticulos;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "nombreCliente='" + nombreCliente + '\'' +
                ", cantidadArticulos=" + cantidadArticulos +
                '}';
    }
}