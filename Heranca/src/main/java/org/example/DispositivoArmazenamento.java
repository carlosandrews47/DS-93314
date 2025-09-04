package org.example;

/**
 * Dispositivo de Armazenamento ( Marca, Modelo, Capacidade, Tipo de conexão)
 */
public class DispositivoArmazenamento extends Componente {
    private int capacidadeGB;
    private String tipoConexao; // SATA / NVMe / USB / etc

    public DispositivoArmazenamento(String marca, String modelo, int capacidadeGB, String tipoConexao) {
        super(marca, modelo);
        this.capacidadeGB = capacidadeGB;
        this.tipoConexao = tipoConexao;
    }

    public int getCapacidadeGB() { return capacidadeGB; }
    public String getTipoConexao() { return tipoConexao; }

    @Override
    public String descricao() {
        return "Dispositivo: " + marca + " " + modelo + " - " + capacidadeGB + " GB (" + tipoConexao + ")";
    }

    @Override
    public String toString() { return descricao(); }
}
