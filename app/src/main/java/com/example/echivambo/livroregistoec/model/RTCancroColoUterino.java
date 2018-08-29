package com.example.echivambo.livroregistoec.model;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class RTCancroColoUterino {
    private String fez_exameme_de_via;
    private String resultado;
    private String crioterapia;
    private String transferida;
    private String codigo_consulta;
    private int status;
    private int user_id;

    public RTCancroColoUterino() {
    }


    public RTCancroColoUterino(String fez_exameme_de_via, String resultado, String crioterapia, String transferida, String codigo_consulta, int status, int user_id) {
        this.fez_exameme_de_via = fez_exameme_de_via;
        this.resultado = resultado;
        this.crioterapia = crioterapia;
        this.transferida = transferida;
        this.codigo_consulta = codigo_consulta;
        this.status = status;
        this.user_id = user_id;
    }

    public String getFez_exameme_de_via() {
        return fez_exameme_de_via;
    }

    public void setFez_exameme_de_via(String fez_exameme_de_via) {
        this.fez_exameme_de_via = fez_exameme_de_via;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getCrioterapia() {
        return crioterapia;
    }

    public void setCrioterapia(String crioterapia) {
        this.crioterapia = crioterapia;
    }

    public String getTransferida() {
        return transferida;
    }

    public void setTransferida(String transferida) {
        this.transferida = transferida;
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
        result.put("fez_exameme_de_via", fez_exameme_de_via);
        result.put("resultado", resultado);
        result.put("crioterapia", crioterapia);
        result.put("transferida", transferida);
        result.put("codigo_consulta", codigo_consulta);
        result.put("user_id", user_id);

        return result;
    }
}
