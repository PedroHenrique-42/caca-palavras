package br.com.magna.garagem.cacapalavras;

import java.util.Scanner;

public class Usuario {
	private String nome;
	private Integer pontuacao = 0;
	private Integer tentativas = 0;
	
	public String definirNome() {
		@SuppressWarnings("resource")
		Scanner leitor = new Scanner(System.in);
		System.out.print("\n Por favor, digite aqui o seu nome: ");
		this.nome = leitor.nextLine();

		return this.nome;
	}
	
	public String mostrarNome() {
		return this.nome;
	}

	public void pontuar() {
		this.pontuacao += 1;
	}

	public int pegarPontuacao() {
		return pontuacao;
	}

	public void realizarTentativa() {
		this.tentativas += 1;
	}

	public int pegarTentativas() {
		return tentativas;
	}
}
