import java.time.LocalDate;

public class Motoboy extends Funcionario {
    private String registro;

    public Motoboy(String nome, String cpf, LocalDate dataNascimento, Genero genero, Setor setor, double salarioBase, String registro) {
        super(nome, cpf, genero, setor, salarioBase, dataNascimento, dataNascimento); // dataAdmissao igual a dataNascimento se não tiver outro
        this.registro = registro;
    }

    public String getRegistro() {
        return registro;
    }

    @Override
    public double getSalarioFinal() {
        return getSalarioBase(); // Sem bonificação
    }

    @Override
    public String toString() {
        return "Motoboy{" +
                "nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", genero=" + getGenero() +
                ", salarioBase=" + getSalarioBase() +
                ", salarioFinal=" + getSalarioFinal() +
                ", registro='" + registro + '\'' +
                '}';
    }
}