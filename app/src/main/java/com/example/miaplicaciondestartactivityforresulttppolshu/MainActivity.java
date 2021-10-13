package com.example.miaplicaciondestartactivityforresulttppolshu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnTomarFotografias;
    Button btnPresentarAmigo;
    Button btnPonerTuNombre;
    ImageView imgTuPlasmion;
    TextView tvCosaDeContacto;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarReferenciados();

    }

    private void iniciarReferenciados() {
        btnTomarFotografias = findViewById(R.id.btnTomarFotografias);
        btnPresentarAmigo = findViewById(R.id.btnPresentarAmigo);
        btnPonerTuNombre = findViewById(R.id.btnPonerTuNombre);
        imgTuPlasmion = findViewById(R.id.imgTuPlasmion);
        tvCosaDeContacto = findViewById(R.id.tvCosaDeContacto);
    }
}