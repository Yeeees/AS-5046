package luyangye.paindiary.API;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by YLY on 23/04/2016.
 */


public class Geocoding {

    private String address;
    private String lat;
    private String lng;

    public Geocoding(String inputAddress){

        address = inputAddress;
        this.lat = this.searchGeocodingAPI()[0];
        this.lng = this.searchGeocodingAPI()[1];
    }
    public String getLat(){
        return this.lat;
    }
    public String getLng(){
        return this.lng;
    }

    private String[] searchGeocodingAPI() {
        String API_key = "AIzaSyB_6OfvRNnfNPP5EbUHufIikClbdnq5fQg";
        address = address.replace(" ", "+");
        String lat = "";
        String lng = "";
        String[][] pathParams = new String[][]{};
        String[][] queryParams = new String[][]{};
        String strResponse="";
        RestConnection conn = new RestConnection("https://maps.googleapis.com/maps/api/geocode/json?address=" + address + "&key=" + API_key, pathParams, queryParams);
        try{
            RestResponse response = conn.get();
            strResponse =response.getDataAsString();
            JSONObject json = new JSONObject(strResponse);

            JSONArray jsonarray = json.getJSONArray("results");
            if(jsonarray != null && jsonarray.length() > 0){
                lat = jsonarray.getJSONObject(0).getJSONObject("geometry").getJSONObject("location").getString("lat");
                lng = jsonarray.getJSONObject(0).getJSONObject("geometry").getJSONObject("location").getString("lng");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        String[] geocoding = new String[2];
        geocoding[0] = lat;
        geocoding[1] = lng;
        return geocoding;
    }
}
