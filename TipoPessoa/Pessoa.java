package TipoPessoa;

import Exceptions.CelularException;
import Exceptions.CpfException;
import Exceptions.NomeException;

public abstract class Pessoa{
    
    protected String nome;
    protected String cpf;
    protected String celular;
    
    public Pessoa(String nome, String cpf, String celular) throws CpfException, NomeException, CelularException {
        ValidacaoPessoa.validarNome(nome);
        ValidacaoPessoa.validarCPF(cpf);
        ValidacaoPessoa.validarCelular(celular);
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
    }
    
    public Pessoa(String nome, String cpf) throws CpfException, NomeException{
        ValidacaoPessoa.validarNome(nome);
        ValidacaoPessoa.validarCPF(cpf);
        this.nome = nome;
        this.cpf = cpf;
    }

    public Pessoa(String nome) throws NomeException{
        ValidacaoPessoa.validarNome(nome);
        this.nome = nome;
    }

}
