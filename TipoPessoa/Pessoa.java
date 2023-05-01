package TipoPessoa;
public abstract class Pessoa{
    
    private String nome;
    private String cpf;
    private String celular;
    
    
    public Pessoa(String nome, String cpf, String celular) {
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
    }
    public Pessoa(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public Pessoa(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }


    public String getCpf() {
        return cpf;
    }


    public String getCelular() {
        return celular;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public void setCelular(String celular) {
        this.celular = celular;
    }

}
