/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;

/**
 *
 * @author Maria Fernanda
 */
public class Coordenada {
    int height;
    int width;
    int x;
    int y;

    public Coordenada(int xStart, int yStart, int xEnd, int yEnd) {
        this.height = xStart;
        this.width = yStart;
        this.x = xEnd;
        this.y = yEnd;
    }

    public int getxStart() {
        return height;
    }

    public int getyStart() {
        return width;
    }

    public int getxEnd() {
        return x;
    }

    public int getyEnd() {
        return y;
    }
}
