package com.example.echivambo.livroregistoec.model;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class ExameClinico {
    private String rastreio_e_tratamento_de_its;
    private String outras_patologias;
    private String fez_exame_clinico_da_mama;
    private String exame_clinico_da_mama;
    private String tratado;
    private String transferida;
    private String codigo_consulta;
    private int status;
    private int user_id;

    public ExameClinico() {
    }

    public ExameClinico(String rastreio_e_tratamento_de_its, String outras_patologias, String fez_exame_clinico_da_mama, String exame_clinico_da_mama, String tratado, String transferida, String codigo_consulta, int status, int user_id) {
        this.rastreio_e_tratamento_de_its = rastreio_e_tratamento_de_its;
        this.outras_patologias = outras_patologias;
        this.fez_exame_clinico_da_mama = fez_exame_clinico_da_mama;
        this.exame_clinico_da_mama = exame_clinico_da_mama;
        this.tratado = tratado;
        this.transferida = transferida;
        this.codigo_consulta = codigo_consulta;
        this.status = status;
        this.user_id = user_id;
    }

    public String getRastreio_e_tratamento_de_its() {
        return rastreio_e_tratamento_de_its;
    }

    public void setRastreio_e_tratamento_de_its(String rastreio_e_tratamento_de_its) {
        this.rastreio_e_tratamento_de_its = rastreio_e_tratamento_de_its;
    }

    public String getOutras_patologias() {
        return outras_patologias;
    }

    public void setOutras_patologias(String outras_patologias) {
        this.outras_patologias = outras_patologias;
    }

    public String getFez_exame_clinico_da_mama() {
        return fez_exame_clinico_da_mama;
    }

    public void setFez_exame_clinico_da_mama(String fez_exame_clinico_da_mama) {
        this.fez_exame_clinico_da_mama = fez_exame_clinico_da_mama;
    }

    public String getExame_clinico_da_mama() {
        return exame_clinico_da_mama;
    }

    public void setExame_clinico_da_mama(String exame_clinico_da_mama) {
        this.exame_clinico_da_mama = exame_clinico_da_mama;
    }

    public String getTratado() {
        return tratado;
    }

    public void setTratado(String tratado) {
        this.tratado = tratado;
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
        result.put("rastreio_e_tratamento_de_its", rastreio_e_tratamento_de_its);
        result.put("outras_patologias", outras_patologias);
        result.put("fez_exame_clinico_da_mama", fez_exame_clinico_da_mama);
        result.put("exame_clinico_da_mama", exame_clinico_da_mama);
        result.put("tratado", tratado);
        result.put("transferida", transferida);
        result.put("codigo_consulta", codigo_consulta);
        result.put("user_id", user_id);

        return result;
    }
}
