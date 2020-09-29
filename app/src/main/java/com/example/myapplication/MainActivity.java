package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private RadioGroup jenis_kelamin;
    private RadioButton laki, perempuan;
    private Button btnDisplay;
    DatePickerDialog picker;
    EditText eText;
    TextView tvw;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eText=(EditText) findViewById(R.id.tanggal);

        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        jenis_kelamin = findViewById(R.id.jenis_kelamin);
        laki = findViewById(R.id.laki);
        perempuan = findViewById(R.id.perempuan);

        final EditText etData1 = (EditText) findViewById(R.id.nama);
        final EditText etData2 = (EditText) findViewById(R.id.nim);
        final EditText etData3 = (EditText) findViewById(R.id.tanggal);
        final RadioGroup etData4 = (RadioGroup) findViewById(R.id.jenis_kelamin);
        final Spinner etData5 = (Spinner) findViewById(R.id.listJurusan);


        Button btSubmitIntent = (Button) findViewById(R.id.btnSimpan);

        btSubmitIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = jenis_kelamin.getCheckedRadioButtonId();
                /**
                 * Passing data via Intent
                 */

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("data1", etData1.getText().toString());
                intent.putExtra("data2", etData2.getText().toString());
                intent.putExtra("data3", etData3.getText().toString());
                if(laki.isChecked()){
                    laki = (RadioButton) findViewById(selectedId);
                    intent.putExtra("data4", laki.getText().toString());
                }else{
                    intent.putExtra("data4", perempuan.getText().toString());
                }
                intent.putExtra("data5", etData5.getSelectedItem().toString());
                startActivity(intent);
            }
        });

        //=============================================


    }







}