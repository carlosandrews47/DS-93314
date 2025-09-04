package org.example;

public class Endereco {
    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;
    private String cidade;

    public Endereco(String logradouro, String numero, String complemento, String cep, String cidade) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
    }

    // Getters
    public String getLogradouro() { return logradouro; }
    public String getNumero() { return numero; }
    public String getComplemento() { return complemento; }
    public String getCep() { return cep; }
    public String getCidade() { return cidade; }

    @Override
    public String toString() {
        return logradouro + ", " + numero + (complemento == null || complemento.isBlank() ? "" : " (" + complemento + ")")
                + " - " + cidade + " CEP: " + cep;
    }
}
