package br.com.magna.garagem.cacapalavras;

import java.util.Scanner;

import br.com.magna.garagem.jogo.Tabuleiro;

public class Principal {
	public static void main(String[] args) {
		Scanner leitorDeDados = new Scanner(System.in);

		System.out.print("\n Por favor, digite aqui o seu nome: ");
		String nomeDoUsuario = leitorDeDados.nextLine();
		Usuario usuario = new Usuario(nomeDoUsuario);

		System.out.println("\n ---------------------------------------------------------------- ");
		System.out.printf(" Seja bem vindo ao meu Caça Palavras, %s!\n\n", usuario.getNome());
		System.out.println(" Para ganhar, você deve encontrar todas as palavras no tabuleiro.");
		System.out.println(" Quando encontrar uma palavra, digite a posição da primeira e da"
					   + "\n última letra da palavra encontrada.");
		System.out.println(" O formato de digitação das posições é: \"0,1-0,2\" .\n");
		System.out.printf("%40s", " Tenha um bom jogo!\n");
		System.out.println(" ---------------------------------------------------------------- \n");

		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.criarTabuleiro();
		usuario.realizarTentativa();
		
//		Placar.mostrarPontuacao(usuario.getPontuacao());
//		Placar.mostrarQuantidadeDeTentativas(usuario.getTentativas());
		
		leitorDeDados.close();
	}
}