
package com.terbac.ahuk.brick.ui.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import com.terbac.ahuk.brick.R;

/*
 * Shows the GPL License, which is simply loaded from a webView. The About activity disables recreation
 * after orientation change, so don't need to handle that.
 */

public class LicenseFragment extends Fragment implements View.OnClickListener
{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_about_tab2, container, false);

        WebView webView = (WebView) view.findViewById(R.id.about_tab2_webview);
        webView.loadUrl("file:///android_asset/license.html");

        return view;
    }

    @Override
    public void onClick(View v) {
        //nothing
    }
}