package com.example.echivambo.livroregistoec.model;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class DadosPessoais {
    private String nome;
    private String sexo;
    private String faixa_etaria;
    private String residencia;
    private String contacto;
    private String codigo_consulta;
    private int status;
    private int user_id;

    public DadosPessoais() {
    }

    public DadosPessoais(String nome, String sexo, String faixa_etaria, String residencia, String contacto, String codigo_consulta, int status, int user_id) {
        this.nome = nome;
        this.sexo = sexo;
        this.faixa_etaria = faixa_etaria;
        this.residencia = residencia;
        this.contacto = contacto;
        this.codigo_consulta = codigo_consulta;
        this.status = status;
        this.user_id = user_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFaixa_etaria() {
        return faixa_etaria;
    }

    public void setFaixa_etaria(String faixa_etaria) {
        this.faixa_etaria = faixa_etaria;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getCodigo_consulta() {
        return codigo_consulta;
    }

    public void setCodigo_consulta(String codigo_consulta) {
        this.codigo_consulta = codigo_consulta;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("nome", nome);
        result.put("codigo_consulta", codigo_consulta);
        result.put("sexo", sexo);
        result.put("faixa_etaria", faixa_etaria);
        result.put("residencia", residencia);
        result.put("contacto", contacto);
        result.put("user_id", user_id);

        return result;
    }
}
