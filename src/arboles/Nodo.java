package arboles;

public class Nodo {
    public int num;
    public Nodo hijoIzquierdo, hijoDerecho;

    public Nodo(int num) {
        this.num = num;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "num=" + num +
                ", hijoIzquierdo=" + hijoIzquierdo +
                ", hijoDerecho=" + hijoDerecho +
                '}';
    }
}
