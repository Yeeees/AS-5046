package luyangye.paindiary.RESTful;



import com.google.gson.Gson;

import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
/**
 * Created by YLY on 21/04/2016.
 */
public class RESTclient {
    private static final String BASE_URI = "http://10.0.2.2:8080/PainDiary/webresources";

    public static Doctor findDoctorById(int doctorId) {
        Doctor doctor = null;
        final String methodPath = "/restclient.doctor/" + doctorId;
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
// Making HTTP request
        try {
            url = new URL(BASE_URI + methodPath);
//open the connection
            conn = (HttpURLConnection) url.openConnection();
//set the timeout
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
//set the connection method to GET
            conn.setRequestMethod("GET");
//add HTTP headers to set your respond type to json
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
//Read the response
            Scanner inStream = new Scanner(conn.getInputStream());
//read the inputsteream and store it as string
            while (inStream.hasNextLine()) {
                textResult += inStream.nextLine();
            }
//get instance of Gson
            Gson gson = new Gson();
//convert the json string to course entity
            doctor = gson.fromJson(textResult, Doctor.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return doctor;
    }

    public static Users findPatientById(int patientId) {
        Users patient = null;
        final String methodPath = "/restclient.users/" + patientId;
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
// Making HTTP request
        try {
            url = new URL(BASE_URI + methodPath);
//open the connection
            conn = (HttpURLConnection) url.openConnection();
//set the timeout
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
//set the connection method to GET
            conn.setRequestMethod("GET");
//add HTTP headers to set your respond type to json
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
//Read the response
            Scanner inStream = new Scanner(conn.getInputStream());
//read the inputsteream and store it as string
            while (inStream.hasNextLine()) {
                textResult += inStream.nextLine();
            }
//get instance of Gson
            Gson gson = new Gson();
//convert the json string to course entity
            patient = gson.fromJson(textResult, Users.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return patient;
    }

    public static Registration findRegistrationByRegId(int regId) {
        Registration r = null;
        final String methodPath = "/restclient.registration/findByRegId/" + regId;
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
// Making HTTP request
        try {
            url = new URL(BASE_URI + methodPath);
//open the connection
            conn = (HttpURLConnection) url.openConnection();
//set the timeout
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
//set the connection method to GET
            conn.setRequestMethod("GET");
//add HTTP headers to set your respond type to json
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
//Read the response
            Scanner inStream = new Scanner(conn.getInputStream());
//read the inputsteream and store it as string
            while (inStream.hasNextLine()) {
                textResult += inStream.nextLine();
            }
//get instance of Gson
            Gson gson = new Gson();
//convert the json string to course entity
            r = gson.fromJson(textResult, Registration.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return r;
    }


    public static int findNextId(){
        final String methodPath = "/restclient.registration/count";
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
        int nextId = 0;
// Making HTTP request
        try {
            url = new URL(BASE_URI + methodPath);
//open the connection
            conn = (HttpURLConnection) url.openConnection();
//set the timeout
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
//set the connection method to GET
            conn.setRequestMethod("GET");
//add HTTP headers to set your respond type to json
            conn.setRequestProperty("Content-Type","text/plain");
            conn.setRequestProperty("Accept","text/plain");
            System.out.println("jassssssonnnnn");
//Read the response
            Scanner inStream = new Scanner(conn.getInputStream());
//read the inputsteream and store it as string
            while (inStream.hasNextLine()) {
                textResult += inStream.nextLine();
            }
//get instance of Gson
            nextId = Integer.parseInt(textResult);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return nextId;

    }


    public static String createUser(Users user) {
        //int id = findNextId()+1;
        //user.setUserId(id);
        final String methodPath = "/restclient.users";
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
// Making HTTP request
        try {
//get instance of Gson class
            Gson gson = new Gson();

//convert course entity to string json by calling toJson method
            String stringUserJson = gson.toJson(user);
            url = new URL(BASE_URI + methodPath);
//open the connection
            conn = (HttpURLConnection) url.openConnection();
//set the timeout
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
//set the connection method to POST
            conn.setRequestMethod("POST");
//set the output to true
            conn.setDoOutput(true);
//set length of the data you are sending
            conn.setFixedLengthStreamingMode(stringUserJson.getBytes().length);
//add HTTP headers to set your respond type to json
            conn.setRequestProperty("Content-Type", "application/json");
//send the POST out
            PrintWriter out = new PrintWriter(conn.getOutputStream());
            out.print(stringUserJson);
            out.close();
//Read the response
            Scanner inStream = new Scanner(conn.getInputStream());
//read the input steream and store it as string
            while (inStream.hasNextLine()) {
                textResult += inStream.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return textResult;
    }

    public static String createRegistration(Registration registration) {
        final String methodPath = "/restclient.registration";
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
// Making HTTP request
        try {
//get instance of Gson class
            Gson gson = new Gson();

//convert course entity to string json by calling toJson method
            String stringPatientJson = gson.toJson(registration);
            System.out.println(stringPatientJson);
            System.out.println("aaaaaaaaaa");
            url = new URL(BASE_URI + methodPath);
//open the connection
            conn = (HttpURLConnection) url.openConnection();
//set the timeout
            conn.setReadTimeout(70000);
            conn.setConnectTimeout(75000);
//set the connection method to POST
            conn.setRequestMethod("POST");
//set the output to true
            conn.setDoOutput(true);
//set length of the data you are sending
            conn.setFixedLengthStreamingMode(stringPatientJson.getBytes().length);
//add HTTP headers to set your respond type to json
            conn.setRequestProperty("Content-Type", "application/json");
//send the POST out
            PrintWriter out = new PrintWriter(conn.getOutputStream());
            out.print(stringPatientJson);
            out.close();
//Read the response
            Scanner inStream = new Scanner(conn.getInputStream());
//read the input steream and store it as string
            while (inStream.hasNextLine()) {
                textResult += inStream.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return textResult;
    }
    public static Registration findRegistrationByUsername(String Username) {
        Registration r = null;
        final String methodPath = "/restclient.registration/findByUserName/" + Username;
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
// Making HTTP request
        try {
            url = new URL(BASE_URI + methodPath);
//open the connection
            conn = (HttpURLConnection) url.openConnection();
//set the timeout
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
//set the connection method to GET
            conn.setRequestMethod("GET");
//add HTTP headers to set your respond type to json
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
//Read the response
            Scanner inStream = new Scanner(conn.getInputStream());
//read the inputsteream and store it as string
            while (inStream.hasNextLine()) {
                textResult += inStream.nextLine();
            }
//get instance of Gson
            Gson gson = new Gson();
//convert the json string to course entity
            r = gson.fromJson(textResult, Registration.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return r;
    }
}
