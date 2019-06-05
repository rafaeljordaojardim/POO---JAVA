package model;

public class Produto {
    private int codigo;
    private String descricao;
    private float preco;
    private int quantidadeEstoque;
    private Fornecedor fornecedor;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Produto(int codigo, String descricao, float preco, int quantidadeEstoque, Fornecedor fornecedor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return " codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", quantidadeEstoque=" + quantidadeEstoque +
                "\nfornecedor=" + fornecedor.toString();
    }

    public Produto() {
        this.codigo = 0;
        this.descricao = "";
        this.preco = 0;
        this.quantidadeEstoque = 0;
        this.fornecedor = null;
    }
}
