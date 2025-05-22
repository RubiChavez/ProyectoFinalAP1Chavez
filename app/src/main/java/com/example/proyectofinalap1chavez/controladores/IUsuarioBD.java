package com.example.proyectofinalap1chavez.controladores;

import com.example.proyectofinalap1chavez.modelos.Usuario;

import java.util.List;

public interface IUsuarioBD {

    Usuario elemento(int idUsuario);
   // Usuario elemento(String nombre);
    Usuario elemento(String usuario);
    //Usuario elemento(String contra);

    List<Usuario> lista();

    void agregar(Usuario usuario);
    void actializar(int idUsuario, Usuario usuario);

    void borrar(int idUsuario);
}
