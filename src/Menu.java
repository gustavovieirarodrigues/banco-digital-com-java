import me.dio.banco.models.Banco;
import me.dio.banco.models.Conta;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    public Menu(Conta conta, Banco bancoDio){
       this.escolherOpcao(conta, bancoDio);
    }

    public void escolherOpcao(Conta conta, Banco bancoDio){
        int opcao = -1;

        while (opcao != 0) {


            System.out.println("###########"+bancoDio.getNome()+"###########");
            System.out.println("Digite a opcao desejada: \n" +
                    "1 - Consultar Saldo \n" +
                    "2 - Realizar Transferencia \n" +
                    "3 - Realizar Saque \n" +
                    "4 - Realizar Deposito \n" +
                    "0 - Sair");

            this.processarOpcao(opcao = this.scanner.nextInt(), conta, bancoDio);
        }
    }

    private void processarOpcao(int opcao, Conta conta, Banco bancoDio){
        switch (opcao) {

            case 1:
                conta.imprimirExtrato();
                break;

            case 2:
                System.out.println("Digite a agencia para deposito");
                int ag = this.scanner.nextInt();
                System.out.println("Digite a conta para deposito");
                int ct = this.scanner.nextInt();

                Conta ctTransferencia = this.localizaConta(bancoDio, ag,ct);

                if (ctTransferencia == null) {
                    System.out.println("Dados para transferencia invalido");
                } else {
                    System.out.println("Digite o valor para transferir");
                    conta.transferir(this.scanner.nextDouble(), ctTransferencia);
                }
                break;

            case 3:
                System.out.println("Digite o valor para saque");
                double valorSaque = this.scanner.nextDouble();
                conta.sacar(valorSaque);
                break;

            case 4:
                System.out.println("Digite o valor para deposito");
                conta.depositar(this.scanner.nextDouble());
                break;

            case 0:
                break;

            default:
                System.out.println("Selecione uma opcao valida");
                break;

        }
    }

    public Conta localizaConta(Banco bancoDio, int agencia, int conta){
        for (Conta c:bancoDio.getContas()) {
            if(c.getAgencia() == agencia && c.getNumero() == conta)
                return c;
        }
        return null;
    }

    public void depositar(Conta cliente, Conta contaDeposito, double valor){

    }

}
