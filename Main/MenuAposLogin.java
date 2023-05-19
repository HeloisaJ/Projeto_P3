package Main;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import Exceptions.CelularException;
import Exceptions.CpfException;
import Exceptions.DataException;
import Exceptions.NomeException;
import Exceptions.OpcaoExtrasException;
import Quarto.Quarto;
import Quarto.SistemaDeQuartos;
import Sistema.SistemaRecepcionista;
import TipoPessoa.Cliente;

public class MenuAposLogin {
    
    public static void Menu(SistemaDeQuartos sq, SistemaRecepcionista sistema, Scanner in){

        char escolha2;
        String cpf;
        String nome;
        String celular;
        Cliente cl;
        char tipoQuarto;
        Quarto q; 
        int diasDeHospedagem;
        int dia, mes, ano;
        Calendar diaDoCheckIn;
        boolean tipoCama;
        int chave = 0;
        char extras; 
        int result;

        do{
            System.out.println("Interface do funcionário");
            telaMenuAposLogin();
            escolha2=in.next().charAt(0);in.nextLine();
            System.out.println();

            switch(escolha2){
                case '1':
                    try {
                        System.out.println("qual tipo de quarto deseja o cliente:");
                        System.out.println("1: casal");
                        System.out.println("2: solteiro");
                        tipoQuarto=in.next().charAt(0);in.nextLine();

                        while(tipoQuarto != '1' && tipoQuarto != '2'){ 
                            System.out.println("Tipo do quarto inválido, digite 1 para casal ou 2 para solteiro: ");
                            tipoQuarto=in.next().charAt(0);in.nextLine();
                        }

                        if(tipoQuarto=='1'){
                            tipoCama=true;
                        }
                        else{
                            tipoCama=false;
                        }

                        System.out.println("Deseja adicionar uma cama extra no quarto ? Digite S para sim ou N para não");
                        extras = in.next().charAt(0);in.nextLine();
                        extras = Character.toUpperCase(extras);

                        q = new Quarto(tipoCama);
                        result = sq.buscarQuarto(q);

                        if(result ==-1){
                            System.out.println("Não temos quartos do tipo escolhido disponível no momento");
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
                            System.out.println("CPF (Ex: 000.000.000-00):");
                            cpf=in.nextLine();
                            System.out.println("Número de Celular:");
                            celular=in.nextLine();
                            System.out.println("Quantidade de dias de hospedagem:");
                            diasDeHospedagem=in.nextInt();in.nextLine();
                            System.out.println("Data do Check-In:");
                            System.out.println("Dia: ");
                            dia = in.nextInt(); in.nextLine(); 
                            while(dia < 1 || dia > 31){
                                System.out.println("Dia inválido! Digite um número entre 1 e 31: ");
                                dia = in.nextInt(); in.nextLine(); 
                            }
                            System.out.println("Mês: ");
                            mes = in.nextInt(); in.nextLine();
                            while(mes < 1 || mes > 12){
                                System.out.println("Mês inválido! Digite um número entre 1 e 12: ");
                                mes = in.nextInt(); in.nextLine();
                            }
                            mes--;
                            System.out.println("Ano: ");
                            ano = in.nextInt(); in.nextLine();
                            diaDoCheckIn = new GregorianCalendar(ano, mes, dia);
                            
                            sistema.reserva(nome, cpf, celular, diasDeHospedagem, diaDoCheckIn, tipoCama, chave, extras);
                        }
                    } 
                    catch(NomeException | CpfException | CelularException | DataException | OpcaoExtrasException e){
                        System.out.println("Erro nos dados da reserva: " + e.getMessage());
                        sq.checkOutDoCliente(chave);
                    }
                    catch(InputMismatchException e){
                        System.out.println("Erro nos dados da reserva: Dado inválido, provavelmente foi colocado uma letra ao invés de caracteres numéricos em alguma parte da reserva.");
                        sq.checkOutDoCliente(chave);
                    }
                    System.out.println();
                break;
                
                case '2':
                    try {
                        System.out.println("Digite dados do cliente para  realização do Check-In");
                        System.out.println("Nome:");
                        nome=in.nextLine();
                        System.out.println("CPF (Ex: 000.000.000-00):");
                        cpf=in.nextLine();
                        cl=new Cliente(nome, cpf);
                        sistema.checkIn(cl);
                    } 
                    catch(NomeException | CpfException | IllegalArgumentException e){
                        System.out.println("Erro nos dados da reserva: " + e.getMessage());
                    }
                    catch (IndexOutOfBoundsException e) {
                        System.out.println("Erro inesperado no sistema de check-out, tente novamente.");
                    }
                    System.out.println();
                break;

                case '3':
                    try {
                        System.out.println("Digite dados do cliente para realização do Check-Out");
                        System.out.println("Nome:");
                        nome=in.nextLine();
                        System.out.println("CPF (Ex: 000.000.000-00):");
                        cpf=in.nextLine();
                        cl=new Cliente(nome, cpf);
                        sistema.checkOut(cl, sq); 
                    }
                    catch(NomeException | CpfException | IllegalArgumentException e){
                        System.out.println("Erro nos dados da reserva: " + e.getMessage());
                    }
                    catch (IndexOutOfBoundsException e) {
                        System.out.println("Erro inesperado no sistema de check-out, tente novamente.");
                    }
                    System.out.println();
                break;

                case '4':
                    try {
                        sistema.exibirClientesParaCheckInHoje();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println();
                break;
                
                case '5':
                    try {
                        sistema.exibirClientesParaCheckOutHoje();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println();
                break;

                case '6':
                    sistema.exibirClientesHospedados();
                    System.out.println();
                break;

                case '7':
                    sistema.exibirTodosOsClientes();
                    System.out.println();
                break;

                case '8':
                    System.out.println("Tchau!");
                    System.out.println();
                break;

                default:
                    System.out.println("Opção Inválida, Tente Novamente");
                    System.out.println();
                break;
            }
        }while(escolha2!='8');
    }

    public static void telaMenuAposLogin(){
        System.out.println("Digite a opção desejada");
        System.out.println("1: Reservar quarto");
        System.out.println("2: Fazer Check-in");
        System.out.println("3: Fazer Checkout");
        System.out.println("4: Exibir Clientes Para Check-In de Hoje ");
        System.out.println("5: Exibir Clientes Para CheckOut de Hoje");
        System.out.println("6: Exibir os Clientes Hospedados");
        System.out.println("7: Exibir Todos Clientes");
        System.out.println("8: Voltar para tela inicial");

    }
}
