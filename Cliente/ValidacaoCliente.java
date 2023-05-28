package Cliente;

import java.util.Calendar;
import java.util.GregorianCalendar;

import Exceptions.DataException;
import Exceptions.OpcaoExtrasException;

public class ValidacaoCliente {
    
    public static void validarData(Calendar data) throws DataException{
        GregorianCalendar padrao = new GregorianCalendar();
        int ano = data.get(Calendar.YEAR);
        int mes = data.get(Calendar.MONTH) + 1;
        int dia = data.get(Calendar.DAY_OF_MONTH);

        if(ano < padrao.get(Calendar.YEAR)){
            throw new DataException("Ano inválido! O ano tem que ser maior ou igual ao ano atual.");
        }
        else if(mes < padrao.get(Calendar.MONTH) + 1 && ano == padrao.get(Calendar.YEAR)){
            throw new DataException("Mês inválido! Esse mês já passou, digite um outro mês.");
        }
        else if((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia == 31){
            throw new DataException("Dia inválido! Esse mês não tem dia 31.");
        }
        else if(mes == 2 && dia > 29){
            throw new DataException( "Dia inválido! Como o mês é fevereiro, digite um número menor que 30 para o dia.");
        }
        else if(mes == 2 && dia == 29 && padrao.isLeapYear(ano)){
            throw new DataException("Dia inválido! Como este ano não é bissexto, não existe dia 29 de fevereiro, digite um número menor que 29.");
        }
        else if(dia < padrao.get(Calendar.DAY_OF_MONTH) && mes == padrao.get(Calendar.MONTH) + 1 && ano == padrao.get(Calendar.YEAR)){
            throw new DataException("Dia inválido! Esse dia já passou, digite um outro dia.");
        }
    }

    public static void validarDiasDeHospedagem(int dias) throws DataException{
        if(dias < 0){
            throw new DataException("Número de dias de hospedagem inválido! Digite um número maior ou igual a 0.");
        }
    }

    public static void ValidarExtras(char extras) throws OpcaoExtrasException{
        if(extras != 'S' && extras != 'N'){
            throw new OpcaoExtrasException("Opção inválida nos extras! Digite S ou N para escolher qual opção.");
        }
    }

}
