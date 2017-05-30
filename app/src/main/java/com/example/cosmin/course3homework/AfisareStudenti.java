package com.example.cosmin.course3homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cosmin.course3homework.Adapter.StudentAdapter;
import com.example.cosmin.course3homework.Model.Student;

import java.util.ArrayList;
import java.util.List;

public class AfisareStudenti extends AppCompatActivity implements View.OnClickListener{

    private ListView listViewStudent;
    private static List<Student> listaStudenti = new ArrayList<>();
    private DBHelper db;
    private Button buttonAdaugareStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afisare_studenti);



        db=DBHelper.getInstance(this);


        listaStudenti=db.getAllStudents();
        if(listaStudenti.size()==0){
            Intent intent=new Intent(AfisareStudenti.this,ListaGoala.class);
            startActivity(intent);

        }
        else{
            buttonAdaugareStudent=(Button)findViewById(R.id.student);
            listViewStudent = (ListView) findViewById(R.id.lv_student);
            StudentAdapter studentAdapter = new StudentAdapter(listaStudenti, AfisareStudenti.this);
            listViewStudent.setAdapter(studentAdapter);

            buttonAdaugareStudent.setOnClickListener(this);}
            listViewStudent.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    /*Toast.makeText(view.getContext() ,"Ai apasat pe "+listaStudenti.get(position).getuniversitate(),
                            Toast.LENGTH_SHORT).show();*/
                    Intent intent = new Intent(AfisareStudenti.this, MainActivity.class);
                    intent.putExtra("EXTRA_STUDENT", position);
                    startActivity(intent);
                    return  true;


        }
    });
    }


    @Override
    public void onClick(View view) {
        if(view==buttonAdaugareStudent){
            Intent intent=new Intent(AfisareStudenti.this,MainActivity.class);
            startActivity(intent);
        }
    }
}
