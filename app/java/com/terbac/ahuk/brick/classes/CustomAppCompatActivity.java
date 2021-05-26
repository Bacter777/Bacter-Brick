package com.terbac.ahuk.brick.classes;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import com.terbac.ahuk.brick.helper.LocaleChanger;
import static com.terbac.ahuk.brick.SharedData.*;

/**
 * Custom AppCompatActivity to implement language changing in attachBaseContext()
 * and some settings in onResume().  It also sets the Preferences, in case the app
 * was paused for a longer time and the references got lost.
 */

@SuppressWarnings("ALL")
public class CustomAppCompatActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //reinitializeData(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleChanger.onAttach(base));
    }

    /**
     * Apply the preferences from orientation and status bar to the current activity. It will be
     * called in the onResume, so after changing the preferences I don't need a listener to update
     * the changes on the previous activities.
     */
    @Override
    public void onResume() {
        super.onResume();
        setOrientation(this);
        showOrHideStatusBar(this);
    }

    /*
     * Sets the screen orientation according to the settings. It is called from onResume().
     * @param activity The activity to apply the orientation on.
    */
    public static void setOrientation(Activity activity) {
        switch (savedData.getString("pref_key_orientation", "1")) {
            case "1": //follow system settings
                activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER);
                break;
            case "2": //portrait
                activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                break;
            case "3": //landscape
                activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                break;
            case "4": //landscape upside down
                activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
                break;
        }
    }

    /**
     * Hides the status bar according to the settings. It is called from onResume().
     * @param activity The activity to apply the changes on.
     */
    public void showOrHideStatusBar(Activity activity) {
        if (savedData.getBoolean("prefKeyHideStatusBar", true)) {
            activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        else {
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }
}
