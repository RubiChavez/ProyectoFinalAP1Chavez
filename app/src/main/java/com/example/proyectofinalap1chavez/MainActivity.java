package com.example.proyectofinalap1chavez;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnInicioSesion;
    private Button btnAlta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       btnAlta = findViewById(R.id.btnAlta);

       btnAlta.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, RegistroUsuarios.class);
            startActivity(intent);
        }
       });
    }
}