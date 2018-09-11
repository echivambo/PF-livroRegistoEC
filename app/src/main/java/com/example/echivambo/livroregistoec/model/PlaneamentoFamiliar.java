package com.example.echivambo.livroregistoec.model;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class PlaneamentoFamiliar {
    private String utente_pf;
    private String metodo_do_pf;
    private String tipo_do_metodo_do_pf;
    private String estado_da_utente_no_metodo;
    private int total_distribuido;
    private String metodo_anterior;
    private String codigo_consulta;
    private int status;
    private String user_id;

    public PlaneamentoFamiliar() {
    }

    public PlaneamentoFamiliar(String utente_pf, String metodo_do_pf, String tipo_do_metodo_do_pf, String estado_da_utente_no_metodo, int total_distribuido, String metodo_anterior, String codigo_consulta, int status, String user_id) {
        this.utente_pf = utente_pf;
        this.metodo_do_pf = metodo_do_pf;
        this.tipo_do_metodo_do_pf = tipo_do_metodo_do_pf;
        this.estado_da_utente_no_metodo = estado_da_utente_no_metodo;
        this.total_distribuido = total_distribuido;
        this.metodo_anterior = metodo_anterior;
        this.codigo_consulta = codigo_consulta;
        this.status = status;
        this.user_id = user_id;
    }

    public String getUtente_pf() {
        return utente_pf;
    }

    public void setUtente_pf(String utente_pf) {
        this.utente_pf = utente_pf;
    }

    public String getMetodo_do_pf() {
        return metodo_do_pf;
    }

    public void setMetodo_do_pf(String metodo_do_pf) {
        this.metodo_do_pf = metodo_do_pf;
    }

    public String getTipo_do_metodo_do_pf() {
        return tipo_do_metodo_do_pf;
    }

    public void setTipo_do_metodo_do_pf(String tipo_do_metodo_do_pf) {
        this.tipo_do_metodo_do_pf = tipo_do_metodo_do_pf;
    }

    public String getEstado_da_utente_no_metodo() {
        return estado_da_utente_no_metodo;
    }

    public void setEstado_da_utente_no_metodo(String estado_da_utente_no_metodo) {
        this.estado_da_utente_no_metodo = estado_da_utente_no_metodo;
    }

    public int getTotal_distribuido() {
        return total_distribuido;
    }

    public void setTotal_distribuido(int total_distribuido) {
        this.total_distribuido = total_distribuido;
    }

    public String getMetodo_anterior() {
        return metodo_anterior;
    }

    public void setMetodo_anterior(String metodo_anterior) {
        this.metodo_anterior = metodo_anterior;
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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("utente_pf", utente_pf);
        result.put("metodo_do_pf", metodo_do_pf);
        result.put("tipo_do_metodo_do_pf", tipo_do_metodo_do_pf);
        result.put("estado_da_utente_no_metodo", estado_da_utente_no_metodo);
        result.put("total_distribuido", total_distribuido);
        result.put("metodo_anterior", metodo_anterior);
        result.put("codigo_consulta", codigo_consulta);
        result.put("user_id", user_id);

        return result;
    }
}
