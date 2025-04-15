import java.text.NumberFormat;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        setPreco(preco);  // Usa o setPreco para evitar valores negativos
        setQuantidade(quantidade);  // Mesma coisa para a quantidade
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setPreco(double preco) {
        if (preco >= 0) {
            this.preco = preco;
        } else {
            System.out.println("Preço não pode ser negativo.");
        }
    }

    public void setQuantidade(int quantidade) {
        if (quantidade >= 0) {
            this.quantidade = quantidade;
        } else {
            System.out.println("Quantidade não pode ser negativa.");
        }
    }

    public double calcularValorTotal() {
        return preco * quantidade;
    }

    public String toStringFormatado(NumberFormat formatoMoeda) {
        return "Produto: " + nome + " | Preço: " + formatoMoeda.format(preco) + " | Quantidade: " + quantidade;
    }

    @Override
    public String toString() {
        return "Produto: " + nome + " | Preço: R$" + preco + " | Quantidade: " + quantidade;
    }
}
