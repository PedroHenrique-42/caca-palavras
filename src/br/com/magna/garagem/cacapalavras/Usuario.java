package br.com.magna.garagem.cacapalavras;

public class Usuario {
	private String nome;
	private Integer pontuacao = 0;
	private Integer tentativas = 0;
	
	Usuario(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void pontuar() {
		this.pontuacao += 1;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void realizarTentativa() {
		this.tentativas += 1;
	}

	public int getTentativas() {
		return tentativas;
	}
}
