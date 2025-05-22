package com.example.proyectofinalap1chavez;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnAlta, btnIniSesion;
    private EditText etUsuario, etContra;
    AdminSQLiteOpenHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db= new AdminSQLiteOpenHelper(this);
       btnAlta = findViewById(R.id.btnAlta);
       etUsuario = findViewById(R.id.etUsuario);
       etContra =  findViewById(R.id.etContra);
       btnIniSesion = findViewById(R.id.btnInicioSesion);

        btnIniSesion.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String usuario = etUsuario.getText().toString();
               String constrasenia = etContra.getText().toString();

               Cursor cursor = db. loginUsuario(usuario, constrasenia);
               if (cursor.getCount() > 0) {
                   Toast.makeText(MainActivity.this, "Login exitoso", Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent( MainActivity.this, MenuPrincipalTemas.class);
                   intent.putExtra("usuario", usuario); // pasa el nombre al menú
                   startActivity(intent);
               } else {
                   Toast.makeText(MainActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
               }

           }
       });

       btnAlta.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, RegistroUsuarios.class);
            startActivity(intent);
        }
       });
    }

}