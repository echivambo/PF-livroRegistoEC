package com.example.echivambo.livroregistoec.model;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class Cabecalho {
    private String data_consulta;
    private String codigo_consulta;
    private int numero_consulta;
    private String nid_csr_pf;
    private String nid_tarv;
    private String parceiro_presente_na_csr_pf;
    private int status;
    private int user_id;

    public Cabecalho() {
    }

    public Cabecalho(String data_consulta, String codigo_consulta, int numero_consulta, String nid_csr_pf, String nid_tarv, String parceiro_presente_na_csr_pf, int status, int user_id) {
        this.data_consulta = data_consulta;
        this.codigo_consulta = codigo_consulta;
        this.numero_consulta = numero_consulta;
        this.nid_csr_pf = nid_csr_pf;
        this.nid_tarv = nid_tarv;
        this.parceiro_presente_na_csr_pf = parceiro_presente_na_csr_pf;
        this.status = status;
        this.user_id = user_id;
    }

    public String getData_consulta() {
        return data_consulta;
    }

    public void setData_consulta(String data_consulta) {
        this.data_consulta = data_consulta;
    }

    public String getCodigo_consulta() {
        return codigo_consulta;
    }

    public void setCodigo_consulta(String codigo_consulta) {
        this.codigo_consulta = codigo_consulta;
    }

    public int getNumero_consulta() {
        return numero_consulta;
    }

    public void setNumero_consulta(int numero_consulta) {
        this.numero_consulta = numero_consulta;
    }

    public String getNid_csr_pf() {
        return nid_csr_pf;
    }

    public void setNid_csr_pf(String nid_csr_pf) {
        this.nid_csr_pf = nid_csr_pf;
    }

    public String getNid_tarv() {
        return nid_tarv;
    }

    public void setNid_tarv(String nid_tarv) {
        this.nid_tarv = nid_tarv;
    }

    public String getParceiro_presente_na_csr_pf() {
        return parceiro_presente_na_csr_pf;
    }

    public void setParceiro_presente_na_csr_pf(String parceiro_presente_na_csr_pf) {
        this.parceiro_presente_na_csr_pf = parceiro_presente_na_csr_pf;
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
        result.put("data_consulta", data_consulta);
        result.put("codigo_consulta", codigo_consulta);
        result.put("numero_consulta", numero_consulta);
        result.put("nid_csr_pf", nid_csr_pf);
        result.put("nid_tarv", nid_tarv);
        result.put("parceiro_presente_na_csr_pf", parceiro_presente_na_csr_pf);
        result.put("user_id", user_id);

        return result;
    }

}
