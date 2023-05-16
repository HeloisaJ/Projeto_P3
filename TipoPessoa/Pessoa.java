package TipoPessoa;

import Exceptions.CpfException;
import Exceptions.NomeException;

public abstract class Pessoa{
    
    protected String nome;
    protected String cpf;
    protected String celular;
    
    public Pessoa(String nome, String cpf, String celular) throws CpfException, NomeException {
        if(!validarNome(nome)){
            throw new NomeException("Nome inválido! Um nome não pode conter digitos.");
        }
        if(!validarCPF(cpf)){
            throw new CpfException("CPF inválido! Coloque o CPF no formato a seguir: 000.000.000-00");
        }
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
    }
    
    public Pessoa(String nome, String cpf) throws CpfException, NomeException{
        if(!validarNome(nome)){
            throw new NomeException("Nome inválido! Um nome não pode conter digitos.");
        }
        if(!validarCPF(cpf)){
            throw new CpfException("CPF inválido! Coloque o CPF no formato a seguir: 000.000.000-00");
        }
        this.nome = nome;
        this.cpf = cpf;
    }

    public Pessoa(String nome) throws NomeException{
        if(!validarNome(nome)){
            throw new NomeException("Nome inválido! Um nome não pode conter digitos.");
        }
        this.nome = nome;
    }

    public boolean validarNome(String nome){
        char letter;
        int tam = nome.length();
        for(int i = 0; i < tam; i++){
            letter = nome.charAt(i);
            if(Character.isDigit(letter)){
                return false;
            }
        }
        return true;
    }

    public boolean validarCPF(String cpf){
        char element;
        int tam = cpf.length();

        if(tam != 14){
            return false;
        }

        for(int i = 0; i < tam; i++){
            element = cpf.charAt(i);
            if(i != 3 && i != 7 && i != 11 && !Character.isDigit(element)){
                return false;
            }
            else if((i == 3 || i == 7) && element != '.'){
                return false;
            }
            else if(i == 11 && element != '-'){

            }
        }
        return true;
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

}
