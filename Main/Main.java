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
                    System.out.println("Tela de login, informe dados funcionario");
                    System.out.println("Nome:");
                    nome=in.nextLine();
                    System.out.println("Senha:");
                    senha=in.nextLine();
                    
                    do{
                        escolha2=in.next().charAt(0);
                        System.out.println("tela do funcionario");
                        menuAposLogin();

                        switch(escolha2){
                            case '1':
                                System.out.println("qual tipo de quarto do cliente:");
                                sq=new SistemaDeQuartos();
                                System.out.println("1 casal");
                                System.out.println("2 solteiro");
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
                                    System.out.println("Não temos quartos do tipo escolhido disponiveis no momento");
                                }
                                else if(result == -2){
                                    System.out.println("quarto não encontrado");
                                }
                                else{
                                    System.out.println("Achamos o quarto de chave "+result);
                                    System.out.println("agora complete os dados do cliente");
                                    chave=result;
                                    System.out.println("nome :");
                                    nome=in.nextLine();
                                    System.out.println("cpf :");
                                    cpf=in.nextLine();
                                    System.out.println("Celular :");
                                    celular=in.nextLine();
                                    System.out.println("dias de hospedagem :");
                                    diasDeHospedagem=in.nextInt();
                                    System.out.println("Dia de chegada:");
                                    diaDoCheckIn=in.nextInt();
                                    if(tipoCama==true){
                                        valorInicial=150;
                                    
                                    }
                                    else{
                                        valorInicial=100;
                                    }
                                    cl=new Cliente(nome, cpf, celular, diasDeHospedagem, diaDoCheckIn, tipoCama, valorInicial, chave, extras);
                                    System.out.println("cliente registrado");
                                }
                            break;
                            
                            case '2':
                                System.out.println("Digite dados do cliente para CheckIn");
                                System.out.println("Nome:");
                                nome=in.nextLine();
                                System.out.println("CPF:");
                                cpf=in.nextLine();
                                cl=new Cliente(nome, cpf);
                            break;

                            case '3':
                                System.out.println("Digite dados do cliente para CheckIn");
                                System.out.println("Nome:");
                                nome=in.nextLine();
                                System.out.println("CPF:");
                                cpf=in.nextLine();
                                cl=new Cliente(nome, cpf);
                            break;

                            case '4':
                                exibirClientesParaCheckInHoje();

                            break;
                            
                            case '5':
                                exibirClientesHospedados();

                            break;

                            case '6':
                                exibirClientesParaCheckOutHoje();

                            break;

                            default:
                            System.out.println("opção invalida, tente novamente");

                            



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
        System.out.println("digite a opção desejada");
        System.out.println("1 reserva de quarto");
        System.out.println("2 fazer checkIn");
        System.out.println("3 fazer checkOut");
        System.out.println("4 exibir Clientes Para CheckIn Hoje ");
        System.out.println("5 exibir Clientes Para CheckOut Hoje");
        System.out.println("6 exibir Todos Clientes");
        System.out.println("7 voltar para tela inicial");

    }
    public static void exibirClientesParaCheckInHoje(){

    }
    public static void exibirClientesHospedados(){

    }

    public static void exibirClientesParaCheckOutHoje(){

    }
    public static void exibirTodosClientes(){

    }
    
}
