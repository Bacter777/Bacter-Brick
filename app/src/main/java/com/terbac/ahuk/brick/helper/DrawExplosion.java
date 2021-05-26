package com.terbac.ahuk.brick.helper;


import android.graphics.Point;
import static com.terbac.ahuk.brick.SharedData.*;
import static com.terbac.ahuk.brick.classes.Game.*;

/**
 * just draws the explosion and contains all related variables
 */

public class DrawExplosion {

    private final static int EXPLOSION_SPEED = 10;
    private final static int EXPLOSION_MAX_COUNTER = 100;

    private Point mExplosionLocation;
    private int mExplosionCounter;

    public void draw() {
        int[][] matrix;

        if (mExplosionCounter==0) {
            playSound(3);
        } else if (mExplosionCounter==EXPLOSION_MAX_COUNTER) {
            mExplosionCounter = 0;
            getCurrentGame().decrementLives();
        } else {
            if (timerCounter2 % EXPLOSION_SPEED*2 < EXPLOSION_SPEED) {
                matrix = new int[][]{
                        {1, 0, 0, 1},
                        {0, 1, 1, 0},
                        {0, 1, 1, 0},
                        {1, 0, 0, 1}};
            } else {
                matrix = new int[][]{
                        {0, 1, 1, 0},
                        {1, 0, 0, 1},
                        {1, 0, 0, 1},
                        {0, 1, 1, 0}};
            }

            for (int i = 0; i < 4; i++)
                System.arraycopy(matrix[i], 0, field[mExplosionLocation.x - 1 + i], mExplosionLocation.y - 1, 4);
        }

        mExplosionCounter ++ ;
    }

    public void setLocation(int x, int y) {

        if (x < 1) x = 1;
        if (x > 7) x = 7;
        if (y < 1) y = 1;
        if (y > 17) y = 17;

        mExplosionLocation = new Point(x,y);
    }

    public void reset() {
        mExplosionCounter=0;
    }
}
