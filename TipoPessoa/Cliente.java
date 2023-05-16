package TipoPessoa;

import java.util.Calendar;
import java.util.GregorianCalendar;

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
   

    public Cliente(String nome, String cpf, String celular, int diasDeHospedagem, Calendar diaDoCheckIn, boolean tipoCama, int chave, char extras) throws CpfException, NomeException, DataException, OpcaoExtrasException{
        super(nome, cpf, celular);

        String valido =  validarData(diaDoCheckIn);

        if(valido != null){
            throw new DataException(valido);
        }

        this.diasDeHospedagem = diasDeHospedagem;
        this.diaDoCheckIn = diaDoCheckIn;
        valido = validarData(diaDoCheckOut());

        if(valido != null){
            throw new DataException(valido);
        }
       
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

    public String validarData(Calendar data){
        GregorianCalendar padrao = new GregorianCalendar();
        if(data.get(Calendar.YEAR) < padrao.get(Calendar.YEAR)){
            return "Ano inválido! O ano tem que ser maior ou igual ao ano atual.";
        }
        else if(data.get(Calendar.MONTH) < padrao.get(Calendar.MONTH) && data.get(Calendar.YEAR) == padrao.get(Calendar.YEAR)){
            return "Mês inválido! Esse mês já passou, digite um outro mês.";
        }
        else if(data.get(Calendar.MONTH) + 1 == 2 && data.get(Calendar.DAY_OF_MONTH) > 29){
            return "Dia inválido! Como o mês é fevereiro, digite um número menor que 30 para o dia.";
        }
        else if(data.get(Calendar.MONTH) + 1 == 2 && data.get(Calendar.DAY_OF_MONTH) == 29 && padrao.isLeapYear(data.get(Calendar.YEAR))){
            return "Dia inválido! Como este ano não é bissexto, não existe dia 29 de fevereiro, digite um número menor que 29.";
        }
        else if(data.get(Calendar.DAY_OF_MONTH) < padrao.get(Calendar.DAY_OF_MONTH) && data.get(Calendar.MONTH) == padrao.get(Calendar.MONTH) && data.get(Calendar.YEAR) == padrao.get(Calendar.YEAR)){
            return "Dia inválido! Esse dia já passou, digite um outro dia.";
        }

        return null;
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
        return "Cliente: " + this.nome + ", Quarto: " + this.chave + ", Dia do check-in: " + dataString(this.diaDoCheckIn) + ", Dia do check-out: " + dataString(this.diaDoCheckOut) + ", Situação: " + this.situacao;
    }

    public String dataString(Calendar data){
        return data.get(Calendar.DAY_OF_MONTH) + "/" + (data.get(Calendar.MONTH) + 1) + "/" + data.get(Calendar.YEAR);
    }
    
}
