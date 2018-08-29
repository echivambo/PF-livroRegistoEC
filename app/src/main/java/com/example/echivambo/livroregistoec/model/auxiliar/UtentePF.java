package com.example.echivambo.livroregistoec.model.auxiliar;

public class UtentePF {
    private String nome;
    private String nidcsr;
    private String nidtarv;
    private String codigo;

    public UtentePF() {
    }

    public UtentePF(String nome, String nidcsr, String nidtarv, String codigo) {
        this.nome = nome;
        this.nidcsr = nidcsr;
        this.nidtarv = nidtarv;
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNidcsr() {
        return nidcsr;
    }

    public void setNidcsr(String nidcsr) {
        this.nidcsr = nidcsr;
    }

    public String getNidtarv() {
        return nidtarv;
    }

    public void setNidtarv(String nidtarv) {
        this.nidtarv = nidtarv;
    }
}
