package com.terbac.ahuk.brick;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import java.util.Locale;
import com.terbac.ahuk.brick.helper.LocaleChanger;

/**
 * Application class to load custom locales
 */

public class MainApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        LocaleChanger.setDefaultLocale(Locale.getDefault());
        super.attachBaseContext(LocaleChanger.onAttach(base));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LocaleChanger.setLocale(this);
    }
}