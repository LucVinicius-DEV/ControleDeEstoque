import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();

        // Criação do formato de moeda
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance();

        int opcao;

        do {
            System.out.println("\n===== CONTROLE DE ESTOQUE =====");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Listar produtos");
            System.out.println("3. Atualizar produto");
            System.out.println("4. Remover produto");
            System.out.println("5. Exibir valor total do estoque");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.print("Preço do produto: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Quantidade em estoque: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine();

                    Produto novoProduto = new Produto(nome, preco, quantidade);
                    produtos.add(novoProduto);
                    System.out.println("Produto cadastrado com sucesso!");
                    break;

                case 2:
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        System.out.println("\n--- Lista de Produtos ---");
                        for (int i = 0; i < produtos.size(); i++) {
                            System.out.println((i + 1) + ". " + produtos.get(i).toStringFormatado(formatoMoeda));
                        }
                    }
                    break;

                case 3:
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto para atualizar.");
                        break;
                    }

                    System.out.println("\n--- Produtos disponíveis ---");
                    for (int i = 0; i < produtos.size(); i++) {
                        System.out.println((i + 1) + ". " + produtos.get(i).toStringFormatado(formatoMoeda));
                    }

                    System.out.print("Digite o número do produto que deseja atualizar: ");
                    int indice = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (indice < 0 || indice >= produtos.size()) {
                        System.out.println("Produto inválido.");
                        break;
                    }

                    Produto produtoAtual = produtos.get(indice);

                    System.out.print("Novo preço (atual: " + produtoAtual.getPreco() + "): ");
                    double novoPreco = scanner.nextDouble();
                    scanner.nextLine();
                    produtoAtual.setPreco(novoPreco);

                    System.out.print("Nova quantidade (atual: " + produtoAtual.getQuantidade() + "): ");
                    int novaQuantidade = scanner.nextInt();
                    scanner.nextLine();
                    produtoAtual.setQuantidade(novaQuantidade);

                    System.out.println("Produto atualizado com sucesso!");
                    break;

                case 4:
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto para remover.");
                        break;
                    }

                    System.out.println("\n--- Produtos disponíveis ---");
                    for (int i = 0; i < produtos.size(); i++) {
                        System.out.println((i + 1) + ". " + produtos.get(i).toStringFormatado(formatoMoeda));
                    }

                    System.out.print("Digite o número do produto que deseja remover: ");
                    int removerIndice = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (removerIndice < 0 || removerIndice >= produtos.size()) {
                        System.out.println("Produto inválido.");
                        break;
                    }

                    Produto removido = produtos.remove(removerIndice);
                    System.out.println("Produto \"" + removido.getNome() + "\" removido com sucesso!");
                    break;

                case 5:
                    double valorTotalEstoque = 0;
                    for (Produto produto : produtos) {
                        valorTotalEstoque += produto.calcularValorTotal();
                    }
                    System.out.printf("Valor total do estoque: R$%.2f\n", valorTotalEstoque);
                    break;

                case 6:
                    System.out.println("Saindo... Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 6);

        scanner.close();
    }
}
