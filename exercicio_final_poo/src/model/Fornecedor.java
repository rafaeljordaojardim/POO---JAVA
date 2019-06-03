package model;

public class Fornecedor {
    private int codigo;
    private String razao ;
    private String social ;
    private String endereco;
    private String cidade ;
    private String estado;



    private Contato contato;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getSocial() {
        return social;
    }

    public void setSocial(String social) {
        this.social = social;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }
    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }


    @Override
    public String toString() {
        return "codigo=" + codigo +
                ", razao='" + razao + '\'' +
                ", social='" + social + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\n' +
                "'contato='" + contato.toString();
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Fornecedor(int codigo, String razao, String social, String endereco, String cidade, String estado, Contato contato) {
        this.codigo = codigo;
        this.razao = razao;
        this.social = social;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.contato = contato;
    }


    public Fornecedor(){
        this.codigo = 0;
        this.razao = "";
        this.social = "";
        this.endereco = "";
        this.cidade = "Mogi Mirim";
        this.estado = "SP";
        this.contato = null;
    }
}
