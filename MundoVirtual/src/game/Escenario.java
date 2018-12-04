/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.plaf.TabbedPaneUI;
import util.Numeros;

/**
 *
 * @author OMAR MONTES
 */
public class Escenario extends JFrame {

    private JTabbedPane tabs;
    private Habitacion habitaciones[];
    public static final int ANCHO = 800;
    public static final int ALTO = 500;

    public Escenario() {

        super.setTitle("Mundo Virtual");
        super.setSize(ANCHO, ALTO);
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        habitaciones = new Habitacion[5];

        this.iniciar();
    }

    private void iniciar() {

        tabs = new JTabbedPane();

        for (int i = 0; i < habitaciones.length; i++) {
            habitaciones[i] = new Habitacion(Numeros.getIntegerRandom(5, 10), Numeros.getIntegerRandom(10, 15));

            tabs.addTab("Habitación " + (i + 1), habitaciones[i]);

            habitaciones[i].iniciar();
        }

        super.add(tabs);

        super.setVisible(true);

    }

}
