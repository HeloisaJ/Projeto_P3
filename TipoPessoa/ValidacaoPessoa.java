package TipoPessoa;

import Exceptions.CelularException;
import Exceptions.CpfException;
import Exceptions.NomeException;

public class ValidacaoPessoa {
    
    public static void validarNome(String nome) throws NomeException{ // Colocar em cada pasta
        char letter;
        int tam = nome.length();

        if(tam == 0){
            throw new NomeException("Nome inválido! Campo do nome está vazio, tente novamente!");
        }

        for(int i = 0; i < tam; i++){
            letter = nome.charAt(i);
            if(Character.isDigit(letter)){
                throw new NomeException("Nome inválido! Um nome não pode conter digitos.");
            }
        }
    }

    public static void validarCPF(String cpf) throws CpfException{
        char element;
        int tam = cpf.length();
        String message = "CPF inválido! Coloque o CPF no formato a seguir: 000.000.000-00";

        if(tam == 0){
            throw new CpfException("CPF inválido! O campo do CPF está vazio, tente novamente!");
        }
        
        if(tam != 14){
            throw new CpfException(message);
        }

        for(int i = 0; i < tam; i++){
            element = cpf.charAt(i);
            if(i != 3 && i != 7 && i != 11 && !Character.isDigit(element)){
                throw new CpfException(message);
            }
            else if((i == 3 || i == 7) && element != '.'){
                throw new CpfException(message);
            }
            else if(i == 11 && element != '-'){
                throw new CpfException(message); 
            }
        }
    }

    public static void validarCelular(String celular) throws CelularException{ 
        char element;
        int tam = celular.length();
        String message = "Número inválido! Coloque o número de telefone no formato a seguir: 00 00000-0000";

        if(tam == 0){
            throw new CelularException("Número inválido! O campo do celular está vazio, tente novamente");
        }

        if(tam != 13){
            throw new CelularException(message);
        }

        for(int i = 0; i < tam; i++){
            element = celular.charAt(i);
            if(i != 2 && i != 8 && !Character.isDigit(element)){
                throw new CelularException(message);
            }
            else if(i == 2 && !Character.isWhitespace(element)){
                throw new CelularException(message);
            }
            else if(i == 8 && element != '-'){
                throw new CelularException(message);
            }
        }
    }

}
