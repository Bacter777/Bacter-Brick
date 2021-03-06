package com.terbac.ahuk.brick.surfaceViews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import static com.terbac.ahuk.brick.SharedData.*;
import static com.terbac.ahuk.brick.classes.Game.*;

/*
 * Surface View for the little box right to the main game screen
 */
public class GameView2 extends SurfaceView {

    SurfaceHolder ourHolder;
    Paint paint;
    Canvas canvas;

    int p1, p2, p3, p4;
    Paint pBlack;
    Paint pBackground;
    Paint pForeground;

    public GameView2(Context context) {
        super(context);
        ourHolder = getHolder();
        paint = new Paint();
        pBlack = new Paint();
        pBackground = new Paint();
        pForeground = new Paint();
        pBackground.setColor(Color.WHITE);
        pBlack.setTextSize((float) (width * 1.2));
    }

    public void draw() {
        if (ourHolder.getSurface().isValid()) {
            canvas = ourHolder.lockCanvas();

            //canvas.drawRect(distanceWidth - 3, distanceHeight - 3, distanceWidth + FIELD_WIDTH_2 * width + 3, distanceHeight + FIELD_HEIGHT_2 * width + 3, pBlack);
            canvas.drawRect(distanceWidth - 1, distanceHeight - 1, distanceWidth + FIELD_WIDTH_2 * width + 1, distanceHeight + FIELD_HEIGHT_2 * width + 1, pBackground);

            for (int i=0;i < FIELD_WIDTH_2;i++) {
                for (int j = 0; j < FIELD_HEIGHT_2; j++) {
                    p1 = distanceWidth + i * width;
                    p2 = distanceHeight + j * width;
                    p3 = distanceWidth + i * width + width;
                    p4 = distanceHeight + j * width + width;


                    pForeground.setColor(field2[i][j] == 0 ? Color.LTGRAY : Color.BLACK);

                    switch (look) {
                        case 1:
                            canvas.drawRect(p1 + 1, p2 + 1, p3 - 1, p4 - 1, pForeground);
                            canvas.drawRect(p1 + width / 4, p2 + width / 4, p3 - width / 4, p4 - width / 4, pBackground);
                            canvas.drawRect(p1 + width / 4 + 1, p2 + width / 4 + 1, p3 - (width / 4 + 1), p4 - (width / 4 + 1), pForeground);
                            break;
                        case 2:
                            canvas.drawRect(p1 + 1, p2 + 1, p3 - 1, p4 - 1, pForeground);
                            break;
                        case 3:
                            canvas.drawRect(p1 + 1, p2 + 1, p3 - 1, p4 - 1, pForeground);
                            canvas.drawRect(p1 + width / 4, p2 + width / 4, p3 - width / 4, p4 - width / 4, pBackground);
                            canvas.drawRect(p1 + width / 4 + 1, p2 + width / 4 + 1, p3 - width / 4, p4 - width / 4, pForeground);
                            break;
                    }
                }
            }

            ourHolder.unlockCanvasAndPost(canvas);
        }
    }
}