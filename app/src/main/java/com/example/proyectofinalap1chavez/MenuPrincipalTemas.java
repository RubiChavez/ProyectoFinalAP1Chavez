package com.example.proyectofinalap1chavez;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuPrincipalTemas extends AppCompatActivity {
    private Button btnPerfil;
    private EditText etUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal_temas);

        btnPerfil = findViewById(R.id.btnPerfil);
        etUsuario = findViewById(R.id.etUsuario);


        btnPerfil.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String usuario = etUsuario.getText().toString();
                Intent intent = new Intent(MenuPrincipalTemas.this, Perfil.class);
                intent.putExtra("usuario", usuario);
                startActivity(intent);
            }
        });

    }
}