package br.com.magna.garagem.jogo;

import br.com.magna.garagem.cacapalavras.Usuario;

public class Instrucoes {
	
	public static void apresentarJogo() {
		Usuario usuario = new Usuario();
		
		System.out.println("\n ---------------------------------------------------------------- ");
		System.out.printf(" Seja bem vindo ao meu Caça Palavras, %s!\n", usuario.getNome());
		System.out.println(" Espero que sua experiência com meu jogo seja a melhor possível.\n");
		System.out.println(" Antes de começar, gostaria de lhe apresentar o objetivo do jogo:"
				+ "\n O jogo consiste em um tabuleiro com várias letras espalhadas."
				+ "\n Porém, algumas dessas letras vão formar palavras que você, " + usuario.getNome() 
				+ ",\n deve encontrar para ganhar o jogo."
				+ "\n\n É necessário jogar analisando o tabuleiro e digitando a posição da"
				+ "\n primeira e da última letra da palavra encontrada.");
	}
	
	public static void mostrarInstruçõesDeEntradaDeDados() {
		System.out.println(" O formato de digitação das posições é: \"0,1-0,2\". Cada conjunto"
					+ "\n de números, antes e depois do traço, representa a posição de uma letra."
					+ "\n\n O primeiro conjunto \"0,1\" é a primeira letra da palavra, e o segundo,"
					+ "\n \"0,2\" a última letra da palavra. "
					+ "\n [ATENÇÃO] O jogo não aceita posições digitadas fora do padrão estabelecido.");
		System.out.println(" Lembre-se que, o primeiro número da posição sempre será a linha."
						+"\n Já o segundo número da posição, sempre será a coluna."
					+ "\n\n                       Tenha um bom jogo!");
		System.out.println(" ---------------------------------------------------------------- ");
	}
	
}
