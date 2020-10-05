//Lissa Bruna Urbano 120780
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

    public String getNumeroConta() {  
        return numeroConta; 
    }

    public double getSaldo() {   
        return saldo;
    }

    public double getLimiteEspecial() {  
        return limiteEspecial;
    }

    public String getCliente() {  
        return cliente;
    }

    public void setCliente(String nomeCliente) { 
        this.cliente = nomeCliente;
    }

    @Override
    public String toString() {
        return "ContaCorrente [cliente= " + cliente + ", limiteEspecial= " + limiteEspecial + ", numeroConta= "
                + numeroConta + ", saldo= " + saldo + "]";
    }

    
}