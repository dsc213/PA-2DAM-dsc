public class ArbolBinarioBusqueda {

    private NodoArbol raiz;

    public ArbolBinarioBusqueda() {
        raiz = null;
    }

    public void insertar(int dato) {

        NodoArbol nuevo =
                new NodoArbol(dato);

        if (raiz == null) {
            raiz = nuevo;
            return;
        }

        NodoArbol actual = raiz;

        while (true) {

            if (dato < actual.dato) {

                if (actual.izquierdo == null) {
                    actual.izquierdo = nuevo;
                    return;
                }

                actual = actual.izquierdo;

            } else {

                if (actual.derecho == null) {
                    actual.derecho = nuevo;
                    return;
                }

                actual = actual.derecho;
            }
        }
    }


    // Método público busca en el árbol el elemento que se le pasa
    // Si encuentra el dato devuelve true, si no devuelve false
    // 
    public boolean buscar(int dato) {

        NodoArbol actual = raiz;

        while (true) {
            if (actual == null){
                System.out.println("No se ha encontrado el dato");
                return false;
            }
            else if(dato == actual.dato){
                System.out.println("Dato encontrado: " + actual.dato);
                return true;
            }
            else if (dato > actual.dato) {
                actual = actual.derecho;
            }
            else if(dato < actual.dato){
                actual = actual.izquierdo;
            }
        }

    }

    // Método público que utilizaremos desde main
    public void mostrar() {

        inOrden(raiz);
    }


    // Método recursivo
    public void inOrden(NodoArbol nodo) {

        if (nodo == null) {
            return;
        }

        inOrden(nodo.izquierdo);

        System.out.println(nodo.dato);

        inOrden(nodo.derecho);
    }


    public void preOrden(NodoArbol nodo) {
        if (nodo == null) {
            return;
        }

        System.out.println(nodo.dato);

        preOrden(nodo.izquierdo);

        preOrden(nodo.derecho);
    }

    public void postOrden(NodoArbol nodo) {
        if (nodo == null) {
            return;
        }

        postOrden(nodo.izquierdo);

        postOrden(nodo.derecho);

        System.out.println(nodo.dato);
    }

}
