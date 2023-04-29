package Quarto;

public class Quarto{

    private boolean tipo; // false - Solteiro, true - Casal
    private boolean disponivel;

    public Quarto(boolean tipo){
        this.tipo = tipo;
        this.disponivel = true;
    }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }

    @Override
    public boolean equals(Object n){
        if(this == n){
            return true;
        }
        else if(n instanceof Quarto){
            Quarto quarto = (Quarto) n;
            if(this.tipo == quarto.tipo && this.disponivel == quarto.disponivel){
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