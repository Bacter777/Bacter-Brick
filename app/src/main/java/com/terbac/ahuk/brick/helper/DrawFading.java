package com.terbac.ahuk.brick.helper;

import com.terbac.ahuk.brick.classes.Game;
import static com.terbac.ahuk.brick.SharedData.*;
import static com.terbac.ahuk.brick.classes.Game.*;

/*
 * Draws fading between games and levels
 */

public class DrawFading {

    private boolean mPhase;
    private int mCounter;

    public void draw() {

        if (mPhase) {
            if (nextLevel)
                getCurrentGame().nextLevel();

            for (int i=0;i < FIELD_WIDTH;i++)
                field[i][mCounter] = 1;

            if (--mCounter < 0) {
                mCounter=0;
                mPhase=false;
            }

        } else {
            for (int i=0;i < FIELD_WIDTH;i++)
                field[i][mCounter] = 0;

            if (++mCounter >= FIELD_HEIGHT) {
                Game.initialisation();
                reset();
            }
        }
    }

    public void reset() {
        mCounter=FIELD_HEIGHT-1;
        mPhase=true;
    }
}
