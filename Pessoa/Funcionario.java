import Exceptions.CpfException;
import Exceptions.NomeException;
import TipoPessoa.Pessoa;

public class Funcionario extends Pessoa{

    private String turno;
    private String senha;
    
    public Funcionario(String nome, String cpf, String celular, String turno, String senha) throws CpfException, NomeException{
        super(nome, cpf, celular);
        this.turno = turno;
        this.senha = senha;
    }

    public Funcionario(String nome, String senha) throws NomeException{ //Relacionado a parte de login, criação de uma instância de funcionário para comparar com a lista de funcionários
        super(nome);
        this.senha = senha;
    }

    public String getSenha(){
        return this.senha;
    }

    public String getTurno(){ 
        return this.turno;
    }

    @Override
    public boolean equals(Object n){
        if(this == n){
            return true;
        }
        if(n instanceof Funcionario){
            Funcionario x = (Funcionario) n;
            if(this.getNome().equals(x.getNome()) && this.senha.equals(x.senha)){
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
