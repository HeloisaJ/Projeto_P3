public class Funcionario extends Pessoa{
    private String turno;
    String senha;
    
    public Funcionario(String nome, String cpf, String celular, String turno, String senha){
        super(nome, cpf, celular);
        this.turno = turno;
        this.senha = senha;
    }

    public Funcionario(String nome, String senha){ //Relacionado a parte de login, criação de uma instância de funcionário para comparar com a lista de funcionários
        super(nome);
        this.senha = senha;
    }

    public String getSenha(){
        return this.senha;
    }

    public String getTurno(){ 
        return this.turno;
    }

    public void setTurno(String novoTurno){
        this.turno = novoTurno;
    }

    @Override
    public boolean equals(Object n){
        if(n instanceof Funcionario){
            Funcionario x = (Funcionario) n;
            if(this.getNome() == x.getNome() && this.senha == x.senha){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
}
