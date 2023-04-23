public class SistemaDeQuartos {
    
    private Quarto quantQuartos [][];
    private int numeroQuartosOcupados;

    public SistemaDeQuartos(){
        this.quantQuartos = new Quarto [6][6];
    }

    public int buscarQuarto(Quarto modelo){
        if(numeroQuartosOcupados == 36){
            return -1;
        }
        
        int i, j = 0;
        for(i = 0; i < quantQuartos.length; i++){
            for(j = 0; j < quantQuartos.length; j++){
                if(modelo.equals(quantQuartos[i][j]) && quantQuartos[i][j].getDisponivel()){
                    break;
                }
            }
        }    

        int chave = calculoDaChave(i, j);
        quantQuartos[i][j].setDisponivel(false);
        numeroQuartosOcupados++;

        return chave;
    }

    private int calculoDaChave(int i, int j){
        return i * 100 + j;
    }
}
