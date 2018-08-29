package com.example.echivambo.livroregistoec.model;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class RHIVSeguimento {
    private String seroestado_a_entrada_1a_csr_pf;
    private String teste_de_hiv_na_consulta_de_csr;
    private String tarv;
    private String testagem_do_parceiro;
    private String codigo_consulta;
    private int status;
    private int user_id;

    public RHIVSeguimento() {
    }

    public RHIVSeguimento(String seroestado_a_entrada_1a_csr_pf, String teste_de_hiv_na_consulta_de_csr, String tarv, String testagem_do_parceiro, String codigo_consulta, int status, int user_id) {
        this.seroestado_a_entrada_1a_csr_pf = seroestado_a_entrada_1a_csr_pf;
        this.teste_de_hiv_na_consulta_de_csr = teste_de_hiv_na_consulta_de_csr;
        this.tarv = tarv;
        this.testagem_do_parceiro = testagem_do_parceiro;
        this.codigo_consulta = codigo_consulta;
        this.status = status;
        this.user_id = user_id;
    }

    public String getSeroestado_a_entrada_1a_csr_pf() {
        return seroestado_a_entrada_1a_csr_pf;
    }

    public void setSeroestado_a_entrada_1a_csr_pf(String seroestado_a_entrada_1a_csr_pf) {
        this.seroestado_a_entrada_1a_csr_pf = seroestado_a_entrada_1a_csr_pf;
    }

    public String getTeste_de_hiv_na_consulta_de_csr() {
        return teste_de_hiv_na_consulta_de_csr;
    }

    public void setTeste_de_hiv_na_consulta_de_csr(String teste_de_hiv_na_consulta_de_csr) {
        this.teste_de_hiv_na_consulta_de_csr = teste_de_hiv_na_consulta_de_csr;
    }

    public String getTarv() {
        return tarv;
    }

    public void setTarv(String tarv) {
        this.tarv = tarv;
    }

    public String getTestagem_do_parceiro() {
        return testagem_do_parceiro;
    }

    public void setTestagem_do_parceiro(String testagem_do_parceiro) {
        this.testagem_do_parceiro = testagem_do_parceiro;
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
        result.put("seroestado_a_entrada_1a_csr_pf", seroestado_a_entrada_1a_csr_pf);
        result.put("teste_de_hiv_na_consulta_de_csr", teste_de_hiv_na_consulta_de_csr);
        result.put("tarv", tarv);
        result.put("testagem_do_parceiro", testagem_do_parceiro);
        result.put("codigo_consulta", codigo_consulta);
        result.put("user_id", user_id);

        return result;
    }
}
