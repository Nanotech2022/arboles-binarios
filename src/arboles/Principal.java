package arboles;

public class Principal {

    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.insertarNodoCadena("10,4,11,13");
        System.out.println("Arbol " + arbol);
        System.out.println("Cantidad nodos " + arbol.cantNodos());
        System.out.println("Cantidad nodos hoja " + arbol.cantNodosHojas());
        System.out.println("Altura " + arbol.retornarAltura());
//
//        System.out.println("Arbol " + arbol);
        //arbol.eliminarNodo(10);
        System.out.println("Arbol " + arbol);
        System.out.println("Nodo a buscar " + arbol.buscarNodo(13));
//
        System.out.println("Ordenamiento preOrden");
        ArbolBinario.preOrden(arbol.getRaiz());
        System.out.println("Ordenamiento postOrden");
        ArbolBinario.postOrden(arbol.getRaiz());
        System.out.println("Ordenamiento inOrden");
        ArbolBinario.inOrden(arbol.getRaiz());

    }
}
