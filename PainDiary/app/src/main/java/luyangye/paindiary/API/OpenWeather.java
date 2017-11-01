package luyangye.paindiary.API;

import org.json.JSONObject;


public class OpenWeather {

    private String lat;
    private String lon;
    private String temperature;
    private String humidity;
    private String windspeed;
    private String pressure;

    public OpenWeather(String inputLat, String inputLon){
        lat = inputLat;
        lon = inputLon;
        this.temperature = this.searchWeatherAPI()[0];
        this.humidity = this.searchWeatherAPI()[1];
        this.windspeed = this.searchWeatherAPI()[2];
        this.pressure = this.searchWeatherAPI()[3];
        System.out.println("wewewe   "+this.humidity+this.windspeed);
    }
    public String getTemperature(){
        return this.temperature;
    }
    public String getHumidity(){
        return this.humidity;
    }
    public String getWindspeed(){
        return this.windspeed;
    }
    public String getPressure(){
        return this.pressure;
    }

    private String[] searchWeatherAPI() {
        String temp = "";
        String humidity = "";
        String speed = "";
        String pressure = "";
        String API_key = "dd6712e411bec5a5a52e59a3b9ef555c";
        String[][] pathParams = new String[][]{};
        String[][] queryParams = new String[][]{};
        String strResponse="";
        RestConnection conn = new RestConnection("http://api.openweathermap.org/data/2.5/weather?lat="+ lat + "&lon=" + lon + "&APPID=" + API_key, pathParams, queryParams);
        try{
            RestResponse response = conn.get();
            strResponse =response.getDataAsString();
            JSONObject json = new JSONObject(strResponse);

            JSONObject bufferA = json.getJSONObject("main");


            temp = bufferA.getString("temp").toString();

            JSONObject bufferB = json.getJSONObject("main");
            humidity = bufferB.getString("humidity").toString();

            JSONObject bufferC = json.getJSONObject("wind");
            speed = bufferC.getString("speed");

            JSONObject bufferD = json.getJSONObject("main");
            pressure = bufferD.getString("pressure");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        String[] weather = new String[4];
        weather[0] = temp;
        weather[1] = humidity;
        weather[2] = speed;
        weather[3] = pressure;


        return weather;
    }
}
