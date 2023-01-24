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

	public void createBoard() {
		Random randomNumberGenerator = new Random();
		String boardLine = "    -----------------------";
		Character findedWordCharacter = '*';

		System.out.println(" As palavras são: BOLA, CARRO e RUA\n");
		System.out.println("     0   1   2   3   4   5");

		boolean gameWordsContainsBola = gameWords.containsKey("0,1-0,4");
		boolean gameWordsContainsCarro = gameWords.containsKey("1,0-5,0");
		boolean gameWordsContainsRua = gameWords.containsKey("4,3-4,5");

		for (Integer line = 0; line < this.gameBoard.length; line++) {
			System.out.println(boardLine);

			for (Integer column = 0; column < this.gameBoard[line].length; column++) {
				if (column == 0) {
					System.out.print(" " + line + " | ");
				}

				if (line == 0 && column == 1) {
					this.gameBoard[line][column] = gameWordsContainsBola ? 'B' : findedWordCharacter;
				} else if (line == 0 && column == 2) {
					this.gameBoard[line][column] = gameWordsContainsBola ? 'O' : findedWordCharacter;
				} else if (line == 0 && column == 3) {
					this.gameBoard[line][column] = gameWordsContainsBola ? 'L' : findedWordCharacter;
				} else if (line == 0 && column == 4) {
					this.gameBoard[line][column] = gameWordsContainsBola ? 'A' : findedWordCharacter;
				}

				else if (line == 1 && column == 0) {
					this.gameBoard[line][column] = gameWordsContainsCarro ? 'C' : findedWordCharacter;
				} else if (line == 2 && column == 0) {
					this.gameBoard[line][column] = gameWordsContainsCarro ? 'A' : findedWordCharacter;
				} else if (line == 3 && column == 0) {
					this.gameBoard[line][column] = gameWordsContainsCarro ? 'R' : findedWordCharacter;
				} else if (line == 4 && column == 0) {
					this.gameBoard[line][column] = gameWordsContainsCarro ? 'R' : findedWordCharacter;
				} else if (line == 5 && column == 0) {
					this.gameBoard[line][column] = gameWordsContainsCarro ? 'O' : findedWordCharacter;
				}

				else if ((line == 4 && column == 3)) {
					this.gameBoard[line][column] = gameWordsContainsRua ? 'R' : findedWordCharacter;
				} else if (line == 4 && column == 4) {
					this.gameBoard[line][column] = gameWordsContainsRua ? 'U' : findedWordCharacter;
				} else if (line == 4 && column == 5) {
					this.gameBoard[line][column] = gameWordsContainsRua ? 'A' : findedWordCharacter;
				} else {
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
