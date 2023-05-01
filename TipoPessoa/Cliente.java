import java.util.Calendar;

public class Cliente extends Pessoa {
    private int diasDeHospedagem;
    private int diaDoCheckIn;
    private int diaDoCheckOut;
    private boolean tipoCama;//true=casal, false=solteiro
    private double valorInicial;
    private int chave;
    private boolean extras;//sim ou não
    private SituacaoEnum situacao;
    private double valorDosExtras;
   


    public Cliente(String nome, String cpf, String celular, int diasDeHospedagem, int diaDoCheckIn,
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

    public int getDiaCheckIn(){
        return this.diaDoCheckIn;
    }

    public int diaDoCheckOut(){
        return this.diaDoCheckIn +  this.diasDeHospedagem;
    }

    public void setSituacao(){
        this.situacao = SituacaoEnum.HOSPEDE;
    }

    
    
}
