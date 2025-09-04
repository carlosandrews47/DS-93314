public class Livro {

    private final String titulo;
    private final String autor;
    private final int numeroPaginas;
    private final double preco;
    private final String isbn;

    public Livro(String titulo, String autor, int numeroPaginas, double preco, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.preco = preco;
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public double getPreco() {
        return preco;
    }

    public String getIsbn() {
        return isbn;
    }

    public double calcularTotal(int quantidade) {
        return preco * quantidade;
    }

    @Override
    public String toString() {
        return String.format("Título: %s | Autor: %s | Páginas: %d | Preço: R$ %.2f | ISBN: %s",
                titulo, autor, numeroPaginas, preco, isbn);
    }
 }