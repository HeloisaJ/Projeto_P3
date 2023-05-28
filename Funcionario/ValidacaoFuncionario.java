package Funcionario;

import Exceptions.SenhaException;
import Exceptions.TurnoException;

public class ValidacaoFuncionario {
    
    public static void validarTurno(String turno) throws TurnoException{
        if(!turno.equals("diurno") && !turno.equals("noturno")){
            throw new TurnoException("Turno inválido! Digite diurno ou noturno no campo de turno.");
        }
    }

    public static void validarSenha(String senha) throws SenhaException{
        if(senha.length() == 0){
            throw new SenhaException("Senha inválida! Preencha o campo senha.");
        }
    }

}
