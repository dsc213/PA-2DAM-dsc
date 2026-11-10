
public class Main {

    public static void main(String[] args) {

        Grafo grafo = new Grafo();

        // Añadir ciudades
        grafo.agregarVertice("Madrid");
        grafo.agregarVertice("Toledo");
        grafo.agregarVertice("Cuenca");
        grafo.agregarVertice("Albacete");

        // Añadir conexiones
        grafo.agregarArista("Madrid", "Toledo");
        grafo.agregarArista("Madrid", "Cuenca");
        grafo.agregarArista("Toledo", "Albacete");
        grafo.agregarArista("Cuenca", "Albacete");

        System.out.println("VERTICES:");
        grafo.mostrarVertices();

        System.out.println("\nARISTAS:");
        grafo.mostrarAristas();

        System.out.println("\nCONEXIONES:");
        System.out.println(
                grafo.estanConectados("Madrid", "Toledo")
        );

        System.out.println(
                grafo.estanConectados("Madrid", "Albacete")
        );

        System.out.println();
        grafo.mostrarVecinos("Madrid");


        // Comprobar el comportamiento

        System.out.println("\nRUTA DE MADRID A ALBACETE:");

        System.out.println(grafo.buscarRutaDFS("Madrid", "Albacete"));


        // Eliminar la conexion Toledo - Albacete
        System.out.println("\nELIMINAR TOLEDO - ALBACETE:");

        grafo.eliminarArista("Toledo", "Albacete");

        System.out.println(grafo.buscarRutaDFS("Madrid", "Albacete"));


        // Eliminar la conexion Cuenca - Albacete
        System.out.println("\nELIMINAR CUENCA - ALBACETE:");

        grafo.eliminarArista("Cuenca", "Albacete");

        System.out.println(grafo.buscarRutaDFS("Madrid", "Albacete"));


        // Buscar una ruta entre ciudades sin conexion
        System.out.println("\nBUSCAR RUTA SIN CONEXION:");

        System.out.println(grafo.buscarRutaDFS("Madrid", "Albacete"));


        // Buscar una ruta desde Madrid hasta Madrid
        System.out.println("\nBUSCAR RUTA DE MADRID A MADRID:");

        System.out.println(grafo.buscarRutaDFS("Madrid", "Madrid"));

    }
}
