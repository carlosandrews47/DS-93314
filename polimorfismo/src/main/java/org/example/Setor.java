package org.example;

/**
 * Enum que representa os setores/departamentos da empresa
 * Cada setor possui um nome descritivo para melhor visualização
 */
public enum Setor {

    OPERACOES("Operações"),
    FINANCEIRO("Financeiro"),
    ADMINISTRATIVO("Administrativo"),
    RECURSOS_HUMANOS("Recursos Humanos"),
    VENDAS("Vendas"),
    TI("Tecnologia da Informação"),
    MARKETING("Marketing"),
    PRODUCAO("Produção"),
    JURIDICO("Jurídico"),
    COMERCIAL("Comercial");

    private final String nome;

    /**
     * Construtor do enum Setor
     * @param nome Nome descritivo do setor
     */
    Setor(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o nome descritivo do setor
     * @return Nome do setor
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sobrescreve o método toString para retornar o nome do setor
     * @return Nome do setor
     */
    @Override
    public String toString() {
        return nome;
    }
}