import java.util.ArrayList;

class CategoriaProduto {
    private String nome;
    private ArrayList<Produto> produtos;

    public CategoriaProduto(String nome) {
        this.nome = nome;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void listarProdutos() {
        System.out.println("Categoria: " + nome);
        for (Produto p : produtos) {
            p.exibirDetalhes();
        }
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public String getNome() {
        return nome;
    }
}

class Produto {
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;

    public Produto(String nome, double preco, int quantidadeEmEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public boolean decrementarEstoque(int qtd) {
        if (qtd <= quantidadeEmEstoque) {
            quantidadeEmEstoque -= qtd;
            return true;
        } else {
            System.out.println("Estoque insuficiente para " + nome);
            return false;
        }
    }

    public void exibirDetalhes() {
        System.out.println(nome + " - R$ " + preco + " - Estoque: " + quantidadeEmEstoque + " unidades");
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }
}

class Cliente {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    public Cliente(String nome, String cpf, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
    }

    public void exibirInformacoes() {
        System.out.println("Cliente: " + nome + " - CPF: " + cpf + " - Email: " + email);
    }

    public String getNome() {
        return nome;
    }
}

class Pedido {
    private Cliente cliente;
    private ArrayList<ItemPedido> itens;
    private double total;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.total = 0;
    }

    public void adicionarProduto(Produto produto, int qtd) {
        if (produto.decrementarEstoque(qtd)) {
            itens.add(new ItemPedido(produto, qtd));
            total += produto.getPreco() * qtd;
        }
    }

    public void calcularTotal() {
        System.out.println("Total do pedido: R$ " + total);
    }

    public void exibirResumoPedido() {
        System.out.println("Pedido do cliente: " + cliente.getNome());
        for (ItemPedido item : itens) {
            System.out.println(item.getQuantidade() + "x " + item.getProduto().getNome() + " - R$ " + (item.getProduto().getPreco() * item.getQuantidade()));
        }
        calcularTotal();
    }
}

class ItemPedido {
    private Produto produto;
    private int quantidade;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }
}

public class Comercio {
    public static void main(String[] args) {
        // Criando categorias
        CategoriaProduto eletronicos = new CategoriaProduto("Eletrônicos");
        CategoriaProduto alimentos = new CategoriaProduto("Alimentos");

        // Criando produtos
        Produto notebook = new Produto("Notebook", 3500.00, 10);
        Produto smartphone = new Produto("Smartphone", 2500.00, 15);
        Produto arroz = new Produto("Arroz", 5.00, 100);
        Produto feijao = new Produto("Feijão", 7.50, 80);

        // Adicionando produtos às categorias
        eletronicos.adicionarProduto(notebook);
        eletronicos.adicionarProduto(smartphone);
        alimentos.adicionarProduto(arroz);
        alimentos.adicionarProduto(feijao);

        // Criando cliente
        Cliente joao = new Cliente("João Silva", "123.456.789-00", "99999-9999", "joao@email.com");

        // Criando pedido
        Pedido pedido = new Pedido(joao);
        pedido.adicionarProduto(notebook, 1);
        pedido.adicionarProduto(feijao, 2);

        // Exibir resumo do pedido
        pedido.exibirResumoPedido();
    }
}
