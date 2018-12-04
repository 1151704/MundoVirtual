/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author OMAR MONTES
 */
public class Numeros {

    public static long getLongRandom(int MIN, int MAX) {
        return (long) (Math.random() * (MIN - MAX + 1) + MAX);
    }

    public static int getIntegerRandom(int MIN, int MAX) {
        return (int) (Math.random() * (MIN - MAX + 1) + MAX);
    }

}
