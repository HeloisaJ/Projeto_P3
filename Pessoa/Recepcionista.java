

import Sistema.SistemaRecepcionista;

public class Recepcionista extends Funcionario{
    
    private SistemaRecepcionista sistema;

    public Recepcionista(String nome, String cpf, String celular, String turno, String senha, SistemaRecepcionista sistema){
        super(nome, cpf, celular, turno, senha);
        this.sistema = sistema;
    }
    
    public SistemaRecepcionista getSistema(){
        return this.sistema;
    }
}
