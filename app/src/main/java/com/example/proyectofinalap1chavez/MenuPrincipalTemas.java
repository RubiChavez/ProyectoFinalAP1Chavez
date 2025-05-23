package com.example.proyectofinalap1chavez;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuPrincipalTemas extends AppCompatActivity {
    private Button btnPerfil, btnCerrarS;
    private TextView tvUsuario;
    private ImageButton btnConjuntos, btnRelaciones, btnLogicaMat, btnGraficas, btnInducRecursion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal_temas);

        btnPerfil = findViewById(R.id.btnPerfil);
        tvUsuario = findViewById(R.id.tvUsuario);
        btnCerrarS = findViewById(R.id.btnCerrarS);
        btnConjuntos = findViewById(R.id.btnConjuntos);
        btnLogicaMat = findViewById(R.id.btnLogicaMatematica);
        btnRelaciones = findViewById(R.id.btnRelaciones);
        btnGraficas = findViewById(R.id.btnGraficas);
        btnInducRecursion = findViewById(R.id.btnInducRec);

        String usuario = getIntent().getStringExtra("usuario");
        tvUsuario.setText(usuario);


        btnPerfil.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String usuarioTexto = tvUsuario.getText().toString(); // lo tomamos del tv
                Intent intent = new Intent(MenuPrincipalTemas.this, Perfil.class);
                intent.putExtra("usuario", usuarioTexto);
                startActivity(intent);
            }
        });

        btnCerrarS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPrincipalTemas.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnConjuntos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPrincipalTemas.this, Conjuntos.class);
                startActivity(intent);
            }
        });
        btnRelaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPrincipalTemas.this, Relaciones.class);
                startActivity(intent);
            }
        });
        btnLogicaMat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPrincipalTemas.this, LogicaMatematica.class);
                startActivity(intent);
            }
        });
        btnGraficas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPrincipalTemas.this, Graficas.class);
                startActivity(intent);
            }
        });
        btnInducRecursion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPrincipalTemas.this, InducRecursion.class);
                startActivity(intent);
            }
        });

    }
}