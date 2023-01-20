package br.com.magna.garagem.cacapalavras.componentes;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Tabuleiro {
	private String[][] tabuleiro = new String[6][6];
	private Map<String, String> palavras = new HashMap<>();

	public Tabuleiro() {
		palavras.put("0,1-0,4", "BOLA");
		palavras.put("4,3-4,5", "RUA");
		palavras.put("1,0-5,0", "CARRO");
	}

	public void criarTabuleiro() {
		Random letrasAleatorias = new Random();
		String linhaDoTabuleiro = "    -----------------------";

		System.out.println(" As palavras são: BOLA, CARRO e RUA\n");

		System.out.println("     0   1   2   3   4   5");

		for (Integer linha = 0; linha < this.tabuleiro.length; linha++) {
			System.out.println(linhaDoTabuleiro);

			for (Integer coluna = 0; coluna < this.tabuleiro[linha].length; coluna++) {
				if (coluna == 0) {
					System.out.print(" " + linha + " | ");
				}

				if (linha == 4 && coluna == 3) {
					this.tabuleiro[linha][coluna] = palavras.containsKey("4,3-4,5") ? "R" : "*";
				} else if (linha == 4 && coluna == 4) {
					this.tabuleiro[linha][coluna] = palavras.containsKey("4,3-4,5") ? "U" : "*";
				} else if (linha == 4 && coluna == 5) {
					this.tabuleiro[linha][coluna] = palavras.containsKey("4,3-4,5") ? "A" : "*";
				}

				else if (linha == 0 && coluna == 1) {
					this.tabuleiro[linha][coluna] = palavras.containsKey("0,1-0,4") ? "B" : "*";
				} else if (linha == 0 && coluna == 2) {
					this.tabuleiro[linha][coluna] = palavras.containsKey("0,1-0,4") ? "O" : "*";
				} else if (linha == 0 && coluna == 3) {
					this.tabuleiro[linha][coluna] = palavras.containsKey("0,1-0,4") ? "L" : "*";
				} else if (linha == 0 && coluna == 4) {
					this.tabuleiro[linha][coluna] = palavras.containsKey("0,1-0,4") ? "A" : "*";
				}

				else if (linha == 1 && coluna == 0) {
					this.tabuleiro[linha][coluna] = palavras.containsKey("1,0-5,0") ? "C" : "*";
				} else if (linha == 2 && coluna == 0) {
					this.tabuleiro[linha][coluna] = palavras.containsKey("1,0-5,0") ? "A" : "*";
				} else if (linha == 3 && coluna == 0) {
					this.tabuleiro[linha][coluna] = palavras.containsKey("1,0-5,0") ? "R" : "*";
				} else if (linha == 4 && coluna == 0) {
					this.tabuleiro[linha][coluna] = palavras.containsKey("1,0-5,0") ? "R" : "*";
				} else if (linha == 5 && coluna == 0) {
					this.tabuleiro[linha][coluna] = palavras.containsKey("1,0-5,0") ? "O" : "*";
				}

				else {
					char letraAleatoria = (char) letrasAleatorias.nextInt(65, 90);
					this.tabuleiro[linha][coluna] = String.valueOf(letraAleatoria);
				}

				System.out.print(this.tabuleiro[linha][coluna]);

				System.out.print(" | ");

			}
			System.out.println();
		}
		System.out.println(linhaDoTabuleiro);
	}

	public Map<String, String> pegarCoordenadasDasLetras() {
		return this.palavras;
	}
}
