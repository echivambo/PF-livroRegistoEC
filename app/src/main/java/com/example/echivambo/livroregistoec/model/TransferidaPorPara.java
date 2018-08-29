package com.example.echivambo.livroregistoec.model;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class TransferidaPorPara {
    private String transferida_por_para;
    private String observacao;
    private String codigo_consulta;
    private int status;
    private int user_id;

    public TransferidaPorPara() {
    }

    public TransferidaPorPara(String transferida_por_para, String observacao, String codigo_consulta, int status, int user_id) {
        this.transferida_por_para = transferida_por_para;
        this.observacao = observacao;
        this.codigo_consulta = codigo_consulta;
        this.status = status;
        this.user_id = user_id;
    }

    public String getTransferida_por_para() {
        return transferida_por_para;
    }

    public void setTransferida_por_para(String transferida_por_para) {
        this.transferida_por_para = transferida_por_para;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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
        result.put("transferida_por_para", transferida_por_para);
        result.put("observacao", observacao);
        result.put("codigo_consulta", codigo_consulta);
        result.put("user_id", user_id);

        return result;
    }
}
