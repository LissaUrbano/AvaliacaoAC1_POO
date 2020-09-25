import java.util.ArrayList;

public class DadosBanco {
    
    //atributos
    private int numeroSugeridoParaConta = 1001;

    //Lista de objetos contas (todas as contascorretes do banco)
    ArrayList<ContaCorrente> listaContas = new ArrayList<>(); 



    //método que instacia uma nova conta e adiciona a lista
    public String adicionarConta(String nome,Double limiteEspecial){

        //converte int para string
        String numeroConta = Integer.toString(numeroSugeridoParaConta);

        //instancia uma nova conta
        ContaCorrente varConta = new ContaCorrente(numeroConta, nome, limiteEspecial);

        listaContas.add(varConta);

        numeroSugeridoParaConta++;
        return numeroConta;    
    }


    public ContaCorrente buscarConta(String numeroContaInformado){  
        
        for (int i = 0; i < listaContas.size(); i++) {  

            ContaCorrente varConta = listaContas.get(i);

            if (numeroContaInformado.equals(varConta.getNumeroConta())) { 
                
                return varConta;
            } 
        }
        return null;
    }

    public double somatorioDeSaldos(){

        double somatorioSaldo = 0;

        for (int i = 0; i < listaContas.size(); i++) {  

            ContaCorrente varConta = listaContas.get(i);
            
            if (varConta.getSaldo() > 0 ) { 
                
                somatorioSaldo += varConta.getSaldo();
            } 
        }
        return somatorioSaldo;
    }
}
