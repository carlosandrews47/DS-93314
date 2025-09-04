public class Veiculo {

    private final String placa;
    private final String cor;
    private final double capacidadeTanque;
    private final double velocidadeMaxima;
    private final double consumoMedio;

    public Veiculo(String placa, String cor, double capacidadeTanque,
                   double velocidadeMaxima, double consumoMedio) {
        this.placa = placa;
        this.cor = cor;
        this.capacidadeTanque = capacidadeTanque;
        this.velocidadeMaxima = velocidadeMaxima;
        this.consumoMedio = consumoMedio;
    }

    public String getPlaca() {
        return placa;
    }

    public String getCor() {
        return cor;
    }

    public double getCapacidadeTanque() {
        return capacidadeTanque;
    }

    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public double getConsumoMedio() {
        return consumoMedio;
    }

    public double calcularAutonomia() {
        return capacidadeTanque * consumoMedio;
    }

    @Override
    public String toString() {
        return String.format("Placa: %s | Cor: %s | Capacidade do Tanque: %.1fL | " +
                        "Velocidade Máxima: %.1fkm/h | Consumo Médio: %.1fkm/L",
                placa, cor, capacidadeTanque, velocidadeMaxima, consumoMedio);
    }
 }
