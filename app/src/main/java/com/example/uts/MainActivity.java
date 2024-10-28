package com.example.uts;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText eNama,eEmail,eNoTelp;

    private RadioGroup RG1;
    private RadioButton rbKelamin;

    private CheckBox CB1,CB2,CB3;

    private Button bSimpan;
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            simpan(view);
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        eNama = findViewById(R.id.editNama);
        eEmail = findViewById(R.id.editEmail);
        eNoTelp = findViewById(R.id.editNoTelp);

        RG1 = (RadioGroup) findViewById(R.id.rgKelamin);

        CB1 = (CheckBox) findViewById(R.id.bola);
        CB2 = (CheckBox) findViewById(R.id.badminton);
        CB3 = (CheckBox) findViewById(R.id.basket);

        bSimpan = findViewById(R.id.btnSimpan);

        bSimpan.setOnClickListener(onClickListener);
    }

    private void simpan(View view) {
        String nama = eNama.getText().toString();
        String email = eEmail.getText().toString();
        String notelp = eNoTelp.getText().toString();

        rbKelamin  = (RadioButton)findViewById(RG1.getCheckedRadioButtonId());
        String kelamin = rbKelamin.getText().toString();

        String checkBoxChoices = "";

        if (CB1.isChecked()) {
            checkBoxChoices += CB1.getText().toString() + "\t Iya\n";
        } else {
            checkBoxChoices += CB1.getText().toString() + "\t Tidak\n";
        }

        if (CB2.isChecked()) {
            checkBoxChoices += CB2.getText().toString() + "\t  Iya\n";
        } else {
            checkBoxChoices += CB2.getText().toString() + "\t  Tidak\n";
        }

        if (CB3.isChecked()) {
            checkBoxChoices += CB3.getText().toString() + "\t  Iya\n";
        } else {
            checkBoxChoices += CB3.getText().toString() + "\t  Tidak\n";
        }

        Toast.makeText(MainActivity.this, "Nama: " + nama + "\nEmail: " + email + "\nNomor Telepon: " + notelp + "\nJenis Kelamin: " + kelamin + "\nHobi: \n"+ checkBoxChoices , Toast.LENGTH_LONG).show();
    }
}