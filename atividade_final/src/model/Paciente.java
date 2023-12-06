package model;

public class Paciente {

    private String nome;
    private String genero;
    private String data;
    private String endereco;
    private int numero;
    private String telefone;
    private String email;
    private String obs;

    public Paciente(String nome, String genero, String data, String endereco, int numero, String telefone, String email, String obs) {
        this.nome = nome;
        this.genero = genero;
        this.data = data;
        this.endereco = endereco;
        this.numero = numero;
        this.telefone = telefone;
        this.email = email;
        this.obs = obs;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

}
