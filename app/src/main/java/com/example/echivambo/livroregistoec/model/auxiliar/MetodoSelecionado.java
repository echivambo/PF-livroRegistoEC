package com.example.echivambo.livroregistoec.model.auxiliar;

public class MetodoSelecionado {
    private String estadoUsuario;
    private String metodo;
    private String tipoMetodo;
    private int quantidadeDistribuida;

    public MetodoSelecionado(String estadoUsuario, String metodo, String tipoMetodo, int quantidadeDistribuida) {
        this.estadoUsuario = estadoUsuario;
        this.metodo = metodo;
        this.tipoMetodo = tipoMetodo;
        this.quantidadeDistribuida = quantidadeDistribuida;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getTipoMetodo() {
        return tipoMetodo;
    }

    public void setTipoMetodo(String tipoMetodo) {
        this.tipoMetodo = tipoMetodo;
    }

    public int getQuantidadeDistribuida() {
        return quantidadeDistribuida;
    }

    public void setQuantidadeDistribuida(int quantidadeDistribuida) {
        this.quantidadeDistribuida = quantidadeDistribuida;
    }
}
