
import java.util.*;

public class Grafo {

    private ArrayList<Vertice> vertices;
    private ArrayList<Arista> aristas;

    public Grafo() {
        vertices = new ArrayList<>();
        aristas = new ArrayList<>();
    }

    // Devuelve el número de ciudades del grafo
    public int contarVertices() {
        int contador = 0;
        for (Vertice v : vertices) {
            contador++;
        }
        return contador;
    }

    // Devuelve el número de conexiones
    public int contarAristas() {
        int contador = 0;
        for (Arista a : aristas) {
            contador++;
        }
        return contador;
    }

    // Elimina una conexión entre dos ciudades
    public void eliminarArista(String origen, String destino) {
        if (!aristas.isEmpty()) {
            for (int i = 0; i < aristas.size(); i++) {
                Arista a = aristas.get(i);

                if (a.getOrigen().getNombre().equals(origen) && a.getDestino().getNombre().equals(destino)) {
                    aristas.remove(a);
                    System.out.println("Conexion eliminada.");
                }
            }
        } else System.out.println("No existen conexiones.");
    }

    // Devuelve el número de vecinos de una ciudad
    public int contarVecinos(String nombre) {
        int numVecinos = 0;
        Vertice v = buscarVertice(nombre);

        if (v == null) {
            System.out.println("Ciudad no encontrada");
            return -1;
        }


        for (Arista a : aristas) {
            if (a.getOrigen() == v) {
                if (a.getDestino() != null) {
                    numVecinos++;
                }
            } else if (a.getDestino() == v) {
                if (a.getOrigen() != null) {
                    numVecinos++;
                }
            }
        }

        return numVecinos;
    }

    // Elimina una ciudad y todas sus conexiones
    public void eliminarVertice(String nombre) {
        Vertice v = buscarVertice(nombre);
        if (v != null) {
            vertices.remove(v);
            for (Arista a : aristas) {
                if (a.getOrigen() == v) {
                    eliminarArista(a.getOrigen().toString(), a.getDestino().toString());
                } else if (a.getDestino() == v) {
                    eliminarArista(a.getOrigen().toString(), a.getDestino().toString());
                }
            }
        } else System.out.println("Ciudad no encontrada");
    }


    // Buscar un vértice por su nombre
    public Vertice buscarVertice(String nombre) {

        for (Vertice v : vertices) {
            if (v.getNombre().equals(nombre)) {
                return v;
            }
        }

        return null;
    }

    //Devuelve una lista con las ciudades directamente conectadas con el vértice recibido
    public ArrayList<Vertice> obtenerVecinos(Vertice v) {
        ArrayList<Vertice> vecinos = new ArrayList<>();
        Vertice ciudad = buscarVertice(v.getNombre());

        for (Arista a : aristas) {
            if (a.getOrigen() == ciudad && a.getDestino() != null) {
                vecinos.add(a.getDestino());
            } else if (a.getDestino() == ciudad && a.getOrigen() != null) {
                vecinos.add(a.getOrigen());
            }
        }

        return vecinos;
    }

    //Comprueba si existe una ruta utilizando DFS
    public boolean existeRutaDFS(String origen, String destino) {

        Vertice inicio = buscarVertice(origen);
        Vertice fin = buscarVertice(destino);

        if (inicio == null || fin == null) {
            System.out.println("Una de las ciudades introducidas no existe");
            return false;
        }

        Deque<Vertice> pila = new ArrayDeque<>();
        Set<Vertice> visitados = new HashSet<>();

        pila.push(inicio);

        while (!pila.isEmpty()) {

            Vertice actual = pila.pop();
            System.out.println("Visitando: " + actual);

            if (actual == fin) {
                System.out.println("Destino encontrado");
                return true;
            }

            if (!visitados.contains(actual)) {
                visitados.add(actual);

                for (Vertice vecino : obtenerVecinos(actual)) {
                    if (!visitados.contains(vecino)) {
                        pila.push(vecino);
                    }
                }
            }
        }
        System.out.println("Destino no encontrado");
        return false;
    }


    //Busca una ruta entre dos ciudades utilizando DFS
    public ArrayList<Vertice> buscarRutaDFS(String origen, String destino) {

        ArrayList<Vertice> ruta = new ArrayList<>();

        Vertice inicio = buscarVertice(origen);
        Vertice fin = buscarVertice(destino);

        if (inicio == null || fin == null) {
            return ruta;
        }

        Deque<Vertice> pila = new ArrayDeque<>();
        Set<Vertice> visitados = new HashSet<>();
        Map<Vertice, Vertice> anteriores = new HashMap<>();

        pila.push(inicio);
        visitados.add(inicio);

        while (!pila.isEmpty()) {

            Vertice actual = pila.pop();

            if (actual == fin) {

                Vertice v = fin;

                while (v != null) {
                    ruta.add(0, v);
                    v = anteriores.get(v);
                }

                return ruta;
            }

            for (Vertice vecino : obtenerVecinos(actual)) {

                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    anteriores.put(vecino, actual);
                    pila.push(vecino);
                }
            }
        }

        return ruta;
    }


    // Añadir un nuevo vértice
    public void agregarVertice(String nombre) {

        if (buscarVertice(nombre) == null) {
            vertices.add(new Vertice(nombre));
        }
    }

    // Añadir una arista entre dos vértices
    public void agregarArista(String origen, String destino) {

        Vertice v1 = buscarVertice(origen);
        Vertice v2 = buscarVertice(destino);

        if (v1 == null || v2 == null || v1 == v2) {
            System.out.println("No se puede crear la conexión");
            return;
        }

        if (!estanConectados(origen, destino)) {
            aristas.add(new Arista(v1, v2));
        }
    }

    // Comprobar conexión directa
    public boolean estanConectados(String origen, String destino) {

        Vertice v1 = buscarVertice(origen);
        Vertice v2 = buscarVertice(destino);

        if (v1 == null || v2 == null) {
            return false;
        }

        for (Arista a : aristas) {

            if ((a.getOrigen() == v1 && a.getDestino() == v2)
                    || (a.getOrigen() == v2 && a.getDestino() == v1)) {
                return true;
            }
        }

        return false;
    }

    // Mostrar los vértices
    public void mostrarVertices() {

        for (Vertice v : vertices) {
            System.out.println(v);
        }
    }

    // Mostrar todas las aristas
    public void mostrarAristas() {

        for (Arista a : aristas) {
            System.out.println(a);
        }
    }

    // Mostrar los vecinos de un vértice
    public void mostrarVecinos(String nombre) {

        Vertice v = buscarVertice(nombre);

        if (v == null) {
            System.out.println("El vértice no existe");
            return;
        }

        System.out.println("Vecinos de " + nombre + ":");

        for (Arista a : aristas) {

            if (a.getOrigen() == v) {
                System.out.println(a.getDestino());
            } else if (a.getDestino() == v) {
                System.out.println(a.getOrigen());
            }
        }
    }
}
