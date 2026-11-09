
public class GrafoMatriz {

    private String[] ciudades;
    private int[][] conexiones;
    private int numCiudades;

    public GrafoMatriz(int maxCiudades) {
        ciudades = new String[maxCiudades];
        conexiones = new int[maxCiudades][maxCiudades];
        numCiudades = 0;
    }

    // Buscar la posición de una ciudad
    public int buscarCiudad(String ciudad) {
        for (int i = 0; i < numCiudades; i++) {
            if (ciudades[i].equals(ciudad)) {
                return i;
            }
        }
        return -1;
    }

    // Añadir una ciudad
    public void agregarCiudad(String ciudad) {
        if (numCiudades < ciudades.length
                && buscarCiudad(ciudad) == -1) {

            ciudades[numCiudades] = ciudad;
            numCiudades++;
        }
    }

    // Conectar dos ciudades
    public void agregarConexion(String origen, String destino) {

        int i = buscarCiudad(origen);
        int j = buscarCiudad(destino);

        if (i != -1 && j != -1 && i != j) {
            conexiones[i][j] = 1;
            conexiones[j][i] = 1;
        }
    }

    // Comprobar conexión directa
    public boolean estanConectadas(String origen, String destino) {

        int i = buscarCiudad(origen);
        int j = buscarCiudad(destino);

        if (i == -1 || j == -1) {
            return false;
        }

        return conexiones[i][j] == 1;
    }

    // Mostrar las ciudades conectadas a una ciudad
    public void mostrarVecinos(String ciudad) {

        int i = buscarCiudad(ciudad);

        if (i == -1) {
            System.out.println("La ciudad no existe");
            return;
        }

        System.out.println("Conexiones de " + ciudad + ":");

        for (int j = 0; j < numCiudades; j++) {
            if (conexiones[i][j] == 1) {
                System.out.println(ciudades[j]);
            }
        }
    }

    // Mostrar la matriz de adyacencia
    public void mostrarMatriz() {

        for (int i = 0; i < numCiudades; i++) {
            for (int j = 0; j < numCiudades; j++) {
                System.out.print(conexiones[i][j] + " ");
            }
            System.out.println();
        }
    }
}
