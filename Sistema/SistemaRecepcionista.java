package Sistema;

import java.util.Calendar;
import java.util.LinkedList;

import Quarto.SistemaDeQuartos;
import TipoPessoa.Cliente;

public class SistemaRecepcionista {
    
    private LinkedList<Cliente> clientesParaCheckIn;
    private LinkedList<Cliente> clientesHospedados;
    private Calendar hoje;

    public SistemaRecepcionista(){
        this.clientesParaCheckIn = new LinkedList<Cliente>();
        this.clientesHospedados = new LinkedList<Cliente>();
    }

    public void reserva(String nome, String cpf, String celular, int diasHospedagem, Calendar diaDoCheckIn, boolean tipoCama, double valorInicial, int chave, boolean extras){
        Cliente novo = new Cliente(nome, cpf, celular, diasHospedagem, diaDoCheckIn, tipoCama, valorInicial, chave, extras);
        this.clientesParaCheckIn.addLast(novo);
        System.out.println("Novo cliente adicionado com sucesso !");
    }

    public void checkIn(Cliente n){ // n só terá nome e cpf
        int posicao = buscarCliente(n, this.clientesParaCheckIn);
        if(posicao == -1){
            System.out.println("Cliente não encontrado, tente novamente !");
        }
        else if(!compareData(this.clientesParaCheckIn.get(posicao).getDiaCheckIn())){
            System.out.println("Hoje não é o dia do check-in deste cliente !");
        }
        else{
            Cliente novoClienteHospedado = this.clientesParaCheckIn.get(posicao);
            novoClienteHospedado.setSituacao();
            this.clientesHospedados.addLast(novoClienteHospedado);
            this.clientesParaCheckIn.remove(novoClienteHospedado);
            System.out.println("Check-in do cliente realizado com sucesso !");
        }
    }

    public void checkOut(Cliente n, SistemaDeQuartos sq){
        int posicao = buscarCliente(n, this.clientesHospedados);
        if(posicao == -1){
            System.out.println("Cliente não encontrado, tente novamente !");
        }
        else if(!compareData(this.clientesHospedados.get(posicao).getDiaDoCheckOut())){
            System.out.println("Hoje não é o dia do check-out deste cliente !");
        }
        else{
            sq.checkOutDoCliente(this.clientesHospedados.get(posicao).getChave());
            this.clientesHospedados.remove(this.clientesHospedados.get(posicao));
            System.out.println("Check-out do cliente realizado com sucesso !");
        }
    }

    private boolean compareData(Calendar data){
        this.hoje = Calendar.getInstance();
        return data.get(Calendar.YEAR) == this.hoje.get(Calendar.YEAR) && data.get(Calendar.MONTH) == this.hoje.get(Calendar.MONTH) && data.get(Calendar.DAY_OF_MONTH) == this.hoje.get(Calendar.DAY_OF_MONTH);
    }

    private int buscarCliente(Cliente n, LinkedList<Cliente> lista){
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).equals(n)){
                return i;
            }
        }
        return -1;
    }

    public void exibirClientesParaCheckInHoje(){
        if(this.clientesParaCheckIn.size() == 0){
            System.out.println("Nenhum cliente para realizar o check-in no momento.");
        }
        else{
            boolean vazio = true;
            for(int i = 0; i < this.clientesParaCheckIn.size(); i++){ 
                if(compareData(this.clientesParaCheckIn.get(i).getDiaCheckIn())){ 
                    System.out.println(this.clientesParaCheckIn.get(i));
                    vazio = false;
                }
            }

            if(vazio){
                System.out.println("Nenhum cliente com check-in marcado para hoje.");
            }
        }
    }

    public void exibirClientesHospedados(){
        if(this.clientesHospedados.size() == 0){
            System.out.println("Nenhum cliente hospedado no momento.");
        }
        else{
            percorrerLista(this.clientesHospedados);
        }
    }

    public void exibirClientesParaCheckOutHoje(){ 
        if(this.clientesHospedados.size() == 0){
            System.out.println("Nenhum cliente hospedado no momento.");
        }
        else{
            boolean vazio = true;
            for(int i = 0; i < this.clientesHospedados.size(); i++){
                if(compareData(this.clientesHospedados.get(i).getDiaDoCheckOut())){ 
                    System.out.println(this.clientesHospedados.get(i));
                    vazio = false;
                }
            }

            if(vazio){
                System.out.println("Nenhum cliente com check-out marcado para hoje.");
            }
        }
    }

    public void exibirTodosOsClientes(){
        if(this.clientesParaCheckIn.size() == 0){
            System.out.println("Nenhum cliente para realizar o check-in no momento.");
        }
        else{
            percorrerLista(this.clientesParaCheckIn);
        }
        
        exibirClientesHospedados();
    }

    private void percorrerLista(LinkedList<Cliente> lista){
        for(int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i));
        }
    }
}
