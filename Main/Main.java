package Main;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in= new Scanner (System.in);
        String cpf;
        String nome;
        String celular;
        String senha;
        char escolha;
        char escolha2;
        do{
            menuInicial();
            escolha=in.next().charAt(0);
            switch(escolha){
                case '1':
                    // chamar classe funcionario
                    // para comparar senha e nome
                    do{
                        escolha2=in.next().charAt(0);

                    }while(escolha2!=3);
                break;


                case '2':
                //acesar classe admin para da permisão 
                // cadastrar funcionario
                break;

                case '3':
                //acessar classe admin para da permisão 
                // remover funcionario

                default:
                System.out.println("opcão invalida");
            }
        }while(escolha !=4);   
    }



    public static void menuInicial(){
        System.out.println("escolha a opção desejada");
        System.out.println("1 para fazer login de funcionario");
        System.out.println("2 adicionar funcionario");
        System.out.println("3 remover funcionario");
        System.out.println("4 finilizar progama");
    }
    public void menuAposLogin(){
        System.out.println("nome funcionario"+" digite a opção desejada");
        System.out.println("1 reserva de quarto");
        System.out.println("2 fazer checkout");
        System.out.println("3 voltar a tela incial");

    }
    
}
