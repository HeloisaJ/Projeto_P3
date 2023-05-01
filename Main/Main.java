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

        int diasDeHospedagem;
        int diaDoCheckIn;
        boolean tipoCama;
        double valorInicial;
        int chave;
        boolean extras;

        char escolha2;
        do{
            menuInicial();
            escolha=in.next().charAt(0);
            switch(escolha){
                case '1':
                    System.out.println("Tela de login, informe dados funcionario");
                    System.out.println("Nome:");
                    nome=in.nextLine();
                    System.out.println("Senha:");
                    senha=in.nextLine();
                    
                    // chamar classe funcionario
                    // para comparar senha e nome
                    do{
                        escolha2=in.next().charAt(0);
                        System.out.println("tela do funcionario");
                        menuAposLogin();
                        //parte inicial
                        if(escolha2=='1'){
                        System.out.println("nome :");
                        nome=in.nextLine();
                        System.out.println("dias de hospedagem :");
                        diasDeHospedagem=in.nextInt();
                        System.out.println("Dia de chegada:");
                        diaDoCheckIn=in.nextInt();
                        
                        tipoCama=in.nextBoolean();
                        if(tipoCama==true){
                            valorInicial=150;
                        }
                        else if(tipoCama=false){
                            valorInicial=100;
                        }
                        else{
                            System.out.println("opcao invalida");
                        }
                        //parte apos ver se tem vaga
                        chave=in.nextInt();
                        // se tiver a chave completa cadastro
                        System.out.println("cpf :");
                        cpf=in.nextLine();
                        System.out.println("Celular :");
                        celular=in.nextLine();
                    }
                    else if(escolha2=='2'){
                        
                    }


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
    public static void menuAposLogin(){
        System.out.println("nome funcionario"+" digite a opção desejada");
        System.out.println("1 reserva de quarto");
        System.out.println("2 fazer checkout");
        System.out.println("3 voltar a tela incial");

    }
    
}
