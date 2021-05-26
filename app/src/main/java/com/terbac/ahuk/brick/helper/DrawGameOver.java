package com.terbac.ahuk.brick.helper;

import com.terbac.ahuk.brick.classes.Game;
import static com.terbac.ahuk.brick.classes.Game.*;

/**
 * just draws the "game over animation" and contains all related variables
 */

public class DrawGameOver {

    private int x;
    private int y;
    private int mDirection;
    private int mBorderX;
    private int mBorderY;

    public void reset() {
        x=0;
        y=0;
        mDirection=1;
        mBorderX = FIELD_WIDTH - 1;
        mBorderY = FIELD_HEIGHT -1;
    }

    public void draw(){

        if (x==0 && y==0)
            playSound(7);

        field[x][y] = 1;

        switch (mDirection) {
            case 1:
                x++;

                if (x == mBorderX) {
                    mDirection = 2;
                    mBorderX--;
                }
                break;
            case 2:
                y++;

                if (y == mBorderY) {
                    mDirection = 3;
                    mBorderY--;
                }
                break;
            case 3:
                x--;

                if (x <= FIELD_WIDTH - mBorderX - 2)
                    mDirection = 4;
                break;
            case 4:
                y--;

                if (y <= FIELD_HEIGHT - mBorderY - 1)
                    mDirection = 1;

                if (x == 4 && y == 5)
                    Game.reset();
                break;
        }
    }
}
