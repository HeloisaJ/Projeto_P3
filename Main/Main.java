package Main;
import java.util.Scanner;

import Quarto.SistemaDeQuartos;
import Sistema.SistemaRecepcionista;

public class Main {
    public static void main(String[] args) {
        Scanner in= new Scanner (System.in);
        String cpf;
        String nome;
        String celular;
        String senha;
        String turno;
        char escolha;

        SistemaDeQuartos sq = new SistemaDeQuartos();
        SistemaRecepcionista sistema = new SistemaRecepcionista();

        do{
            menuInicial();
            escolha=in.next().charAt(0); in.nextLine();
            System.out.println();

            switch(escolha){
                case '1':
                    System.out.println("Interface de login");
                    System.out.println("Funcionário digite as seguintes informações para prosseguir");
                    System.out.println("Nome:");
                    nome=in.nextLine();
                    System.out.println("Senha:");
                    senha=in.nextLine();
                    MenuAposLogin.Menu(sq, sistema, in);
                break;


                case '2':
                //acesar classe admin para da permisão 
                // cadastrar funcionario
                    System.out.println();
                break;

                case '3':
                //acessar classe admin para da permisão 
                // remover funcionario
                    System.out.println();
                break;

                case '4':
                    System.out.println("Tchau!");
                break;

                default:
                    System.out.println("Opção Inválida, Tente Novamente");
                break;
            }
        }while(escolha !='4');   

        in.close();
    }

    public static void menuInicial(){
        System.out.println("Digite a opção desejada: ");
        System.out.println("1 para fazer login de funcionário");
        System.out.println("2 adicionar novo funcionário");
        System.out.println("3 remover funcionário");
        System.out.println("4 finalizar programa(Não finalizar sem backup)");
    }
    public static void menuAposLogin(){
        System.out.println("Digite a opção desejada");
        System.out.println("1: Reservar quarto");
        System.out.println("2: Fazer Check-in");
        System.out.println("3: Fazer Check-out");
        System.out.println("4: Exibir Clientes Para Check-in de Hoje ");
        System.out.println("5: Exibir Clientes Para Check-out de Hoje");
        System.out.println("6: Exibir os Clientes Hospedados");
        System.out.println("7: Exibir Todos Clientes");
        System.out.println("8: Voltar para tela inicial");

    }  
}
