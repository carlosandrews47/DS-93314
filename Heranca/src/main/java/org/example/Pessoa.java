package org.example;

/**
 * <<abstract>> Pessoa
 * - representa o modelo "Pessoa" dos slides com atributos comuns.
 * - uso de 'protected' para mostrar o modificador explicado (acesso por subclasses).
 */
public abstract class Pessoa {
    // conforme o slide: # nome : String, # telefone : String
    protected String nome;      // protected para que subclasses acessem direto (ex.: Engenheiro)
    protected String telefone;

    public Pessoa(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    // Getters (boas práticas: mesmo usando protected, fornecemos getters)
    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }

    // Método abstrato: força as subclasses a definirem seu "tipo" ou descrição
    public abstract String getTipo();

    @Override
    public String toString() {
        return "Nome: " + nome + " | Telefone: " + telefone;
    }
}
