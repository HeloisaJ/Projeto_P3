package Pessoa.Quarto;
public class SistemaDeQuartos {
    
    private Quarto quantQuartos [][];
    private int numeroQuartosOcupados;

    public SistemaDeQuartos(){
        this.quantQuartos = new Quarto [6][6];
    }

    public int buscarQuarto(Quarto modelo){
        int tam = quantQuartos.length;
        if(this.numeroQuartosOcupados == tam){ // Ver se todos os quartos estão ocupados
            return -1;
        }
        
        int i, j = 0;
        for(i = 0; i < tam; i++){
            for(j = 0; j < tam; j++){ // Procura uma cama com base no modelo que o usuário deseja
                if(modelo.equals(quantQuartos[i][j]) && quantQuartos[i][j].getDisponivel()){
                    break;
                }
            }
        }    

        if(i == tam && j == tam){ // Não encontrou um quarto daquele estilo do qual o usuário deseja
            return -2;
        }

        int chave = calculoDaChave(i + 1, j + 1); // Criação da chave do quarto
        quantQuartos[i][j].setDisponivel(false);
        numeroQuartosOcupados++;

        return chave;
    }

    private int calculoDaChave(int i, int j){
        return i * 100 + j;
    }

    public int getNumeroQuartosOcupados(){
        return this.numeroQuartosOcupados;
    }
}
