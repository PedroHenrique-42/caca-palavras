package br.com.magna.garagem.cacapalavras;

import java.util.Map;

import br.com.magna.garagem.cacapalavras.controladores.ControladorDoJogo;
import br.com.magna.garagem.cacapalavras.jogo.Tabuleiro;

public class Principal {
	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		usuario.definirNome();

		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.criarTabuleiro();
		Map<String, String> coordenadasDasLetras = tabuleiro.pegarCoordenadasDasLetras();

		ControladorDoJogo controladorDoJogo = new ControladorDoJogo(coordenadasDasLetras, tabuleiro, usuario);

		System.out.println("\n ---------------------------------------------------------------- ");
		System.out.printf(" Seja bem vindo(a) ao meu Caça Palavras, %s!\n\n", usuario.mostrarNome());
		System.out.println(" Para ganhar, você deve encontrar todas as palavras no tabuleiro.");
		System.out.println(" Quando encontrar uma palavra, digite a posição da primeira letra\n"
				+ " e da última letra da palavra encontrada.\n");
		System.out.println(" As posições são separada por um traço: > - <.");
		System.out.println(" O formato de digitação das posições é: \"1,1-2,2\". Lembre-se:\n"
				+ " o primeiro número da posição é a linha, já o segundo, a coluna.\n");
		System.out.printf("%40s", " Tenha um bom jogo!\n");
		System.out.println(" ---------------------------------------------------------------- \n");

		controladorDoJogo.iniciarJogo();
	}
}