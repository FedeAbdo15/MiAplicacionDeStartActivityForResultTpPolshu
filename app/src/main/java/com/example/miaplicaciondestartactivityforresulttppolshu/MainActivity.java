package com.example.miaplicaciondestartactivityforresulttppolshu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int CODIGO_PARA_LA_FOTO = 69;
    public static final int CODIGO_PARA_EL_AMIGO = 420;
    public static final int CODIGO_PARA_EL_NOMBRE = 119;

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
        setearEscuchadores();
    }

    private void setearEscuchadores() {
        btnTomarFotografias.setOnClickListener(v -> {
            Intent intentDeLaCamara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intentDeLaCamara, CODIGO_PARA_LA_FOTO);
        });
        btnPresentarAmigo.setOnClickListener(v -> {
            Intent intentDelContacto = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
            startActivityForResult(intentDelContacto, CODIGO_PARA_EL_AMIGO);

        });
        btnPonerTuNombre.setOnClickListener(v -> {
            Intent intentDeMiNombre = new Intent(this, MainActivity2LaRevancha.class);
            startActivityForResult(intentDeMiNombre, CODIGO_PARA_EL_NOMBRE);
        });
    }

    void mostrarNombre(String nombre) {
        tvCosaDeContacto.setText(nombre);
    }

    @Override
    public void onActivityResult(int reqCode, int resultCode, Intent data) {

        super.onActivityResult(reqCode, resultCode, data);


        if (resultCode == RESULT_CANCELED) return;

        switch (reqCode) {
            case CODIGO_PARA_LA_FOTO:
                Bitmap picture = (Bitmap) data.getExtras().get("data");
                imgTuPlasmion.setImageBitmap(picture);
                break;
            case CODIGO_PARA_EL_AMIGO:
                Uri uri = data.getData();
                Cursor cursor = getContentResolver().query(uri, null, null, null, null);
                cursor.moveToFirst();
                String nombre = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                mostrarNombre(nombre);
                break;
            case CODIGO_PARA_EL_NOMBRE:
                String nombreAmigazo = data.getExtras().getString("nombre del amigazo");
                mostrarNombre(nombreAmigazo);
        }
    }

    private void iniciarReferenciados() {
        btnTomarFotografias = findViewById(R.id.btnTomarFotografias);
        btnPresentarAmigo = findViewById(R.id.btnPresentarAmigo);
        btnPonerTuNombre = findViewById(R.id.btnPonerTuNombre);
        imgTuPlasmion = findViewById(R.id.imgTuPlasmion);
        tvCosaDeContacto = findViewById(R.id.tvCosaDeContacto);
    }
}