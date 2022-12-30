package br.com.magna.garagem.cacapalavras;
import java.util.Scanner;
import br.com.magna.garagem.jogo.*;


public class Principal {
	public static void main(String[] args) {
		Scanner leitorDeDados = new Scanner(System.in);
		
		Usuario usuario = new Usuario();
		System.out.print("\n Por favor, digite aqui o seu nome: ");
		usuario.setNome(leitorDeDados.nextLine());
		
		Instrucoes.apresentarJogo();
		Instrucoes.mostrarInstruçõesDeEntradaDeDados();
		
		System.out.println();
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.criarTabuleiro();
		
		System.out.println("\n Por favor, digite aqui as posições da primeira e última "
				+ "\n letra da palavra encontrada: ");
		
		leitorDeDados.close();
	}
}