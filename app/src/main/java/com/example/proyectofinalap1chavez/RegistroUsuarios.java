package com.example.proyectofinalap1chavez;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.LENGTH_SHORT;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class RegistroUsuarios extends AppCompatActivity {
    private Button btnCancelar, btnRegistrar;
    private EditText etRUsuario, etRNonbre, etRContra;
    AdminSQLiteOpenHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);
        db = new AdminSQLiteOpenHelper(this);
        etRNonbre = findViewById(R.id.etRNombre);
        etRUsuario = findViewById(R.id.etRUsuario);
        etRContra = findViewById(R.id.etRContra);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnCancelar=findViewById(R.id.btnCancelar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String usuario = etRUsuario.getText().toString();
                String contra = etRContra.getText().toString();

                if (usuario.isEmpty() || contra.isEmpty() )
                    Toast.makeText(RegistroUsuarios.this, "Completa todos los campos", Toast.LENGTH_LONG).show();
                else {
                    boolean success = db.registrarUsuario(usuario, contra);
                    if (success) {
                        Toast.makeText(RegistroUsuarios.this, "Usuario registrado con exito", Toast.LENGTH_LONG).show();
                        finish(); // vuelve a Login
                    } else {
                        Toast.makeText(RegistroUsuarios.this, "Error al registrar usuario", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(RegistroUsuarios.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}