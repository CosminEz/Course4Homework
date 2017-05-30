package com.example.cosmin.course3homework;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.cosmin.course3homework.Adapter.StudentAdapter;
import com.example.cosmin.course3homework.Model.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,RadioGroup.OnCheckedChangeListener{
    private EditText editTextNume;
    private EditText editTextPrenume;
    private EditText editTextMail;
    private EditText editTextTelefon;
    private RadioGroup grupUniversitati;
    private RadioButton universitate;
    private Button salveazaButton;
    private CheckBox checkBoxOOP;
    private CheckBox checkBoxCSHARP;
    private CheckBox checkBoxJAVA;
    private CheckBox checkBoxC;
    private DBHelper db;
    public static final String EXTRA_MESSAGE = "student";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        editTextNume=(EditText)findViewById(R.id.Nume);
        editTextPrenume=(EditText)findViewById(R.id.Prenume);
        editTextMail=(EditText)findViewById(R.id.Email);
        editTextTelefon=(EditText)findViewById(R.id.Telefon);
        grupUniversitati=(RadioGroup)findViewById(R.id.grupUniversitati);
        salveazaButton=(Button)findViewById(R.id.salveaza);
        grupUniversitati.setOnCheckedChangeListener(this);
        checkBoxOOP=(CheckBox)findViewById(R.id.oop);
        checkBoxJAVA=(CheckBox)findViewById(R.id.java);
        checkBoxC=(CheckBox)findViewById(R.id.c);
        checkBoxCSHARP=(CheckBox)findViewById(R.id.csharp);
        db=DBHelper.getInstance(this);





        salveazaButton.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {

        if(v == salveazaButton){
            String nume=editTextNume.getText().toString().trim();
            if(TextUtils.isEmpty(nume)) {
                //email is empty
                Toast.makeText(this,"Please enter a last name ", Toast.LENGTH_SHORT).show();
                //stop the function to progress
                return;
            }
            String prenume=editTextPrenume.getText().toString().trim();
            if(TextUtils.isEmpty(prenume)) {
                //email is empty
                Toast.makeText(this,"Please enter a first name ", Toast.LENGTH_SHORT).show();
                //stop the function to progress
                return;
            }
            String mail=editTextMail.getText().toString().trim();
            if(TextUtils.isEmpty(mail)) {
                //email is empty
                Toast.makeText(this,"Please enter an email address ", Toast.LENGTH_SHORT).show();
                //stop the function to progress
                return;
            }
            String telefon=editTextTelefon.getText().toString().trim();
            if(TextUtils.isEmpty(telefon)) {
                //email is empty
                Toast.makeText(this,"Please enter a telephone ", Toast.LENGTH_SHORT).show();
                //stop the function to progress
                return;
            }
            StringBuilder cunostinte=new StringBuilder();
            if(checkBoxOOP.isChecked())
                cunostinte.append(checkBoxOOP.getText().toString().trim()+" ");
            if(checkBoxJAVA.isChecked())
                cunostinte.append(checkBoxJAVA.getText().toString().trim()+" ");
            if(checkBoxC.isChecked())
                cunostinte.append(checkBoxC.getText().toString().trim()+" ");
            if(checkBoxCSHARP.isChecked())
                cunostinte.append(checkBoxCSHARP.getText().toString().trim()+" ");

            Student student = new Student (0,nume,prenume,universitate.getText().toString().trim(),mail,telefon,cunostinte);


            db.insertStudent(student);
            Intent intent=new Intent(MainActivity.this,AfisareStudenti.class);
            startActivity(intent);
        }


    }


    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        universitate=(RadioButton)findViewById(checkedId);

    }
}
