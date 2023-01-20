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
		String caracterLetraEncontrada = "#";

		System.out.println(" As palavras são: BOLA, CARRO e RUA\n");

		System.out.println("     0   1   2   3   4   5");

		for (Integer linha = 0; linha < this.tabuleiro.length; linha++) {
			System.out.println(linhaDoTabuleiro);

			for (Integer coluna = 0; coluna < this.tabuleiro[linha].length; coluna++) {
				if (coluna == 0) {
					System.out.print(" " + linha + " | ");
				}

				if (linha == 4 && coluna == 3) {
					this.tabuleiro[linha][coluna] = palavras.containsKey("4,3-4,5") ? "R" : caracterLetraEncontrada;
				} else if (linha == 4 && coluna == 4) {
					this.tabuleiro[linha][coluna] = palavras.containsKey("4,3-4,5") ? "U" : caracterLetraEncontrada;
				} else if (linha == 4 && coluna == 5) {
					this.tabuleiro[linha][coluna] = palavras.containsKey("4,3-4,5") ? "A" : caracterLetraEncontrada;
				}

				else if (linha == 0 && coluna == 1) {
					this.tabuleiro[linha][coluna] = palavras.containsKey("0,1-0,4") ? "B" : caracterLetraEncontrada;
				} else if (linha == 0 && coluna == 2) {
					this.tabuleiro[linha][coluna] = palavras.containsKey("0,1-0,4") ? "O" : caracterLetraEncontrada;
				} else if (linha == 0 && coluna == 3) {
					this.tabuleiro[linha][coluna] = palavras.containsKey("0,1-0,4") ? "L" : caracterLetraEncontrada;
				} else if (linha == 0 && coluna == 4) {
					this.tabuleiro[linha][coluna] = palavras.containsKey("0,1-0,4") ? "A" : caracterLetraEncontrada;
				}

				else if (linha == 1 && coluna == 0) {
					this.tabuleiro[linha][coluna] = palavras.containsKey("1,0-5,0") ? "C" : caracterLetraEncontrada;
				} else if (linha == 2 && coluna == 0) {
					this.tabuleiro[linha][coluna] = palavras.containsKey("1,0-5,0") ? "A" : caracterLetraEncontrada;
				} else if (linha == 3 && coluna == 0) {
					this.tabuleiro[linha][coluna] = palavras.containsKey("1,0-5,0") ? "R" : caracterLetraEncontrada;
				} else if (linha == 4 && coluna == 0) {
					this.tabuleiro[linha][coluna] = palavras.containsKey("1,0-5,0") ? "R" : caracterLetraEncontrada;
				} else if (linha == 5 && coluna == 0) {
					this.tabuleiro[linha][coluna] = palavras.containsKey("1,0-5,0") ? "O" : caracterLetraEncontrada;
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
