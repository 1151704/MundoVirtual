/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import util.Numeros;

/**
 *
 * @author OMAR MONTES
 */
public class Cosa extends Thread implements Cloneable {

    private int x;
    private int y;

    private final int ANCHO = Androide.ANCHO - 4;
    private final int ALTO = Androide.ANCHO - 4;

    private boolean enMovimiento;
    private Androide androide;

    private Color color;

    public Cosa(int x, int y) {
        this.x = x;
        this.y = y;
        color = Color.BLUE;
    }

    public Cosa(Cosa elemento) {

        this.color = elemento.color;
        this.x = elemento.x;
        this.y = elemento.y;

    }

    public Ellipse2D getElemento() {

        return new Ellipse2D.Double(x, y, ANCHO, ALTO);

    }

    public void tomar(Androide androide) {
        enMovimiento = true;
        this.androide = androide;
        color = Color.RED;
    }

    public void soltar() {
        if (androide != null) {
            androide.soltarElemento();
            androide = null;
        }
        color = Color.ORANGE;
    }

    public void cambiarPosicion(int x, int y) {
        this.x = x + (Androide.ANCHO / 2) - (ANCHO / 2);
        this.y = y + (Androide.ALTO / 2) - (ALTO / 2);
    }

    public Color getColor() {
        return color;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(Numeros.getIntegerRandom(1500, 2500));
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        soltar();

        try {
            Thread.sleep(Numeros.getIntegerRandom(250, 750));
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        color = Color.BLUE;
        enMovimiento = false;

    }

    @Override
    public Cosa clone() throws CloneNotSupportedException {
        return (Cosa) super.clone();
    }

    public boolean isEnMovimiento() {
        return enMovimiento;
    }

}
