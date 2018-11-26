package com.example.jsavi.profileapp;

import android.content.Intent;
import android.support.v4.app.Person;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button buttonSignInVar; //declaramos el boton de SignIn
    EditText editTextInputEmail; //declaramos el EditText del Email
    EditText editTextInputPassword; //declaramos el EditText del Password
    HashMap<String, People> info; //declaramos un Hash map llamado "info" que nos ayudará con la insercion y busqueda de data.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInputEmail = findViewById(R.id.editTextEmail);
        editTextInputPassword = findViewById(R.id.editTextPassword);

        buttonSignInVar = findViewById(R.id.buttonSignIn); //inicializamos las variables y usamos "findViewById" para hacer referencia a los Ids de los objetos en el xml.

        createFakeList();

        buttonSignInVar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = "";
                if (editTextInputEmail != null) {
                    userEmail = editTextInputEmail.getText().toString().toLowerCase();
                }
                People actualPeople  = info.get(userEmail);
                if (actualPeople != null){
                    Intent intentAct = new Intent(MainActivity.this, SecondActivity.class);
                    intentAct.putExtra("PROF_INFO", actualPeople);
                    startActivity(intentAct);
            }
                else
            {
                displayErrorBox();
                editTextInputEmail.setText("");
                editTextInputPassword.setText("");
            }
        }
        });
    }
    private void displayErrorBox(){
        AlertDialog.Builder warningDisplay = new AlertDialog.Builder(this);
        warningDisplay.setMessage(R.string.dialog_msg);
        warningDisplay.setTitle(R.string.dialog_title);
        warningDisplay.setPositiveButton("OK",null);
        warningDisplay.setCancelable(true);
        warningDisplay.create().show();
    }

    private void createFakeList(){
        People people = new People();
        people.setUserName("José Ángel Saviñón García");
        people.setUserEmail("j.savinong@gmail.com");
        people.setUserAbout("I'm Computer Systems Engineer learning to develop android Apps");
        people.setUserRepos(100);
        people.setUserProjects(200);
        people.setUserStars(300);
        People people1 = new People();
        people1.setUserName("José Isaac Restrepo Ibarra");
        people1.setUserAbout("I'm colombian living in Dominican Republic");
        people.setUserRepos(200);
        people.setUserProjects(150);
        people.setUserStars(100);

        info = new HashMap<>();
        info.put("j.savinong@gmail.com", people);

    }
}
