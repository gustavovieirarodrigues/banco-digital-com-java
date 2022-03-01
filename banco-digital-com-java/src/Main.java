import me.dio.banco.models.*;

import java.io.IOException;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Banco bancoDio = new Banco();

        bancoDio.setNome("me.dio.entidades.Banco Digital DIO");

        Cliente allan = new Cliente("Allan Duarte");
        Cliente maria = new Cliente("Maria Silva");
        Cliente joao = new Cliente("Joao Barbosa Gomes");

        Conta ccAllan = new ContaCorrente(allan, 12345L);
        Conta ppAllan = new ContaPoupanca(allan, 67890L);
        Conta ccMaria = new ContaCorrente(maria, 14785L);
        Conta ppMaria = new ContaPoupanca(maria, 29630L);
        Conta ccJoao = new ContaCorrente(joao, 30698L);
        Conta ppJoao = new ContaPoupanca(joao, 52147L);

        bancoDio.setContas(List.of(new Conta[]{ccAllan, ppAllan, ccJoao, ppJoao, ccMaria, ppMaria}));

        var scanner = new Scanner(System.in);

        System.out.println("Digite a agencia: ");
        int agencia = scanner.nextInt();
        System.out.println("Digite a conta: ");
        int conta = scanner.nextInt();
        System.out.println("Digite a senha: ");
        int senha = scanner.nextInt();


        for (Conta c : bancoDio.getContas()) {
            if (c.getAgencia() == agencia && c.getNumero() == conta && c.getSenha() == senha) {
                new Menu(c, bancoDio);
            }
        }
    }
}
