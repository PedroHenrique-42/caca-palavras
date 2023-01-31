package br.com.magna.garagem.cacapalavras.components;

import br.com.magna.garagem.cacapalavras.models.Player;

public class Instructions {
	private String line = "----------------------------------------------------------------";

	public void presentGame(Player player) {
		System.out.printf("\n %s \n", this.line);
		System.out.printf(" Seja bem vindo(a) ao meu Caça Palavras, %s!\n\n", player.showName());
		System.out.println(" Para ganhar, você deve encontrar todas as palavras no tabuleiro.");
		System.out.println(" Quando encontrar uma palavra, digite as posições da primeira\n"
				+ " e da última letra da palavra encontrada.\n");
	}

	public void showGameInstructions() {
		System.out.println(" As posições são separadas por um traço: > - <.");
		System.out.println(" O formato de digitação das posições é: \"1,1-2,2\". Lembre-se:\n"
				+ " o primeiro número da posição é a linha, já o segundo, a coluna.");
		System.out.println(" No exemplo, \"1,1\" é a posição da primeira letra, já \"2,2\" é a\n"
				+ " posição da última letra da palavra.\n");
		System.out.printf("%40s", " Tenha um bom jogo!\n");
		System.out.printf(" %s \n\n", this.line);
	}

}
