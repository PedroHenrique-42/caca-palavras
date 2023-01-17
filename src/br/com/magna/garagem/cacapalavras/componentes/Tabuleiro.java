package br.com.magna.garagem.cacapalavras.componentes;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Tabuleiro {
	private String[][] tabuleiro = new String[6][6];
	private Map<String, String> coordenadasDasLetras = new HashMap<>();
	
	public Tabuleiro () {
		this.criarTabuleiro();
	}

	private void criarTabuleiro() {
		Random letrasAleatorias = new Random();

		for (Integer linha = 0; linha < this.tabuleiro.length; linha++) {

			for (Integer coluna = 0; coluna < this.tabuleiro[linha].length; coluna++) {
				if (linha == 4 && coluna == 3) {
					this.tabuleiro[linha][coluna] = "R";
				} else if (linha == 4 && coluna == 4) {
					this.tabuleiro[linha][coluna] = "U";
				} else if (linha == 4 && coluna == 5) {
					this.tabuleiro[linha][coluna] = "A";
				} else if (linha == 1 && coluna == 1) {
					this.tabuleiro[linha][coluna] = "B";
				} else if (linha == 2 && coluna == 1) {
					this.tabuleiro[linha][coluna] = "O";
				} else if (linha == 3 && coluna == 1) {
					this.tabuleiro[linha][coluna] = "L";
				} else if (linha == 4 && coluna == 1) {
					this.tabuleiro[linha][coluna] = "A";
				} else {
					char letraAleatoria = (char) letrasAleatorias.nextInt(65, 90);
					this.tabuleiro[linha][coluna] = String.valueOf(letraAleatoria);
				}

				this.pegarCoordenadasDasLetras().put(linha + "," + coluna, this.tabuleiro[linha][coluna]);
			}
		}
	}

	public void mostrarTabuleiro() {
		String linhaDoTabuleiro = "    -----------------------";

		System.out.println(" As palavras são: BOLA e RUA\n");
		
		System.out.println("     0   1   2   3   4   5");
		for (Integer linha = 0; linha < this.tabuleiro.length; linha++) {
			System.out.println(linhaDoTabuleiro);

			for (Integer coluna = 0; coluna < this.tabuleiro[linha].length; coluna++) {
				if (coluna == 0) {
					System.out.print(" " + linha + " | ");
				} 
				
				System.out.print(this.tabuleiro[linha][coluna]);
				
				System.out.print(" | ");
			}

			System.out.println();
		}

		System.out.println(linhaDoTabuleiro);
	}

	public Map<String, String> pegarCoordenadasDasLetras() {
		return this.coordenadasDasLetras;
	}
}
