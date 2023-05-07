package TipoPessoa;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Cliente extends Pessoa {
    private int diasDeHospedagem;
    private Calendar diaDoCheckIn;
    private Calendar diaDoCheckOut;
    private boolean tipoCama;//true=casal, false=solteiro
    private double valorInicial;
    private int chave;
    private boolean extras;//sim ou não
    private SituacaoEnum situacao;
    private double valorDosExtras;
   


    public Cliente(String nome, String cpf, String celular, int diasDeHospedagem, Calendar diaDoCheckIn,
        boolean tipoCama, double valorInicial , int chave, boolean extras) {
        super(nome, cpf, celular);
        this.diasDeHospedagem = diasDeHospedagem;
        this.diaDoCheckIn = diaDoCheckIn;       
        this.diaDoCheckOut = diaDoCheckOut();
        this.valorInicial = valorInicial;
        this.tipoCama = tipoCama;      
        this.chave = chave;
        this.situacao = SituacaoEnum.RESERVA;
        this.extras = extras;
        this.valorDosExtras = 300.0;
    }

    public Cliente(String nome, String cpf) {
        super(nome, cpf);
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
