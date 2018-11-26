package com.example.jsavi.profileapp;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textViewUserName; //declaramos el textView del nombre
    TextView textViewUserAbout; //declaramos el textView del About
    TextView textViewRepos; //declaramos el textView de la cantidad de repositorios
    TextView textViewProjects; //declaramos el textView de la cantidad de proyectos
    TextView textViewStars; //declaramos el textView de la cantidad de estrellas

    Button buttonShare; //declaramos el boton compartir

    private final String PROF_INFO = "PROF_INFO"; //******

    People actualPeople; //declaramos una variable de tipo People

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("Profile"); //*******

        textViewUserName = findViewById(R.id.textViewUserName);
        textViewUserAbout = findViewById(R.id.textViewUserAbout);
        textViewRepos = findViewById(R.id.textViewRepos);
        textViewProjects = findViewById(R.id.textViewProjects);
        textViewStars = findViewById(R.id.textViewStars);

        buttonShare = findViewById(R.id.buttonShare); //inicializamos las variables y usamos "findViewById" para hacer referencia a los Ids de los objetos en el xml.

        if(getIntent()!=null && getIntent().getExtras()!=null){
            actualPeople = getIntent().getParcelableExtra(PROF_INFO);
            if (actualPeople != null){
                textViewUserName.setText(actualPeople.getUserName());
                textViewUserAbout.setText(actualPeople.getUserAbout());
                textViewRepos.setText(String.valueOf(actualPeople.getUserRepos()));
                textViewProjects.setText(String.valueOf(actualPeople.getUserProjects()));
                textViewStars.setText(String.valueOf(actualPeople.getUserStars()));
            }
        }
        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharePeopleInfo(actualPeople);
            }
     private void sharePeopleInfo(People people){
         Intent senderIntent = new Intent();

         String infoToSend = people.getUserName()+"\n"+people.getUserAbout();
         senderIntent.setAction(Intent.ACTION_SEND);
         senderIntent.putExtra(Intent.EXTRA_TEXT, infoToSend);
         senderIntent.setType("text/plain");
         startActivity(senderIntent);
     }
        });
    }
}
