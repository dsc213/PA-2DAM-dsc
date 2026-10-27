public class EjemploArbolBusquedaBinaria {


        public static void main(String[] args) {

            ArbolBinarioBusqueda arbol =
                    new ArbolBinarioBusqueda();

            arbol.insertar(50);
            arbol.insertar(30);
            arbol.insertar(70);
            arbol.insertar(20);
            arbol.insertar(40);
            arbol.insertar(60);
            arbol.insertar(80);

            System.out.println("Contenido del árbol:");

            arbol.mostrar();
            arbol.buscar(40);
            arbol.buscar(90);
            arbol.buscar(50);


        }
    }

