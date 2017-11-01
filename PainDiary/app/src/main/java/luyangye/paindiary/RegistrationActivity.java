package luyangye.paindiary;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.SimpleDateFormat;

import luyangye.paindiary.API.Geocoding;
import luyangye.paindiary.DB.DBManager;
import luyangye.paindiary.RESTful.Doctor;
import luyangye.paindiary.RESTful.RESTclient;
import luyangye.paindiary.RESTful.Registration;
import luyangye.paindiary.RESTful.Users;

/**
 * Created by YLY on 20/04/2016.
 */
public class RegistrationActivity extends AppCompatActivity {


    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");

    private DatePickerDialog dueDateDatePickerDialog;
    protected DBManager dbManager;

    private Button subButton;
    private Button cancelButton;
    private EditText etuserName;
    private EditText etpassWd;
    private EditText etfirstName;
    private EditText etlastName;
    private EditText etaddress;
    private EditText etdob;
    private EditText etheight;
    private EditText etweight;
    private EditText etoccupation;
    private EditText etgpfirstName;
    private EditText etgplastName;
    private EditText etclinicAddr;
    private String checkGender;
    static int sqlId=1;
    //View vRegistration;
    protected void sendToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();}
    public RegistrationActivity(){

    }
    public void onCreate(Bundle savedInstanceState) {
        System.out.println("111111111");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        System.out.println("111111111");
        dbManager = new DBManager(this);
        //vRegistration = inflater.inflate(R.layout.registration, container, false);
        this.etuserName = (EditText)this.findViewById(R.id.username_reg);
        this.etpassWd = (EditText)this.findViewById(R.id.passwd_reg);
        this.etfirstName = (EditText)this.findViewById(R.id.first_name_reg);
        this.etlastName = (EditText)this.findViewById(R.id.last_name_reg);
        this.etaddress = (EditText)this.findViewById(R.id.address_reg);
        this.etdob = (EditText)this.findViewById(R.id.dob_reg);
        this.etheight = (EditText)this.findViewById(R.id.height_reg);
        this.etweight = (EditText)this.findViewById(R.id.weight_reg);
        this.etoccupation = (EditText)this.findViewById(R.id.occupation_reg);
        this.etgpfirstName = (EditText)this.findViewById(R.id.gpfname_reg);
        this.etgplastName = (EditText)this.findViewById(R.id.gplname_reg);
        this.etclinicAddr = (EditText)this.findViewById(R.id.clinicaddr_reg);
        RadioGroup gendergroup = (RadioGroup)this.findViewById(R.id.genderGroup);
        setDateTimeField();
        System.out.println("2222222");
        gendergroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup gendergroup, int checkedId) {
                if (checkedId == R.id.male_reg) {
                    RegistrationActivity.this.checkGender = "Male";
                }

                if (checkedId == R.id.female_reg) {
                    RegistrationActivity.this.checkGender = "Female";
                }


            }
        });
        System.out.println("333333");
        subButton = (Button) this.findViewById(R.id.submitBtn);
        subButton.setOnClickListener(sublistener);
        cancelButton = (Button) this.findViewById(R.id.cancelBtn);
        cancelButton.setOnClickListener(cancellistener);



    }

    private void setDateTimeField() {
        Calendar newCalendar = Calendar.getInstance();
        dueDateDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                etdob.setText(sdf.format(newDate.getTime())); //
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        etdob.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    onDatePickClick(v);
            }
        });
    }

    public void onDatePickClick(View view) {
        if(view == etdob) {
            dueDateDatePickerDialog.show();
        }
    }

    private View.OnClickListener sublistener = new View.OnClickListener() {

        public void onClick(View v) {



            new AsyncTask<String, Void, String>() {
                @Override
                protected String doInBackground(String... params) {
                    int userId = RESTclient.findNextId() + 1;
                    Date currTime = new Date();



                    Registration register = new Registration();
                    register.setUsername("adasd");
                    register.setPasswd("assddasd");
                    register.setRegDate(currTime);
                    register.setRegId(userId);
                    register.setRegTime(currTime);
                    Encryption ec = new Encryption();

                    String pswwd = ec.md5(register.getPasswd());

                    System.out.println("!!!!cipher " + pswwd);

                    RESTclient.createRegistration(register);

                    //Users user = new Users(userId, "www", "www", currTime,2, 2, "www","www", "www");
                    Users user = new Users();
                    System.out.println("asdww22222222fafadsf" + user.toString());
                    System.out.println(user.getUserFname());
                    user.setUserFname("kokoko");
                    user.setUserId(userId);
                    user.setUserLname("sda");
                    user.setUserAddress("ad");
                    user.setUserDob(currTime);
                    user.setUserHeight(2);
                    user.setUserWeight(2);
                    user.setUserOccup("adss");
                    user.setUserGender("Male");
                    user.setRegId(RESTclient.findRegistrationByRegId(userId));
                    user.setDocId(RESTclient.findDoctorById(1));
                    System.out.println("asdfafadsf" + user.toString());
                    System.out.println(user.getUserFname());
                    RESTclient.createUser(user);
                   // System.out.println(userId);
                    return "successful";

                }
                @Override
                protected void onPostExecute(String response) {

                    String result = response;

                }
            }.execute();



//            if(true){
//                return;
//            }


            try {

                final String userName = etuserName.getText().toString();
                final String passWd = etpassWd.getText().toString();
                final String firstName = etfirstName.getText().toString();
                final String lastName = etlastName.getText().toString();
                final String address = etaddress.getText().toString();
                final String datetemp = etdob.getText().toString();
                final Date dob = sdf.parse(datetemp);
                final String heighttemp = etheight.getText().toString();
                final int height = Integer.parseInt(heighttemp);
                final String weighttemp = etweight.getText().toString();
                final int weight = Integer.parseInt(weighttemp);
                final String occupation = etoccupation.getText().toString();
                final String gpfirstName = etgpfirstName.getText().toString();
                final  String gplastName = etgplastName.getText().toString();
                final String clincicAddr = etclinicAddr.getText().toString();
                final String gender = checkGender;
                final Date currtime;



                if (userName.equals(""))
                    sendToast("Please enter your User Name");
                if (passWd.equals(""))
                    sendToast("Please enter your Password");
                if (firstName.equals(""))
                    sendToast("Please enter your First Name");
                if (lastName.equals(""))
                    sendToast("Please enter your Last Name");
                if (address.equals(""))
                    sendToast("Please enter your Address");
                if (datetemp.equals(""))
                    sendToast("Please enter your Date of Birth");
                if (heighttemp.equals(""))
                    sendToast("Please enter your Height");
                if (weighttemp.equals(""))
                    sendToast("Please enter your Weight");
                if (occupation.equals(""))
                    sendToast("Please enter your Occupation");
                if (gpfirstName.equals(""))
                    sendToast("Please enter your GP's First Name");
                if (gplastName.equals(""))
                    sendToast("Please enter your GP's Last Name");
                if (clincicAddr.equals(""))
                    sendToast("Please enter your Clinic Address");
                if (gender.equals(""))
                    sendToast("Please choose your Gender");
                else {
                    Doctor doctor = new Doctor();
                    Date currTime = new Date();

                   // sdf.format(currTime.getTime()).toString();
                   // sdf2.format(currTime.getDate())
                    insertData(Integer.toString(sqlId), address, currTime.toString(), currTime.toString());
                           System.out.println("SQQQQQLLLLLLL");
                    sqlId++;


//                    ArrayList<Users> usersCollection = new ArrayList<>();
//                    usersCollection.add(user);
//                    register.setUsersCollection(usersCollection);
//                    ArrayList<DailyRecord> recordCollection = new ArrayList<>();

                    doctor.setDocFname(gpfirstName);
                    doctor.setDocLname(gplastName);
                    doctor.setClinicAddress(clincicAddr);
                    doctor.setClinicPhone("111111");
                    doctor.setDocPhone("1111111");



//                    user.setDailyRecordCollection(recordCollection);
//                    user.setDocId(doctor);


                    new AsyncTask<String, Void, String>() {
                        @Override
                        protected String doInBackground(String... params) {
                            int userId = RESTclient.findNextId() + 1;
                            Date currTime = new Date();

                            Registration register = new Registration();
                            register.setUsername(userName);

                            Encryption ec = new Encryption();
                            String pswwd = ec.md5(passWd);

                            register.setPasswd(pswwd);
                            register.setRegDate(currTime);
                            register.setRegId(userId);
                            register.setRegTime(currTime);
                            RESTclient.createRegistration(register);

                            Users user = new Users();
                            user.setUserFname(firstName);
                            user.setUserId(userId);
                            user.setUserLname(lastName);
                            user.setUserAddress(address);
                            user.setUserDob(dob);
                            user.setUserHeight(height);
                            user.setUserWeight(weight);
                            user.setUserOccup(occupation);
                            user.setUserGender(gender);
                            user.setRegId(RESTclient.findRegistrationByRegId(userId));
                            user.setDocId(RESTclient.findDoctorById(1));
                            RESTclient.createUser(user);
                            System.out.println(userId);
                            return "successful";

                        }
                        @Override
                        protected void onPostExecute(String response) {
                            int userId = RESTclient.findNextId() + 1;

                            String result = response;

                        }
                    }.execute();
                   // strUserId,firstName,lastName,dob,Integer.toString(height),Integer.toString(weight)
//                    new AsyncTask<String, Void, String>() {
//                        @Override
//                        protected String doInBackground(String... params) {
//                            int userId = RESTclient.findNextId() + 1;
//                            insertData(Integer.toString(userId),address,"1","1",datetemp,datetemp);
//                            System.out.println("SQQQQQLLLLLLL");
//                            return "successful";
//                        } protected void onPostExecute(String response) {
//
//                            String result = response;
//
//                        }
//                    }.execute();

                    Intent intent = new Intent();
                    intent.setClass(RegistrationActivity.this, MainActivity.class);
                    startActivity(intent);

                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    };

    public void insertData(String userid,String address, String date, String time){

        try {
            dbManager.open();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }//you can enter any data here
        Geocoding geo = new Geocoding(address);
        String lat = geo.getLat();
        String lng = geo.getLng();
        System.out.println("geeeeeoooooo   "+lat+"    "+lng);
         dbManager.insertUser(userid,address,lat,lng, date,  time);
         dbManager.close();
    }


    private View.OnClickListener cancellistener = new View.OnClickListener() {

        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(RegistrationActivity.this,MainActivity.class);
            startActivity(intent);
        }
    };




}
