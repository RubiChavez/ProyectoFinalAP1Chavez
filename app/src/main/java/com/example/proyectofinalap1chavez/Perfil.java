package com.example.proyectofinalap1chavez;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Perfil extends AppCompatActivity {
    EditText etPidUsuario, etPerfilUsuario, etPerfilContra;
    Button btnActualizar, btnEliminarPerfil, btnRegresar;
    AdminSQLiteOpenHelper db;
    String usuarioOriginal;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        etPidUsuario = findViewById(R.id.etPidUsuario);
        etPerfilUsuario = findViewById(R.id.etPUsuario);
        etPerfilContra = findViewById(R.id.etPContra);
        btnActualizar = findViewById(R.id.btnActualizar);
        btnEliminarPerfil = findViewById(R.id.btnEliminarP);
        btnRegresar = findViewById(R.id.btnRegresar);

        db = new AdminSQLiteOpenHelper(this);
        usuarioOriginal = getIntent().getStringExtra("usuario");

        cargarDatosUsuario();

        btnActualizar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                //String nuevoidUsuario = etPidUsuario.getText().toString();
                String nuevoUsuario = etPerfilUsuario.getText().toString();
                String nuevaContra= etPerfilContra.getText().toString();

                boolean actualizado = db.actualizarUsuario(usuarioOriginal, nuevoUsuario, nuevaContra);

                if (actualizado) {
                    Toast.makeText(Perfil.this, "Perfil actualizado", Toast.LENGTH_SHORT).show();
                    usuarioOriginal = nuevoUsuario;
                } else {
                    Toast.makeText(Perfil.this, "Error al actualizar", Toast.LENGTH_SHORT).show();
                }
            }            
        });

        btnEliminarPerfil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                boolean eliminado = db.borrarUsuario(usuarioOriginal);
                if (eliminado) {
                    Toast.makeText(Perfil.this, "Perfil eliminado", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Perfil.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                } else {
                    Toast.makeText(Perfil.this, "Error al eliminar", Toast.LENGTH_SHORT).show();
                }   
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Perfil.this, MenuPrincipalTemas.class);
                startActivity(intent);
            }
        });

    }

    private void cargarDatosUsuario() {
        Cursor cursor = db.getUserioDatos(usuarioOriginal);
        if (cursor.moveToFirst()) {
            etPidUsuario.setText(cursor.getString(cursor.getColumnIndexOrThrow("idUsuario")));
            etPerfilUsuario.setText(cursor.getString(cursor.getColumnIndexOrThrow("usuario")));
            etPerfilContra.setText(cursor.getString(cursor.getColumnIndexOrThrow("contrasenia")));
        }
    }
}