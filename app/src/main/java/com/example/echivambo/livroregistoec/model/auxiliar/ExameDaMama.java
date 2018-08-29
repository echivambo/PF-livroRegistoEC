package com.example.echivambo.livroregistoec.model.auxiliar;

public class ExameDaMama {
    private String tipo_exame_da_mama;
    private String tratado;

    public ExameDaMama() {
    }

    public ExameDaMama(String tipo_exame_da_mama, String tratado) {
        this.tipo_exame_da_mama = tipo_exame_da_mama;
        this.tratado = tratado;
    }

    public String getTipo_exame_da_mama() {
        return tipo_exame_da_mama;
    }

    public void setTipo_exame_da_mama(String tipo_exame_da_mama) {
        this.tipo_exame_da_mama = tipo_exame_da_mama;
    }

    public String getTratado() {
        return tratado;
    }

    public void setTratado(String tratado) {
        this.tratado = tratado;
    }
}
