package com.example.cosmin.course3homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListaGoala extends AppCompatActivity implements View.OnClickListener{
    Button adaugaStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_goala);
        adaugaStudent=(Button)findViewById(R.id.adaugastudentgol);
        adaugaStudent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==adaugaStudent){
            Intent intent=new Intent(ListaGoala.this,MainActivity.class);
            startActivity(intent);
        }

    }
}
