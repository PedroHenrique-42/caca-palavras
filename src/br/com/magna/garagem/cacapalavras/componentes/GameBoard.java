package br.com.magna.garagem.cacapalavras.componentes;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GameBoard {
	private Character[][] gameBoard = new Character[6][6];
	private Map<String, String> gameWords = new HashMap<>();

	public GameBoard() {
		gameWords.put("0,1-0,4", "BOLA");
		gameWords.put("1,0-5,0", "CARRO");
		gameWords.put("4,3-4,5", "RUA");
	}

	private void addWordInTheBoard(Integer initialLine, Integer initialColumn, String direction, String word) {
		Character wordFoundedCharacter = '*';

		if (direction.equals("vertical")) {
			for (int line = initialLine, index = 0; index < word.length(); line++, index++) {
				this.gameBoard[line][initialColumn] = gameWords.containsValue(word) ? word.charAt(index)
						: wordFoundedCharacter;
			}
			return;
		}

		for (int column = initialColumn, index = 0; index < word.length(); column++, index++) {
			this.gameBoard[initialLine][column] = gameWords.containsValue(word) ? word.charAt(index)
					: wordFoundedCharacter;
		}
	}

	public void createBoard() {
		Random randomNumberGenerator = new Random();
		String boardLine = "    -----------------------";

		System.out.println(" As palavras são: BOLA, CARRO e RUA\n");
		System.out.println("     0   1   2   3   4   5");

		for (Integer line = 0; line < this.gameBoard.length; line++) {
			System.out.println(boardLine);

			for (Integer column = 0; column < this.gameBoard[line].length; column++) {
				if (column == 0) {
					System.out.print(" " + line + " | ");
				}

				addWordInTheBoard(0, 1, "horizontal", "BOLA");
				addWordInTheBoard(1, 0, "vertical", "CARRO");
				addWordInTheBoard(4, 3, "horizontal", "RUA");

				if (this.gameBoard[line][column] == null) {
					this.gameBoard[line][column] = (char) randomNumberGenerator.nextInt(65, 90);
				}

				System.out.print(this.gameBoard[line][column]);
				System.out.print(" | ");
			}
			System.out.println();
		}
		System.out.println(boardLine);
	}

	public Map<String, String> getGameWords() {
		return this.gameWords;
	}
}
