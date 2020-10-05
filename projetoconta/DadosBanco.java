//Lissa Bruna Urbano 120780
import java.util.ArrayList;

public class DadosBanco {
    
    private int numeroSugeridoParaConta = 1001;
    ArrayList<ContaCorrente> listaContas = new ArrayList<>(); 

    public String adicionarConta(String nome,Double limiteEspecial){

        String numeroConta = Integer.toString(numeroSugeridoParaConta);
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
