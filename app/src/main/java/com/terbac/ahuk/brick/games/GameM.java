
package com.terbac.ahuk.brick.games;

import com.terbac.ahuk.brick.classes.Game;

import static com.terbac.ahuk.brick.SharedData.*;

/*
 * Matching game: Match the 3 blocks on the ground with the falling ones to gain points
 */

public class GameM extends Game {

    private int mPositionBlocks, mPositionPlayer;
    private int[] mPlayer = new int[3];
    private int[] mEnemy = new int[3];

    protected void onStart() {
        super.mScoreLimit=15;
        super.mTimerLimit=50;

        for (int i = 0; i < 3; i++)
            mPlayer[i] = 0;

        for (int i = 0; i < 3; i++)
            mEnemy[i] = rand.nextInt(4);

        mPositionBlocks = 2;
        mPositionPlayer = 20 - sLevel;
    }

    protected void drawField() {
        for (int i = 0; i < 3; i++) {
            if (mPlayer[i] >= 0)
                field[1 + i * 3][mPositionPlayer] = 1;
            if (mPlayer[i] >= 1)
                field[2 + i * 3][mPositionPlayer] = 1;
            if (mPlayer[i] >= 2)
                field[1 + i * 3][mPositionPlayer - 1] = 1;
            if (mPlayer[i] >= 3)
                field[2 + i * 3][mPositionPlayer - 1] = 1;

            if (mEnemy[i] >= 0)
                field[1 + i * 3][mPositionBlocks] = 1;
            if (mEnemy[i] >= 1)
                field[2 + i * 3][mPositionBlocks] = 1;
            if (mEnemy[i] >= 2)
                field[1 + i * 3][mPositionBlocks - 1] = 1;
            if (mEnemy[i] >= 3)
                field[2 + i * 3][mPositionBlocks - 1] = 1;
        }
    }

    protected void calculation() {
        if (mPositionBlocks == mPositionPlayer)
            Test();

        mPositionBlocks++;
    }

    public void input() {
        switch (input) {
            case 1:
                mPlayer[1] = (mPlayer[1] + 1) % 4;
                break;
            case 2:
                mPlayer[1] = (mPlayer[1] + 1) % 4;
                break;
            case 3:
                mPlayer[0] = (mPlayer[0] + 1) % 4;
                break;
            case 4:
                mPlayer[2] = (mPlayer[2] + 1) % 4;
                break;
            case 5:
                calculation();
                break;
        }

        if (input != 5)
            playSound(4);
    }

    private void Test() {
        if (mPlayer[0] == mEnemy[0] && mPlayer[1] == mEnemy[1] && mPlayer[2] == mEnemy[2]) {
            playSound(6);
            nextScore();
            sEvent = 1;
        } else {
            playSound(2);
            decrementLives();
        }
    }
}
