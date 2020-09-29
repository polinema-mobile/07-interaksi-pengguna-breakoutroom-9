package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button btnDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText etData1 = (EditText) findViewById(R.id.nama);
        final EditText etData2 = (EditText) findViewById(R.id.nim);
        final EditText etData3 = (EditText) findViewById(R.id.tanggal);
        final EditText etData4 = (EditText) findViewById(R.id.tanggal);
        final EditText etData5 = (EditText) findViewById(R.id.tanggal);
        addListenerOnButton();


        Button btSubmitIntent = (Button) findViewById(R.id.btnSimpan);

        btSubmitIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**
                 * Passing data via Intent
                 */

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("data1", etData1.getText().toString());
                intent.putExtra("data2", etData2.getText().toString());
                intent.putExtra("data3", etData3.getText().toString());
                intent.putExtra("data4", etData4.getText().toString());
                intent.putExtra("data5", etData5.getText().toString());
                startActivity(intent);
            }
        });
    }

    public void addListenerOnButton() {

        radioGroup = (RadioGroup) findViewById(R.id.radio);
        btnDisplay = (Button) findViewById(R.id.btnSimpan);

        btnDisplay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);

                Toast.makeText(MainActivity.this,
                        radioButton.getText(), Toast.LENGTH_SHORT).show();

            }

        });


    }





}