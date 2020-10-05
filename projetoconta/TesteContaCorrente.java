//Lissa Bruna Urbano 120780
import java.util.Scanner;

public class TesteContaCorrente {

    static Scanner scan = new Scanner(System.in);
    static DadosBanco banco = new DadosBanco();

    public static void main(String[] args) {

        int opcaoMenu;

        do {

            desenharMenu();

            System.out.print("Digite a opção desejada: ");
            opcaoMenu = Integer.parseInt(scan.nextLine()); //criar conta
            
            if (opcaoMenu == 1) {
                executarOpcaoCadastro();
            } else if (opcaoMenu == 2) { //deposito
                executarOpcaoDepositar();
            } else if (opcaoMenu == 3) { //saque
                executarOpcaoSaque();
            } else if (opcaoMenu == 4) { //Saldo
                executarOpcaoSaldo();
            } else if (opcaoMenu == 5) { //somatório
                executarOpcaoSomatorio();
            } else if(opcaoMenu !=6){ //invalido
                System.out.println("Opção inválida! Digite novamente uma opção válida.");
            }         

        } while (opcaoMenu != 6); 

        scan.close();
    }

    public static void desenharMenu(){
        System.out.println("\n\n============ MENU ============\n\n" +
        "Selecione uma das opções a seguir:\n" +
        "Digite 1. Cadastrar uma nova conta corrente\n" +
        "Digite 2. Depositar\n" +
        "Digite 3. Saque\n" +
        "Digite 4. Ver Saldo\n" +
        "Digite 5. para mostrar o somatório de todos os saldos\n" +
        "Digite 6. Sair\n==============================\n");
    }

    static final String MENSAGEM_NUMEROCONTA = "Digite o numero da conta: ";
    static final String MENSAGEM_CONTAINVALIDA = "Número da conta inválido!";

    public static void executarOpcaoCadastro(){

        System.out.print("Digite o nome completo do cliente:");
        String nome = scan.nextLine();
        double limiteEspecial = 0;

        do {
            System.out.print("Digite o valor do limite Especial da conta:");
            limiteEspecial = Double.parseDouble(scan.nextLine());
        } while (limiteEspecial < 0);

        System.out.println("Conta criada com sucesso! o numero da conta é: " + banco.adicionarConta(nome, limiteEspecial));

    }

    public static void executarOpcaoDepositar(){
        
        System.out.println(MENSAGEM_NUMEROCONTA);
        String numeroContaInformado = scan.nextLine();

        ContaCorrente conta = banco.buscarConta(numeroContaInformado);

        if (conta != null) {

            System.out.print("Digite o valor desejado deposito:");
            double valorDeposito = Double.parseDouble(scan.nextLine());
            conta.depositar(valorDeposito);

        } else {
            System.out.println(MENSAGEM_CONTAINVALIDA);
        }

    }

    public static void executarOpcaoSaque(){
        
        System.out.println(MENSAGEM_NUMEROCONTA);
        String numeroContaInformado = scan.nextLine();

        ContaCorrente conta = banco.buscarConta(numeroContaInformado);

        if (conta != null) {

            System.out.print("Digite o valor desejado para saque:");
            double valorSaque = Double.parseDouble(scan.nextLine());
            conta.sacar(valorSaque);

        } else {
            System.out.println(MENSAGEM_CONTAINVALIDA);    
        }

    }

    public static void executarOpcaoSaldo(){
        
        System.out.println(MENSAGEM_NUMEROCONTA);
        String numeroContaInformado = scan.nextLine();

        ContaCorrente conta = banco.buscarConta(numeroContaInformado);

        if (conta != null) {

            System.out.println("Seu saldo é de R$ " + conta.getSaldo());

        } else {
            System.out.println(MENSAGEM_CONTAINVALIDA);    
        }

    }

    public static void executarOpcaoSomatorio(){
        
        System.out.println("O somatório do saldo dos clientes é igual a: " + banco.somatorioDeSaldos());

    }

}
