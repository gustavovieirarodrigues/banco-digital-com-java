package me.dio.banco.models;

import lombok.Getter;
import lombok.Setter;

public class Cliente {

	@Getter
	@Setter
	private String nome;

	public Cliente(String nome) {
		this.nome = nome;
	}
}
