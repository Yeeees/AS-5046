package luyangye.paindiary;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.Bundle;
import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by YLY on 22/04/2016.
 */
public class MapFragment extends Fragment {
    View WebView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        WebView = inflater.inflate(R.layout.fragment_map, container, false);


        WebView wv1 = (WebView)WebView.findViewById(R.id.webMap);

        wv1.setWebChromeClient(
                new WebChromeClient() { public void onGeolocationPermissionsShowPrompt(String origin,
                                                                                       GeolocationPermissions.Callback callback) {
                    callback.invoke(origin, true, false); }
                }
        );
// Set a few browser attributes.
        wv1.getSettings().setLoadsImagesAutomatically(true);
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.getSettings().setAppCacheEnabled(true);
        wv1.getSettings().setDatabaseEnabled(true);
        wv1.getSettings().setDomStorageEnabled(true);
        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        // Get the Android assets folder path
        String folderPath = "file:android_asset/";
         // Get the HTML file name
         String fileName = "sample.html";
         // Get the exact file location
         String file = folderPath + fileName;
        wv1.loadUrl(file);
        //wv1.loadUrl("http://www.mapquest.com");

        return WebView;
    }
}