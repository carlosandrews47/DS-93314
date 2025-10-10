package com.example.aula10.dto;


public class RespostaApi {
    private boolean sucesso;
    private String mensagem;
    private Object dados;

    public RespostaApi(boolean sucesso, String mensagem) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
    }

    public RespostaApi(boolean sucesso, String mensagem, Object dados) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
        this.dados = dados;
    }

    // Getters e Setters
    public boolean isSucesso() { return sucesso; }
    public void setSucesso(boolean sucesso) { this.sucesso = sucesso; }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }

    public Object getDados() { return dados; }
    public void setDados(Object dados) { this.dados = dados; }
}

