package TipoPessoa;

import java.util.Calendar;
import java.util.GregorianCalendar;

import Exceptions.CelularException;
import Exceptions.CpfException;
import Exceptions.DataException;
import Exceptions.NomeException;
import Exceptions.OpcaoExtrasException;

public class Cliente extends Pessoa {
    private int diasDeHospedagem;
    private Calendar diaDoCheckIn;
    private Calendar diaDoCheckOut;
    private double valorInicial;
    private int chave;
    private SituacaoEnum situacao;
    private double valorDosExtras; // Uma cama extra
   

    public Cliente(String nome, String cpf, String celular, int diasDeHospedagem, Calendar diaDoCheckIn, boolean tipoCama, int chave, char extras) throws CpfException, NomeException, DataException, OpcaoExtrasException, CelularException{
        super(nome, cpf, celular);
        validarData(diaDoCheckIn);
        this.diasDeHospedagem = diasDeHospedagem;
        this.diaDoCheckIn = diaDoCheckIn;
        validarData(diaDoCheckOut());
        this.diaDoCheckOut = diaDoCheckOut();

        if(tipoCama){
            this.valorInicial = 150;
        }
        else{
            this.valorInicial = 100;
        }  

        this.chave = chave;
        this.situacao = SituacaoEnum.RESERVA;

        if(extras != 'S' && extras != 'N'){
            throw new OpcaoExtrasException("Opção inválida nos extras! Digite S ou N para escolher qual opção.");
        }
        else if(extras == 'S'){
            this.valorDosExtras = 100;
        }
        else{
            this.valorDosExtras = 0;
        }
    }

    public Cliente(String nome, String cpf) throws CpfException, NomeException {
        super(nome, cpf);
    }

    public void validarData(Calendar data) throws DataException{
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

    public int getDiasDeHospedagem(){
        return this.diasDeHospedagem;
    }

    public Calendar getDiaCheckIn(){
        return this.diaDoCheckIn;
    }

    public Calendar diaDoCheckOut(){
        Calendar data = new GregorianCalendar(this.diaDoCheckIn.get(Calendar.YEAR), this.diaDoCheckIn.get(Calendar.MONTH), this.diaDoCheckIn.get(Calendar.DAY_OF_MONTH));
        data.add(Calendar.DAY_OF_MONTH, this.diasDeHospedagem);
        return data;
    }

    public void setSituacao(){
        this.situacao = SituacaoEnum.HOSPEDE;
    }

    public Calendar getDiaDoCheckOut(){
        return this.diaDoCheckOut;
    }

    public int getChave(){ 
        return this.chave;
    }

    public double custoTotal(){
        if(this.diasDeHospedagem == 0){
            return this.valorInicial + this.valorDosExtras;
        }
        else{
            return this.valorInicial * this.diasDeHospedagem + this.valorDosExtras;
        }
    }

    @Override
    public boolean equals(Object n){
        if(this == n){
            return true;
        }
        if(n instanceof Cliente){
            Cliente x = (Cliente) n;
            if(this.nome.equals(x.nome) && this.cpf.equals(x.cpf)){
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
        return "Cliente: " + this.nome + ", CPF: " + this.cpf + ", Celular: " + this.celular + ", Quarto: " + this.chave + ", Dia do check-in: " + dataString(this.diaDoCheckIn) + ", Dia do check-out: " + dataString(this.diaDoCheckOut) + ", Situação: " + this.situacao;
    }

    public String dataString(Calendar data){
        return data.get(Calendar.DAY_OF_MONTH) + "/" + (data.get(Calendar.MONTH) + 1) + "/" + data.get(Calendar.YEAR);
    }
    
}
