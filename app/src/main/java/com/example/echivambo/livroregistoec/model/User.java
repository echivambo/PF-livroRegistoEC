package com.example.echivambo.livroregistoec.model;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class User {
    private String nome;
    private String usuario;
    private String password;
    private String grupo;
    private int provincia_id;
    private int distrito_id;

    public User() {
    }


    public User(String nome, String usuario, String grupo, int provincia_id, int distrito_id) {
        this.nome = nome;
        this.usuario = usuario;
        this.grupo = grupo;
        this.provincia_id = provincia_id;
        this.distrito_id = distrito_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String email) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getProvincia_id() {
        return provincia_id;
    }

    public void setProvincia_id(int provincia_id) {
        this.provincia_id = provincia_id;
    }

    public int getDistrito_id() {
        return distrito_id;
    }

    public void setDistrito_id(int distrito_id) {
        this.distrito_id = distrito_id;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("nome", nome);
        result.put("usuario", usuario);
        result.put("password", password);
        result.put("grupo", grupo);
        result.put("provincia_id", provincia_id);
        result.put("distrito_id", distrito_id);

        return result;
    }
}
