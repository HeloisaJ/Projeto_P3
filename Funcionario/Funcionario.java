package Funcionario;
import Exceptions.CelularException;
import Exceptions.CpfException;
import Exceptions.NomeException;
import Exceptions.SenhaException;
import Exceptions.TurnoException;
import TipoPessoa.Pessoa;

public class Funcionario extends Pessoa{

    private String turno;
    private String senha;
    
    public Funcionario(String nome, String cpf, String celular, String turno, String senha) throws CpfException, NomeException, TurnoException, SenhaException, CelularException{
        super(nome, cpf, celular);
        validarTurno(turno);
        validarSenha(senha);
        this.turno = turno;
        this.senha = senha;
    }

    public Funcionario(String nome, String senha) throws NomeException, SenhaException{ //Relacionado a parte de login, criação de uma instância de funcionário para comparar com a lista de funcionários
        super(nome);
        validarSenha(senha);
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
            if(this.nome.equals(x.nome) && this.senha.equals(x.senha)){
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

    @Override
    public String toString(){
        return "Nome do Funcionário: " + this.nome + ", CPF: " + this.cpf + ", Celular: " + this.celular + ", Turno: " + this.turno;
    }

    public void validarTurno(String turno) throws TurnoException{
        if(!turno.equals("diurno") && !turno.equals("noturno")){
            throw new TurnoException("Turno inválido! Digite diurno ou noturno no campo de turno.");
        }
    }

    public void validarSenha(String senha) throws SenhaException{
        if(senha.length() == 0){
            throw new SenhaException("Senha inválida! Preencha o campo senha.");
        }
    }
}
