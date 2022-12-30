package br.com.magna.garagem.cacapalavras;

public class Usuario {
	private static String nome;
	private int pontuacao;
	private int tentativas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		Usuario.nome = nome;
	}

	private void pontuar() {
		this.pontuacao += 1;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	private void realizarTentativa() {
		this.tentativas += 1;
	}

	public int getTentativas() {
		return tentativas;
	}
}
