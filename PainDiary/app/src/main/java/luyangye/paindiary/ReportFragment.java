package luyangye.paindiary;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

//import android.support.v4.app.Fragment;

import luyangye.paindiary.API.OpenWeather;

/**
 * Created by YLY on 22/04/2016.
 */
public class ReportFragment extends Fragment {
    protected TextView tvHumidity;
    protected TextView tvSpeed;
    protected TextView tvPressure;
    protected TextView tvTemp;
    protected Button tvShow;
    View vReport;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vReport = inflater.inflate(R.layout.fragment_report, container, false);

        this.tvHumidity = (TextView)vReport.findViewById(R.id.showHumidity);
        this.tvPressure = (TextView)vReport.findViewById(R.id.showPressure);
        this.tvSpeed = (TextView)vReport.findViewById(R.id.showSpeed);
        this.tvTemp = (TextView)vReport.findViewById(R.id.showTemp);
        this.tvShow = (Button)vReport.findViewById(R.id.tvShow);
        //OpenWeather openWeather = new OpenWeather("-37.880775","145.026531");
        try {
            new AsyncTask<String, Void, String>() {
                @Override
                protected String doInBackground(String... params) {
                    OpenWeather openWeather = new OpenWeather("-37.880775", "145.026531");
                    return openWeather.getHumidity();
                }

                @Override
                protected void onPostExecute(String response) {

                    super.onPostExecute(response);
                    renderHumidity(response);
                }
            }.execute();
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            new AsyncTask<String, Void, String>() {
                @Override
                protected String doInBackground(String... params) {
                    OpenWeather openWeather = new OpenWeather("-37.880775", "145.026531");
                    return openWeather.getPressure();
                }

                @Override
                protected void onPostExecute(String response) {

                    super.onPostExecute(response);
                    renderPress(response);
                }
            }.execute();
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            new AsyncTask<String, Void, String>() {
                @Override
                protected String doInBackground(String... params) {
                    OpenWeather openWeather = new OpenWeather("-37.880775", "145.026531");
                    return openWeather.getWindspeed();
                }

                @Override
                protected void onPostExecute(String response) {

                    super.onPostExecute(response);
                    renderSpeed(response);
                }
            }.execute();
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            new AsyncTask<String, Void, String>() {
                @Override
                protected String doInBackground(String... params) {
                    OpenWeather openWeather = new OpenWeather("-37.880775", "145.026531");
                    return openWeather.getTemperature();
                }

                @Override
                protected void onPostExecute(String response) {

                    super.onPostExecute(response);
                    renderTemp(response);
                }
            }.execute();
        }catch (Exception e){
            System.out.println(e);
        }
        return vReport;
    }


    private void renderHumidity(String temp){
        try {

            tvHumidity.setText(temp+" %");
        }catch(Exception e){
            Log.e("SimpleWeather", "One or more fields not found in the JSON data");
        }
    }
    private void renderSpeed(String temp){
        try {

            tvSpeed.setText(temp+" m/s");
        }catch(Exception e){
            Log.e("SimpleWeather", "One or more fields not found in the JSON data");
        }
    }
    private void renderPress(String temp){
        try {

            tvPressure.setText(temp+" P");
        }catch(Exception e){
            Log.e("SimpleWeather", "One or more fields not found in the JSON data");
        }
    }
    private void renderTemp(String temp){
        try {

            tvTemp.setText(temp+" K");
        }catch(Exception e){
            Log.e("SimpleWeather", "One or more fields not found in the JSON data");
        }
    }
}
