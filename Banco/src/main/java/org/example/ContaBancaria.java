public class ContaBancaria {

    private final String banco;
    private final String agencia;
    private final String numeroConta;
    private final String tipoConta;
    private double saldoAtual;
    private double limiteDisponivel;

    public ContaBancaria(String banco, String agencia, String numeroConta,
                         String tipoConta, double saldoInicial, double limiteDisponivel) {
        this.banco = banco;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
        this.saldoAtual = saldoInicial;
        this.limiteDisponivel = limiteDisponivel;
    }

    public String getBanco() {
        return banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public double getSaldoAtual() {
        return saldoAtual;
    }

    public double getLimiteDisponivel() {
        return limiteDisponivel;
    }

    public double getSaldoTotalDisponivel() {
        return saldoAtual + limiteDisponivel;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldoAtual += valor;
            System.out.printf("Depósito de R$ %.2f realizado com sucesso.%n", valor);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= getSaldoTotalDisponivel()) {
            saldoAtual -= valor;
            System.out.printf("Saque de R$ %.2f realizado com sucesso.%n", valor);
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para saque.");
            return false;
        }
    }

    public void transferir(ContaBancaria destino, double valor) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            System.out.printf("Transferência de R$ %.2f realizada para conta %s.%n",
                    valor, destino.getNumeroConta());
        }
    }

    public void exibirExtrato() {
        System.out.println("\n=== EXTRATO BANCÁRIO ===");
        System.out.println("Banco: " + banco);
        System.out.println("Agência: " + agencia);
        System.out.println("Conta: " + numeroConta);
        System.out.println("Tipo: " + tipoConta);
        System.out.printf("Saldo atual: R$ %.2f%n", saldoAtual);
        System.out.printf("Limite disponível: R$ %.2f%n", limiteDisponivel);
        System.out.printf("Saldo total: R$ %.2f%n", getSaldoTotalDisponivel());
    }

    @Override
    public String toString() {
        return String.format("Banco: %s | Agência: %s | Conta: %s | Tipo: %s | Saldo: R$ %.2f | Limite: R$ %.2f",
                banco, agencia, numeroConta, tipoConta, saldoAtual, limiteDisponivel);
    }
}