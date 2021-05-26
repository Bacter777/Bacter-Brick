package com.terbac.ahuk.brick.dialogs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import com.terbac.ahuk.brick.R;
import static com.terbac.ahuk.brick.SharedData.*;

/*
 * custom dialog to pick a background color, because i wanted to show buttons with
 * the color in it
 */

@SuppressWarnings("ALL")
public class BackgroundDialog extends DialogPreference implements View.OnClickListener{

    public BackgroundDialog(Context context, AttributeSet attrs) {
        super(context, attrs);
        setDialogLayoutResource(R.layout.dialog_background);
        setDialogIcon(null);
    }

    @Override
    protected void onBindDialogView(View view) {
        view.findViewById(R.id.button1).setOnClickListener(this);
        view.findViewById(R.id.button2).setOnClickListener(this);
        view.findViewById(R.id.button3).setOnClickListener(this);
        view.findViewById(R.id.button4).setOnClickListener(this);
        view.findViewById(R.id.button5).setOnClickListener(this);

        super.onBindDialogView(view);
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        int choice=1;

        switch (v.getId()) {
            case R.id.button1:
                choice=1;
                break;
            case R.id.button2:
                choice=2;
                break;
            case R.id.button3:
                choice=3;
                break;
            case R.id.button4:
                choice=4;
                break;
            case R.id.button5:
                choice=5;
                break;
        }

        saveData("prefKeyBackground", choice);
        getDialog().dismiss();
    }
}
