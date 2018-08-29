package com.example.echivambo.livroregistoec.model;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class RTSiflis {
    private String estado_a_entrada_na_csr_pf;
    private String resultado_do_teste_feito_na_csr_pf;
    private String tratamento_do_utente_dose_recebida;
    private String parceiro_recebeu_tratamento_na_csr_pf;
    private String codigo_consulta;
    private int status;
    private int user_id;

    public RTSiflis() {
    }

    public RTSiflis(String estado_a_entrada_na_csr_pf, String resultado_do_teste_feito_na_csr_pf, String tratamento_do_utente_dose_recebida, String parceiro_recebeu_tratamento_na_csr_pf, String codigo_consulta, int status, int user_id) {
        this.estado_a_entrada_na_csr_pf = estado_a_entrada_na_csr_pf;
        this.resultado_do_teste_feito_na_csr_pf = resultado_do_teste_feito_na_csr_pf;
        this.tratamento_do_utente_dose_recebida = tratamento_do_utente_dose_recebida;
        this.parceiro_recebeu_tratamento_na_csr_pf = parceiro_recebeu_tratamento_na_csr_pf;
        this.codigo_consulta = codigo_consulta;
        this.status = status;
        this.user_id = user_id;
    }

    public String getEstado_a_entrada_na_csr_pf() {
        return estado_a_entrada_na_csr_pf;
    }

    public void setEstado_a_entrada_na_csr_pf(String estado_a_entrada_na_csr_pf) {
        this.estado_a_entrada_na_csr_pf = estado_a_entrada_na_csr_pf;
    }

    public String getResultado_do_teste_feito_na_csr_pf() {
        return resultado_do_teste_feito_na_csr_pf;
    }

    public void setResultado_do_teste_feito_na_csr_pf(String resultado_do_teste_feito_na_csr_pf) {
        this.resultado_do_teste_feito_na_csr_pf = resultado_do_teste_feito_na_csr_pf;
    }

    public String getTratamento_do_utente_dose_recebida() {
        return tratamento_do_utente_dose_recebida;
    }

    public void setTratamento_do_utente_dose_recebida(String tratamento_do_utente_dose_recebida) {
        this.tratamento_do_utente_dose_recebida = tratamento_do_utente_dose_recebida;
    }

    public String getParceiro_recebeu_tratamento_na_csr_pf() {
        return parceiro_recebeu_tratamento_na_csr_pf;
    }

    public void setParceiro_recebeu_tratamento_na_csr_pf(String parceiro_recebeu_tratamento_na_csr_pf) {
        this.parceiro_recebeu_tratamento_na_csr_pf = parceiro_recebeu_tratamento_na_csr_pf;
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
        result.put("estado_a_entrada_na_csr_pf", estado_a_entrada_na_csr_pf);
        result.put("resultado_do_teste_feito_na_csr_pf", resultado_do_teste_feito_na_csr_pf);
        result.put("tratamento_do_utente_dose_recebida", tratamento_do_utente_dose_recebida);
        result.put("parceiro_recebeu_tratamento_na_csr_pf", parceiro_recebeu_tratamento_na_csr_pf);
        result.put("codigo_consulta", codigo_consulta);
        result.put("user_id", user_id);

        return result;
    }
}
