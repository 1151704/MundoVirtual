/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.geom.RoundRectangle2D;
import util.Numeros;

/**
 *
 * @author OMAR MONTES
 */
public class Androide extends Thread {

    public static final int ANCHO = 25;
    public static final int ALTO = 50;

    private Habitacion habitacion;
    private Cosa elemento;

    private int x;
    private int y;
    private int dx = 1;
    private int dy = 1;
    private final int MIN = 5;
    private final int MAX = 10;

    private final long ESPERAR;

    public Androide(int x, int y, Habitacion habitacion) {
        this.x = x;
        this.y = y;
        this.habitacion = habitacion;

        ESPERAR = Numeros.getLongRandom(MIN, MAX);
    }

    public RoundRectangle2D getAndroide() {
        return new RoundRectangle2D.Double(x, y, ANCHO, ALTO, 15, 10);
    }

    @Override
    public void run() {
        while (true) {

            mover();

            try {
                Thread.sleep(ESPERAR);
            } catch (InterruptedException ie) {
            }

        }
    }

    private void mover() {

        x += dx;
        y += dy;

        if (x + ANCHO > habitacion.getBounds().getMaxX()) {
            dx = -dx;
        }
        if (y + ALTO > habitacion.getBounds().getMaxY() - 19 - 6) {
            dy = -dy;
        }
        if (x < 0) {
            dx = -dx;
        }
        if (y < 0) {
            dy = -dy;
        }
        if (elemento != null) {
            elemento.cambiarPosicion(x, y);
        }

        habitacion.repaint();
    }

    public boolean tieneElemento() {
        return elemento != null;
    }

    public void tomarElemento(Cosa elemento) {
        this.elemento = elemento;
        this.elemento.tomar(this);
        this.elemento.start();
    }

    public void soltarElemento() {
        this.elemento = null;
    }

}
