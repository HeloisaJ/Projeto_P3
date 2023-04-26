package Quarto;
import java.util.Random;

public class Quarto{

    private boolean tipo; // false - Solteiro, true - Casal
    private boolean disponivel;
    private boolean extras; // Com uma cama a mais ou não

    public Quarto(){
        this.tipo = randomizador();
        this.disponivel = true;
    }

    public boolean randomizador(){
        Random sistem = new Random();
        int res = sistem.nextInt(2);
        if(res == 0){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean getTipo(){
        return this.tipo;
    }

    public boolean getDisponivel(){
        return this.disponivel;
    }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }

    public boolean getExtras(){
        return this.extras;
    }

    @Override
    public boolean equals(Object n){
        if(n instanceof Quarto){
            Quarto quarto = (Quarto) n;
            if(this.tipo == quarto.tipo && this.disponivel == quarto.disponivel && this.extras == quarto.extras){
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
}