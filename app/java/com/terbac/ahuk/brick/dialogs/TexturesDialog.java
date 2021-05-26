package com.terbac.ahuk.brick.dialogs;

import android.content.Context;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;

import com.terbac.ahuk.brick.R;
import static com.terbac.ahuk.brick.SharedData.*;

/*
 * custom dialog to pick a texture, because i wanted to show them in the dialog
 */

@SuppressWarnings("ALL")
public class TexturesDialog extends DialogPreference implements View.OnClickListener{

    public TexturesDialog(Context context, AttributeSet attrs) {
        super(context, attrs);
        setDialogLayoutResource(R.layout.dialog_textures);
        setDialogIcon(null);
    }

    @Override
    protected void onBindDialogView(View view) {
        view.findViewById(R.id.button1).setOnClickListener(this);
        view.findViewById(R.id.button2).setOnClickListener(this);
        view.findViewById(R.id.button3).setOnClickListener(this);

        super.onBindDialogView(view);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                look=1;
                break;
            case R.id.button2:
                look=2;
                break;
            case R.id.button3:
                look=3;
                break;
        }

        saveData("prefKeyTextures", look);
        getDialog().dismiss();
    }
}
