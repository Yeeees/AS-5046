package luyangye.paindiary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import luyangye.paindiary.RESTful.Users;

public class MainActivity extends AppCompatActivity {

    protected Button loginButton;
    protected Button createButton;
    protected EditText loginUsername;
    protected EditText loginPasswd;
    protected static Users user;

    protected void sendToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void onClickLogInBtn(View v){



    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        loginUsername = (EditText) this.findViewById(R.id.loginName);
        loginPasswd = (EditText) this.findViewById(R.id.logPassword);


        loginButton = (Button) this.findViewById(R.id.loginButton);
        loginButton.setOnClickListener(loginlistener);
        createButton = (Button) this.findViewById(R.id.createNewAccountButton);
        createButton.setOnClickListener(reglistener);

    }
    private View.OnClickListener reglistener = new View.OnClickListener() {

        public void onClick(View v) {
            Intent intent = new Intent();

            intent.setClass(getBaseContext(), RegistrationActivity.class);
            startActivity(intent);
            System.out.println("ssasasas");
        }
    };
    private View.OnClickListener loginlistener = new View.OnClickListener() {

        public void onClick(View v) {
//            final String username = loginUsername.getText().toString();
//            final String passwd = loginPasswd.getText().toString();
//            new AsyncTask<String, Void, String>() {
//                @Override
//                       protected String doInBackground(String... params) {
//
//
//            return RESTclient.findRegistrationByUsername(username).getPasswd();
//        }
//
//        protected void onPostExecute(String response) {
//            if (passwd.equals(response)) {
//                Intent intent = new Intent();
//                intent.setClass(getBaseContext(), Main_app.class);
//                startActivity(intent);
//                System.out.println("ssasasas");
//            } else {
//                sendToast("Wrong Password!");
//            }
//            String result = response;
//
//        }
//    }.execute();

            Intent intent = new Intent();
            intent.setClass(getBaseContext(), Main_app.class);
            startActivity(intent);
        }
    };



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}