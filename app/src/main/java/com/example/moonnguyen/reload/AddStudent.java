package com.example.moonnguyen.reload;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddStudent extends AppCompatActivity {
    EditText Mssv,Name,dob,clas;
    Button add,edit,cancel,del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Mssv=(EditText)findViewById(R.id.edMS);
        Name=(EditText)findViewById(R.id.edName);
        dob=(EditText)findViewById(R.id.edDOB);
        clas=(EditText)findViewById(R.id.edClass);
        add=(Button)findViewById(R.id.btnAdd);
        edit=(Button)findViewById(R.id.btnEdit);
        cancel=(Button)findViewById(R.id.btnCan);
        del=(Button)findViewById(R.id.btnDel);

        final Intent intent = new Intent(this,MainActivity.class);
        final Sinhvien qlsv = new Sinhvien(this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idstd = Mssv.getText().toString();
                String fnstd=Name.getText().toString();
                String dobstd=dob.getText().toString();
                String classtd=clas.getText().toString();

                qlsv.taosinhvien(idstd,fnstd,dobstd,classtd);
                startActivity(intent);
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idstd=Mssv.getText().toString();
                String fnstd=Name.getText().toString();
                String dobstd=dob.getText().toString();
                String classtd=clas.getText().toString();

                qlsv.suasv(idstd,fnstd,dobstd,classtd);
                startActivity(intent);
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idstd =Mssv.getText().toString();

                qlsv.xoasv(idstd);
                startActivity(intent);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
