package Cliente;

import java.util.Calendar;
import java.util.GregorianCalendar;

import Exceptions.CelularException;
import Exceptions.CpfException;
import Exceptions.DataException;
import Exceptions.NomeException;
import Exceptions.OpcaoExtrasException;
import TipoPessoa.Pessoa;

public class Cliente extends Pessoa implements ClienteInterface{
    private int diasDeHospedagem;
    private Calendar diaDoCheckIn;
    private Calendar diaDoCheckOut;
    private double valorInicial;
    private int chave;
    private SituacaoEnum situacao;
    private double valorDosExtras; // Uma cama extra
   

    private Cliente(String nome, String cpf, String celular, int diasDeHospedagem, Calendar diaDoCheckIn, boolean tipoCama, int chave, char extras) throws CpfException, NomeException, DataException, OpcaoExtrasException, CelularException{
        super(nome, cpf, celular);

        ValidacaoCliente.validarDiasDeHospedagem(diasDeHospedagem);
        this.diasDeHospedagem = diasDeHospedagem;
        ValidacaoCliente.validarData(diaDoCheckIn);
        this.diaDoCheckIn = diaDoCheckIn;
        ValidacaoCliente.validarData(diaDoCheckOut());
        this.diaDoCheckOut = diaDoCheckOut();

        if(tipoCama){
            this.valorInicial = 150;
        }
        else{
            this.valorInicial = 100;
        }  

        this.chave = chave;
        this.situacao = SituacaoEnum.RESERVA;
        ValidacaoCliente.ValidarExtras(extras);

        if(extras == 'S'){
            this.valorDosExtras = 100;
        }
        else{
            this.valorDosExtras = 0;
        }
    }

    public Cliente(String nome, String cpf) throws CpfException, NomeException {
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
    
    public static final class ClienteBuilder{
        
        private String nome;
        private String cpf;
        private String celular;
        private int diasDeHospedagem;
        private Calendar diaDoCheckIn;
        private boolean tipoCama;
        private int chave;
        private char extras;

        public ClienteBuilder nome(String nome){
            this.nome = nome;
            return this;
        }

        public ClienteBuilder cpf(String cpf){
            this.cpf = cpf;
            return this;
        }

        public ClienteBuilder celular(String celular){
            this.celular = celular;
            return this;
        }

        public ClienteBuilder diasDeHospedagem(int diasDeHospedagem){
            this.diasDeHospedagem = diasDeHospedagem;
            return this;
        }

        public ClienteBuilder diaDoCheckIn(Calendar diaDoCheckIn){
            this.diaDoCheckIn = diaDoCheckIn;
            return this;
        }

        public ClienteBuilder tipoCama(boolean tipoCama){
            this.tipoCama = tipoCama;
            return this;
        }

        public ClienteBuilder chave(int chave){
            this.chave = chave;
            return this;
        }

        public ClienteBuilder extras(char extras){
            this.extras = extras;
            return this;
        }

        public Cliente build() throws CpfException, NomeException, DataException, OpcaoExtrasException, CelularException {
            return new Cliente(nome, cpf, celular, diasDeHospedagem, diaDoCheckIn, tipoCama, chave, extras);
        }
    }
}
