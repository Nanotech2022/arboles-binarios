package arboles;

import javax.swing.*;
import java.awt.*;

public class ArbolBinarioGrafico extends JFrame {

    private JPanel ventana;

    ArbolBinario arbol = new ArbolBinario();

    public ArbolBinarioGrafico() {
        super("Arbol binario grafico");
        arbol.insertarNodoCadena("10,4,11,13");
    }

    public int drawTree(Graphics g, Nodo x, int x0, int x1, int y){

        int m = (x0 + x1) / 2;
        g.setColor(Color.BLUE);
        g.fillOval(m, y, 50, 40);
        g.setColor(Color.lightGray);
        g.setFont(new Font("Arial",Font.BOLD,20));
        String t = String.valueOf(x.num);
        g.drawString(t, m+20, y+30);
        if (x.hijoIzquierdo != null) {
            int x2 = drawTree(g, x.hijoIzquierdo,x0,m,y+50);
            g.drawLine(m+25, y+40, x2+25, y+50);
        }
        if (x.hijoDerecho != null) {
            int x2 = drawTree(g, x.hijoDerecho,m,x1,y+50);
            g.drawLine(m+25, y+40, x2+25, y + 50);
        }
        return m;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawTree(g, arbol.getRaiz(), 0, this.getWidth()-25, 100);
    }
}
