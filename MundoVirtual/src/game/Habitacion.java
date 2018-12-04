/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import javax.swing.JPanel;
import util.Numeros;

/**
 *
 * @author OMAR MONTES
 */
public final class Habitacion extends JPanel {

    private Androide androides[];
    private Cosa elementos[];

    public Habitacion(int _androides, int _elementos) {

        super.setBackground(Color.WHITE);

        androides = new Androide[_androides];

        elementos = new Cosa[_elementos];

    }

    public void iniciar() {

        int maxX = (int) (Escenario.ANCHO - 10 - Androide.ANCHO);
        int maxY = (int) (Escenario.ALTO - 32 - 19 - 6 - Androide.ALTO);

        for (int i = 0; i < androides.length; i++) {
            androides[i] = new Androide(Numeros.getIntegerRandom(0, maxX), Numeros.getIntegerRandom(0, maxY), this);
        }

        for (int i = 0; i < elementos.length; i++) {
            elementos[i] = new Cosa(Numeros.getIntegerRandom(0, maxX), Numeros.getIntegerRandom(0, maxY));
        }
        for (Androide androide : androides) {
            androide.start();
        }

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        dibujar(g2d);

    }

    public void dibujar(Graphics2D g2d) {

        g2d.setColor(new Color(51, 153, 255));
        for (Androide androide : androides) {
            g2d.fill(androide.getAndroide());
        }

        for (int i = 0; i < elementos.length; i++) {
            g2d.setColor(elementos[i].getColor());
            g2d.fill(elementos[i].getElemento());
            Androide androide = colision(elementos[i].getElemento());
            if (androide != null && !elementos[i].isEnMovimiento() && !androide.tieneElemento()) {

                elementos[i] = new Cosa(elementos[i]);

                androide.tomarElemento(elementos[i]);
            }
        }
    }

    public Androide colision(Shape elemento) {

        for (Androide androide : androides) {
            if (elemento.intersects(androide.getAndroide().getBounds2D())) {
                return androide;
            }
        }

        return null;
    }

}
