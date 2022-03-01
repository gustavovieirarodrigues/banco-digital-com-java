package me.dio.banco.models;

public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente, long senha) {
		super(cliente, senha);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato me.dio.entidades.Conta Corrente ===");
		super.imprimirInfosComuns();
	}
	
}
