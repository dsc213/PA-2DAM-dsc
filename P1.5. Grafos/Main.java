
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
    }
}
