public class ContaCorrente {
    
    private String numeroConta;
    private double saldo;
    private double limiteEspecial;
    private String cliente;

    public ContaCorrente(String numeroConta, String nomeCliente, double limiteEspecial) { 
        this.numeroConta = numeroConta;
        this.saldo = 0;
        this.cliente = nomeCliente;
        this.limiteEspecial = limiteEspecial;
    }

    public void depositar(double valorDeposito) { 
        if (valorDeposito > 0) {
            this.saldo = this.saldo + valorDeposito;
            System.out.println("Depósito efetuado com sucesso!");
        } else{
            System.out.println("Valor de depósito inválido!");
        }
    }

    public void sacar(double valorSaque){

        double limiteSaldoNegativo = (limiteEspecial*-1); 
        if ((this.saldo - valorSaque) >= limiteSaldoNegativo) {
            this.saldo -= valorSaque;
            System.out.println("Saque efetuado com sucesso!");
        } else{
            System.out.println("Saldo insuficiente para saque!");
        }
    }

    //getters e setters
    public String getNumeroConta() {  
        return numeroConta; 
    }

    public double getSaldo() {   
        return saldo;
    }

    public double getLimiteEspecial() {  
        return limiteEspecial;
    }

    public void setLimiteEspecial(float novoValorlimiteEspecial) { 
        if (novoValorlimiteEspecial >= 0) {
            this.limiteEspecial = novoValorlimiteEspecial;
            System.out.println("Limite Especial alterado para: R$= " + this.limiteEspecial + ".");
        } else {
            System.out.println("Impossivel alterar valor do Limite especial! valor informado menor que zero.");
        }
    }

    public String getCliente() {  
        return cliente;
    }

    public void setCliente(String nomeCliente) { 
        this.cliente = nomeCliente;
    }
}