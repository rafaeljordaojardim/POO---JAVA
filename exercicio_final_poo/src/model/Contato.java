package model;

public class Contato {
    //atributos de instancia
    private String nome;
    private String telefone;
    private String email;

    //consstrutores
    public Contato(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }
    public Contato(){
        this.nome = "";
        this.telefone = "";
        this.email = "";
    }
    //acessores

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
