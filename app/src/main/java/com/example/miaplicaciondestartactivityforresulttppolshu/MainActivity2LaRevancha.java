package com.example.miaplicaciondestartactivityforresulttppolshu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2LaRevancha extends AppCompatActivity {

    TextView tvTuNombreMiAmor;
    EditText edtNombreDelAmigazoIngresado;
    Button btnNosFuimos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_la_revancha);

        inicarRevancha();


    }

    private void inicarRevancha() {
        tvTuNombreMiAmor = findViewById(R.id.tvTuNombreMiAmor);
        edtNombreDelAmigazoIngresado = findViewById(R.id.edtNombreDelAmigazoIngresado);
        btnNosFuimos = findViewById(R.id.btnNosFuimos);

    }
}