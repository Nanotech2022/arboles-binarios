package arboles;

public class ArbolBinario {

    private Nodo raiz;
    private int cant;
    private int cantHojas;
    private int altura;
    private int nodoMenor;
    private int nodoMayor;

    public ArbolBinario () {
        raiz = null;
    }

    public void insertarNodo (int num) {
        Nodo nuevoNodo = new Nodo(num);
        if (raiz == null) raiz = nuevoNodo;
        else {
            Nodo aux = raiz;
            Nodo padre;

            while (true) {
                System.out.println("Insertando...");
                padre = aux;
                if (num < aux.num) {
                    aux = aux.hijoIzquierdo;

                    if (aux == null) {
                        padre.hijoIzquierdo = nuevoNodo;
                        return;
                    }
                } else {
                    aux = aux.hijoDerecho;

                    if (aux == null) {
                        padre.hijoDerecho = nuevoNodo;
                        return;
                    }
                }
            }
        }


    }

    public void insertarNodoCadena (String cadenaNodos) {
        String[] nodos = cadenaNodos.split(",");
        for (String nodo : nodos) {
            insertarNodo(Integer.valueOf(nodo));
        }
    }
    public boolean estaVacio() {
        return raiz == null;
    }

    // ordenamientos
    public static void inOrden(Nodo nodo) {
        if (nodo != null) {
            inOrden(nodo.hijoIzquierdo);
            System.out.println(nodo.num + ", ");
            inOrden(nodo.hijoDerecho);
        }
    }

    public static void preOrden(Nodo nodo) {
        if (nodo != null) {
            System.out.println(nodo.num + ", ");
            preOrden(nodo.hijoIzquierdo);
            preOrden(nodo.hijoDerecho);
        }
    }

    public static void postOrden(Nodo nodo) {
        if (nodo != null) {
            postOrden(nodo.hijoIzquierdo);
            postOrden(nodo.hijoDerecho);
            System.out.println(nodo.num + ", ");
        }
    }

    // Buscar nodo en el arbol
    public Nodo buscarNodo (int num) {
        Nodo aux = raiz;

        while (aux.num != num) {
            if (num < aux.num) aux = aux.hijoIzquierdo;
            else aux = aux.hijoDerecho;

            if (aux == null) return null;
        }

        return aux;
    }

    public boolean existeNodo (int num) {
        Nodo aux = raiz;
        while (aux != null) {
            if (num == aux.num) return true;
            else if (num < aux.num) aux = aux.hijoIzquierdo;
            else aux = aux.hijoDerecho;
        }
        return false;
    }

    public int cantNodos () {
        cant = 0;
        cantNodos(raiz);
        return cant;
    }

    private void cantNodos (Nodo nodo) {
        if (nodo != null) {
            cant++;
            cantNodos(nodo.hijoIzquierdo);
            cantNodos(nodo.hijoDerecho);
        }
    }

    public int cantNodosHojas () {
        cantHojas = 0;
        cantNodosHojas(raiz);
        return cantHojas;
    }

    private void cantNodosHojas(Nodo nodo) {
        if (nodo != null) {
            if (nodo.hijoIzquierdo == null && nodo.hijoDerecho == null) cantHojas++;
            cantNodosHojas(nodo.hijoIzquierdo);
            cantNodosHojas(nodo.hijoDerecho);
        }
    }

    public int retornarAltura () {
        altura = 0;
        retornarAltura(raiz, 1);
        return altura;
    }

    private void retornarAltura (Nodo nodo, int nivel) {
        if (nodo != null) {
            retornarAltura(nodo.hijoIzquierdo, (nivel +1 ));
            if (nivel > altura) altura = nivel;
            retornarAltura(nodo.hijoDerecho, (nivel + 1));
        }
    }

    public int getNodoMenor () {
        nodoMenor = 0;
        getNodoMenor(raiz);
        return nodoMenor;
    }

    private void getNodoMenor (Nodo nodo) {
        if (nodo != null) {
            Nodo aux = nodo;
            while (aux.hijoIzquierdo != null) {
                aux = aux.hijoIzquierdo;
            }
            nodoMenor = aux.num;
        }
    }

    public int getNodoMayor () {
        nodoMayor = 0;
        getNodoMayor(raiz);
        return nodoMayor;
    }

    private void getNodoMayor (Nodo nodo) {
        if (nodo != null) {
            Nodo aux = nodo;
            while (aux.hijoDerecho != null ) {
                aux = aux.hijoDerecho;
            }
            nodoMayor = aux.num;
        }
    }

    public boolean eliminarNodo (int num) {
        Nodo aux = raiz;
        Nodo padre = raiz;
        boolean hijoIzq = true;
        while (aux.num != num) {
            padre = aux;
            if (num < aux.num) {
                hijoIzq = true;
                aux = aux.hijoIzquierdo;
            } else {
                hijoIzq = false;
                aux = aux.hijoDerecho;
            }
            if (aux == null) {
                return false;
            }
        }
        // El nodo es una hoja
        if (aux.hijoIzquierdo == null && aux.hijoDerecho == null) {
            if (aux == raiz) {
                raiz = null;
            } else if (hijoIzq) {
                padre.hijoIzquierdo = null;
            } else {
                padre.hijoDerecho = null;
            }
        } else if (aux.hijoDerecho == null) {
            if (aux == raiz) {
                raiz = aux.hijoIzquierdo;
            } else if (hijoIzq) {
                padre.hijoIzquierdo = aux.hijoIzquierdo;
            } else {
                padre.hijoDerecho = aux.hijoIzquierdo;
            }
        } else if (aux.hijoIzquierdo == null) {
            if (aux == raiz) {
                raiz = aux.hijoDerecho;
            } else if (hijoIzq) {
                padre.hijoIzquierdo = aux.hijoDerecho;
            } else {
                padre.hijoDerecho = aux.hijoDerecho;
            }
        } else {
            Nodo reemplazo = obtenerReemplazo(aux);
            if (aux == raiz) {
                raiz = reemplazo;
            } else if (hijoIzq) {
                padre.hijoIzquierdo = reemplazo;
            } else {
                padre.hijoDerecho = reemplazo;
            }
            reemplazo.hijoIzquierdo = aux.hijoIzquierdo;
        }
        return true;
    }

    public Nodo obtenerReemplazo(Nodo nodoReemplazo) {
        Nodo reemplazoPadre = nodoReemplazo;
        Nodo reemplazo = nodoReemplazo;
        Nodo aux = nodoReemplazo.hijoDerecho;
        while (aux != null) {
            reemplazoPadre = reemplazo;
            reemplazo = aux;
            aux = aux.hijoIzquierdo;
        }
        if (reemplazo != nodoReemplazo.hijoDerecho) {
            reemplazoPadre.hijoIzquierdo = reemplazo.hijoDerecho;
            reemplazo.hijoDerecho = nodoReemplazo.hijoDerecho;
        }
        System.out.println("El Nodo Reemplazo es:" + reemplazo);
        return reemplazo;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    @Override
    public String toString() {
        return "ArbolBinario{" +
                "raiz=" + raiz +
                ", cant=" + cant +
                ", cantHojas=" + cantHojas +
                ", altura=" + altura +
                ", nodoMenor=" + nodoMenor +
                ", nodoMayor=" + nodoMayor +
                '}';
    }
}
