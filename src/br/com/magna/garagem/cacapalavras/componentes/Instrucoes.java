package br.com.magna.garagem.cacapalavras.componentes;

import br.com.magna.garagem.cacapalavras.modelos.Usuario;

public class Instrucoes {
	private static Usuario usuario;

	public Instrucoes(Usuario usuario) {
		Instrucoes.usuario = usuario;
	}

	public static void apresentarJogo() {
		System.out.println("\n ---------------------------------------------------------------- ");
		System.out.printf(" Seja bem vindo(a) ao meu Caça Palavras, %s!\n\n", Instrucoes.usuario.mostrarNome());
		System.out.println(" Para ganhar, você deve encontrar todas as palavras no tabuleiro.");
		System.out.println(" Quando encontrar uma palavra, digite a posição da primeira letra\n"
				+ " e da última letra da palavra encontrada.\n");
	}

	public static void mostrarInstrucoesDoJogo() {
		System.out.println(" As posições são separada por um traço: > - <.");
		System.out.println(" O formato de digitação das posições é: \"1,1-2,2\". Lembre-se:\n"
				+ " o primeiro número da posição é a linha, já o segundo, a coluna.\n");
		System.out.printf("%40s", " Tenha um bom jogo!\n");
		System.out.println(" ---------------------------------------------------------------- \n");
	}

}
