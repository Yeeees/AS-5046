package luyangye.paindiary;

/**
 * Created by YLY on 22/04/2016.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by YLY on 16/04/2016.
 */
public class MainFragment extends Fragment {
    View vMain;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        vMain = inflater.inflate(R.layout.app_main, container, false);
        return vMain;
    }
}
