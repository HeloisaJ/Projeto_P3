public class Cliente {
    private int diasDeHospedagem;
    private int numeroPessoas;
    private int nCamaCasais;
    //limite cama casais 1
    private int nCamaSolteiros;
    private double preco;
    private double valorPorPessoa;
    private double valorQuarto;
   
    public Cliente(int diasDeHospedagem, int numeroPessoas, int nCamaCasais, int nCamaSolteiros, double preco) {
        this.diasDeHospedagem = diasDeHospedagem;
        this.numeroPessoas = numeroPessoas;
        this.nCamaCasais = nCamaCasais;
        this.nCamaSolteiros = nCamaSolteiros;
        this.preco = preco;
        this.valorPorPessoa=50;
        this.valorQuarto=100;
    } 

    public double precoQuarto(){
        return  diasDeHospedagem*(valorQuarto+(valorPorPessoa*numeroPessoas));
    }

    
    
}
