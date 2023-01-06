package br.com.magna.garagem.cacapalavras;

import br.com.magna.garagem.controladores.ControladorDoJogo;
import br.com.magna.garagem.jogo.Tabuleiro;

public class Principal {
	public static void main(String[] args) {

		ControladorDoJogo controladorDoJogo = new ControladorDoJogo();
		Usuario usuario = new Usuario(controladorDoJogo.capturarNomeDoUsuario());

		System.out.println("\n ---------------------------------------------------------------- ");
		System.out.printf(" Seja bem vindo(a) ao meu Caça Palavras, %s!\n\n", usuario.pegarNome());
		System.out.println(" Para ganhar, você deve encontrar todas as palavras no tabuleiro.");
		System.out.println(" Quando encontrar uma palavra, digite a posição da primeira e da\n"
						 + " última letra da palavra encontrada.\n");
		System.out.println(" O formato de digitação das posições é: \"1,1-2,2\". Lembre-se:\n"
						 + " o primeiro número da posição é a linha, já o segundo, a coluna.\n");
		System.out.printf("%40s", " Tenha um bom jogo!\n");
		System.out.println(" ---------------------------------------------------------------- \n");

		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.criarTabuleiro();

		controladorDoJogo.iniciarJogo(tabuleiro.pegarCoordenadasDasLetras(), usuario);

	}
}