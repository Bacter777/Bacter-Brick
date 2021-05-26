package com.terbac.ahuk.brick.helper;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import com.terbac.ahuk.brick.R;
import com.terbac.ahuk.brick.ui.about.ChangeLogFragment;
import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;

public class BacterHelper
{
    private Activity activity;
    private BacterHelper(@NonNull Activity activity)
    {
        this.activity = activity;
    }
    @NonNull
    public static BacterHelper with(@NonNull Activity activity)
    {
        return new BacterHelper(activity);
    }
    public void loadAbout()
    {
        final FrameLayout frameAbout = activity.findViewById(R.id.frameAbout);
        AboutBuilder builder = AboutBuilder.with(activity)
                .setAppIcon(R.drawable.cert_dev)
                .setAppName(R.string.app_name)
                .setPhoto(R.drawable.dev)
                .setCover(R.drawable.cover)
                .setBrief("If you want to use my work for your own project (which means in most cases: Put ads in it and publish on Google Play Store)\nYOU HAVE TO FOLLOW THE GPL LICENSE!\nThis means, your project MUST be open source under a GPLv3+ compatible license and MUST contain attribution for the original work! \nI already found a lot of copies which simply removed my About Game screen and changed some graphics. \nIf I see your work violating the GPL rules, \nI will let it get removed by Google. ")
                .setLinksAnimated(true)
                .setDividerDashGap(13)
                .setLinksColumnsCount(3)
                .setDividerColor(R.color.colorAccent)
                .setName("Bacter777")
                .setSubTitle("Mobile App Developer")
                .addGitHubLink("Bacter777")
                .addFacebookLink("BdFreak777")
                .addEmailLink("bdfreak777@gmail.com")
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .setActionsColumnsCount(2)
                .setWrapScrollView(true)
                .setShowAsCard(true);
        AboutView view = builder.build();
        frameAbout.addView(view);
    }
}
