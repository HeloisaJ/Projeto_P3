package Main;
import java.util.Scanner;

import Exceptions.CelularException;
import Exceptions.CpfException;
import Exceptions.FuncionarioException;
import Exceptions.NomeException;
import Exceptions.SenhaException;
import Exceptions.TurnoException;
import Funcionario.ListaFuncionarios;
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

        ListaFuncionarios lista = new ListaFuncionarios();
        SistemaDeQuartos sq = new SistemaDeQuartos();
        SistemaRecepcionista sistema = new SistemaRecepcionista();

        do{
            menuInicial();
            escolha=in.next().charAt(0); in.nextLine();
            System.out.println();

            switch(escolha){
                case '1':
                    try {
                        System.out.println("Interface de login");
                        System.out.println("Funcionário digite as seguintes informações para prosseguir");
                        System.out.println("Nome:");
                        nome=in.nextLine();
                        System.out.println("Senha:");
                        senha=in.nextLine();
                        lista.loginFuncionario(nome, senha);
                        MenuAposLogin.Menu(sq, sistema, in);
                    } 
                    catch (NomeException | SenhaException e) {
                        System.out.println("Erro nos dados do login: " + e.getMessage());
                    } 
                    catch(FuncionarioException e){
                        System.out.println("Erro ao fazer o login: " + e.getMessage());
                    }
                    System.out.println();
                break;

                case '2':
                    try {
                        System.out.println("Digite as seguintes informações para prosseguir");
                        System.out.println("Nome:");
                        nome=in.nextLine();
                        System.out.println("CPF (Ex: 000.000.000-00):");
                        cpf = in.nextLine();
                        System.out.println("Celular:");
                        celular = in.nextLine();
                        System.out.println("Turno (diurno ou noturno):"); // Ver como fazer, Diurno ou noturno
                        turno=in.nextLine();
                        turno = turno.toLowerCase();
                        System.out.println("Senha:");
                        senha=in.nextLine();
                        lista.cadastrarFuncionario(nome, cpf, celular, turno, senha);
                        System.out.println("Funcionário cadastrado com sucesso!");
                    } 
                    catch (NomeException | CpfException | CelularException | TurnoException | SenhaException e) {
                        System.out.println("Erro nos dados do cadastro: " + e.getMessage());
                    } 
                    System.out.println();
                break;

                case '3':
                    try {
                        System.out.println("Digite as seguintes informações para prosseguir");
                        System.out.println("Nome:");
                        nome=in.nextLine();
                        System.out.println("Senha:");
                        senha=in.nextLine();
                        lista.removerFuncionario(nome, senha);
                        System.out.println("Funcionário removido do sistema com sucesso!");
                    } 
                    catch (NomeException | SenhaException e) {
                        System.out.println("Erro nos dados do funcionário para remover: " + e.getMessage());
                    } 
                    catch(FuncionarioException e){
                        System.out.println("Erro na execução da ação: " + e.getMessage());
                    }
                    System.out.println();
                break;

                case '4':
                    try {
                        lista.exibirFuncionarios();
                    } catch (FuncionarioException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println();
                break;

                case '5':
                    System.out.println("Tchau!");
                break;

                default:
                    System.out.println("Opção Inválida, Tente Novamente");
                break;
            }
        }while(escolha !='5');   

        in.close();
    }

    public static void menuInicial(){
        System.out.println("Digite a opção desejada: ");
        System.out.println("1 para fazer login de funcionário");
        System.out.println("2 adicionar novo funcionário");
        System.out.println("3 remover funcionário");
        System.out.println("4 exibir funcionários");
        System.out.println("5 finalizar programa(Não finalizar sem backup)");
    }
}
