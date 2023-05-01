package Main;
import java.util.Scanner;

import Quarto.Quarto;
import Quarto.SistemaDeQuartos;
import TipoPessoa.Cliente;
public class Main {
    public static void main(String[] args) {
        Scanner in= new Scanner (System.in);
        String cpf;
        String nome;
        String celular;
        String senha;
        char escolha;

        Cliente cl;
        char tipoquarto;
        SistemaDeQuartos sq;
        Quarto q;
        int diasDeHospedagem;
        int diaDoCheckIn;
        boolean tipoCama;
        double valorInicial;
        int chave;
        boolean extras=false;
        int result;

        char escolha2;
        do{
            menuInicial();
            escolha=in.next().charAt(0);
            switch(escolha){
                case '1':
                    System.out.println("Interface de login");
                    System.out.println("Funcionário digite as seguintes informações para prosseguir");
                    System.out.println("Nome:");
                    nome=in.nextLine();
                    System.out.println("Senha:");
                    senha=in.nextLine();
                    
                    do{
                        escolha2=in.next().charAt(0);
                        System.out.println("Interface do funcionário");
                        menuAposLogin();

                        switch(escolha2){
                            case '1':
                                System.out.println("qual tipo de quarto deseja o cliente:");
                                sq=new SistemaDeQuartos();
                                System.out.println("1: casal");
                                System.out.println("2: solteiro");
                                tipoquarto=in.next().charAt(0);
                                
                                if(tipoquarto=='1'){
                                    tipoCama=true;
                                }
                                else{
                                    tipoCama=false;
                                }
                                q=new Quarto(tipoCama);
                                result=sq.buscarQuarto(q);
        
                                if(result ==-1){
                                    System.out.println("Não temos quartos do tipo escolhido disponivel no momento");
                                }
                                else if(result == -2){
                                    System.out.println("quarto não encontrado");
                                }
                                else{
                                    System.out.println("Quarto encontrado, numero do quarto é "+result);
                                    System.out.println("complete os dados do cliente para finalizar reserva");
                                    chave=result;
                                    System.out.println("Nome:");
                                    nome=in.nextLine();
                                    System.out.println("CPF:");
                                    cpf=in.nextLine();
                                    System.out.println("Número de Celular:");
                                    celular=in.nextLine();
                                    System.out.println("Quantidade de dias de hospedagem:");
                                    diasDeHospedagem=in.nextInt();
                                    System.out.println("Dia do Check-In:");
                                    diaDoCheckIn=in.nextInt();
                                    if(tipoCama==true){
                                        valorInicial=150;
                                    
                                    }
                                    else{
                                        valorInicial=100;
                                    }
                                    cl=new Cliente(nome, cpf, celular, diasDeHospedagem, diaDoCheckIn, tipoCama, valorInicial, chave, extras);
                                    System.out.println("Cliente Registrado com Sucesso");
                                }
                            break;
                            
                            case '2':
                                System.out.println("Digite dados do cliente para  Realização do Check-In");
                                System.out.println("Nome:");
                                nome=in.nextLine();
                                System.out.println("CPF:");
                                cpf=in.nextLine();
                                cl=new Cliente(nome, cpf);
                            break;

                            case '3':
                                System.out.println("Digite dados do cliente para Realização do CheckOut");
                                System.out.println("Nome:");
                                nome=in.nextLine();
                                System.out.println("CPF:");
                                cpf=in.nextLine();
                                cl=new Cliente(nome, cpf);
                            break;

                            case '4':

                            break;
                            
                            case '5':

                            break;

                            case '6':

                            break;

                            default:
                            System.out.println("Opção Inválida, Tente Novamente");

                            



                    }


                    }while(escolha2!=5);
                break;


                case '2':
                //acesar classe admin para da permisão 
                // cadastrar funcionario
                break;

                case '3':
                //acessar classe admin para da permisão 
                // remover funcionario

                default:
                    System.out.println("Opção Inválida, Tente Novamente");
            }
        }while(escolha !=4);   
    }



    public static void menuInicial(){
        System.out.println("Digite a opção desejada");
        System.out.println("1 para fazer login de funcionário");
        System.out.println("2 adicionar novo funcionário");
        System.out.println("3 remover funcionário");
        System.out.println("4 finalizar programa(Não finalizar sem backup)");
    }
    public static void menuAposLogin(){
        System.out.println("Digite a opção desejada");
        System.out.println("1: Reservar quarto");
        System.out.println("2: Fazer Check-in");
        System.out.println("3: Fazer Checkout");
        System.out.println("4: Exibir Clientes Para Check-In de Hoje ");
        System.out.println("5: Exibir Clientes Para CheckOut de Hoje");
        System.out.println("6: Exibir Todos Clientes");
        System.out.println("7: Voltar para tela inicial");

    }  
}
