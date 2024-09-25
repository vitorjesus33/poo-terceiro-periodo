import java.util.ArrayList;
import java.util.List;

// Classe Vendedor
class Vendedor {
    private String nome;
    private int idade;
    private Loja loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase;
    private List<Double> salariosRecebidos;

    public Vendedor(String nome, int idade, Loja loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salariosRecebidos = new ArrayList<>();
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja.getNomeFantasia());
    }

    public void adicionarSalario(double salario) {
        if (salariosRecebidos.size() < 3) {
            salariosRecebidos.add(salario);
        } else {
            System.out.println("O limite de três salários já foi registrado.");
        }
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salariosRecebidos) {
            soma += salario;
        }
        return salariosRecebidos.isEmpty() ? 0 : soma / salariosRecebidos.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}

// Classe Cliente
class Cliente {
    private String nome;
    private int idade;
    private String cidade;
    private String bairro;
    private String rua;

    public Cliente(String nome, int idade, String cidade, String bairro, String rua) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }
}

// Classe Loja
class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String cidade;
    private String bairro;
    private String rua;
    private List<Vendedor> vendedores;
    private List<Cliente> clientes;

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.vendedores = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void adicionarVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public int contarClientes() {
        return clientes.size();
    }

    public int contarVendedores() {
        return vendedores.size();
    }

    public void apresentarse() {
        System.out.println("Loja: " + nomeFantasia + ", CNPJ: " + cnpj + ", Endereço: " + rua + ", " + bairro + ", " + cidade);
    }
}

// Classe Main
public class Main {

    public static void main(String[] args) {
        Loja loja = criarLoja();
        Vendedor vendedor1 = criarVendedor1(loja);
        Vendedor vendedor2 = criarVendedor2(loja);
        Cliente cliente = criarCliente();

        // Adicionando vendedores e clientes à loja
        loja.adicionarVendedor(vendedor1);
        loja.adicionarVendedor(vendedor2);
        loja.adicionarCliente(cliente);

        // Apresentando informações
        loja.apresentarse();
        vendedor1.apresentarse();
        vendedor2.apresentarse();
        cliente.apresentarse();

        // Exibindo quantidades
        System.out.println("Total de clientes: " + loja.contarClientes());
        System.out.println("Total de vendedores: " + loja.contarVendedores());

        // Cálculo de salário e bônus
        vendedor1.adicionarSalario(3000);
        vendedor1.adicionarSalario(3200);
        vendedor1.adicionarSalario(3100);

        System.out.println("Média salarial de " + vendedor1.nome + ": " + vendedor1.calcularMedia());
        System.out.println("Bônus de " + vendedor1.nome + ": " + vendedor1.calcularBonus());
    }

    public static Loja criarLoja() {
        return new Loja("Myy Plant", "Myy Plant LTDA", "12.345.678/0001-90", "São Paulo", "Centro", "Rua das Plantas");
    }

    public static Vendedor criarVendedor1(Loja loja) {
        return new Vendedor("João", 30, loja, "São Paulo", "Centro", "Rua A", 3000);
    }

    public static Vendedor criarVendedor2(Loja loja) {
        return new Vendedor("Maria", 25, loja, "São Paulo", "Centro", "Rua B", 3200);
    }

    public static Cliente criarCliente() {
        return new Cliente("Carlos", 40, "São Paulo", "Centro", "Rua C");
    }
}
