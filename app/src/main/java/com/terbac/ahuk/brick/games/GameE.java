
package com.terbac.ahuk.brick.games;

import android.graphics.Point;

import com.terbac.ahuk.brick.classes.Game;

import static com.terbac.ahuk.brick.SharedData.*;

/*
 *  Racing game, just avoid crashing with other cars
 */

public class GameE extends Game {
    private int mBorder;
    private Point mPlayer;
    private Point[] mEnemy = new Point[3];
    private int[][] mCar;

    protected void onStart() {
        super.mScoreLimit=100;
        super.mTimerLimit=20;
        super.mLevelsEnabled=true;

        sObjects.clear();

        mCar= new int[][]{
                {0,1,0,1},
                {1,1,1,0},
                {0,1,0,1}};

        mBorder = 0;
        mPlayer = new Point(2,16-sLevel);

        for (int i = 0; i < 3; i++) {
            mEnemy[i] = new Point();

            if (rand.nextBoolean())
                mEnemy[i].x = 2;
            else
                mEnemy[i].x = 5;

            mEnemy[i].y = -5 - 9 * i;
        }
    }

    @Override
    protected void level() {
        sObjects.clear();
    }

    protected void drawField() {
        for (int j = 0; j < 4; j++)
            for (int i = 0; i < 3; i++)
                if (mCar[i][j] == 1)
                    field[mPlayer.x + i][mPlayer.y + j] = 1;

        for (int k = 0; k < 3; k++)
            for (int j = 0; j < 4; j++)
                for (int i = 0; i < 3; i++)
                    if (mCar[i][j] == 1 && mEnemy[k].y + j >= 0 && mEnemy[k].y + j < 20)
                        field[mEnemy[k].x + i][mEnemy[k].y + j] = 1;
    }

    protected void calculation() {
        sObjects.clear();

        mBorder = (++mBorder) % 4;

        for (int i = 19; i >= 0; i--) {
            if (mBorder != 3) {
                obj(0, i);
                obj(9, i);
            }
            mBorder = ++mBorder % 4;
        }

        for (int i = 0; i < 3; i++) {
            mEnemy[i].y++;

            if (mEnemy[i].y == 20) {
                if (rand.nextBoolean())
                    mEnemy[i].x = 2;
                else
                    mEnemy[i].x = 5;

                mEnemy[i].y = -7;
            }
        }

        test();
    }

    private void test() {
        for (int i = 0; i < 3; i++) {
            if (mPlayer.y == mEnemy[i].y)
                nextScore();

            if (mPlayer.x == mEnemy[i].x && ((mPlayer.y >= mEnemy[i].y && mPlayer.y <= mEnemy[i].y + 3) || (mPlayer.y + 3 >= mEnemy[i].y && mPlayer.y <= mEnemy[i].y + 3)))
                explosion(mPlayer.x + 1, mPlayer.y + 2);
        }
    }

    public void input() {
        if (input == 3 && mPlayer.x == 5) {
            playSound(4);
            mPlayer.x = 2;
        } else if (input == 4 && mPlayer.x == 2) {
            playSound(4);
            mPlayer.x = 5;
        } else if (input == 5)
            calculation();

    }
}
