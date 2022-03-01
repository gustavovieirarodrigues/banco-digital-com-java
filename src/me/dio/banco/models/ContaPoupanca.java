package me.dio.banco.models;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente, long senha) {
		super(cliente, senha);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato me.dio.entidades.Conta Poupança ===");
		super.imprimirInfosComuns();
	}
}
