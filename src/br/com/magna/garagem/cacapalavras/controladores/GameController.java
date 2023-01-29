package br.com.magna.garagem.cacapalavras.controladores;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import br.com.magna.garagem.cacapalavras.componentes.GameBoard;
import br.com.magna.garagem.cacapalavras.modelos.Player;

public class GameController {
	private String line = "----------------------------------------------------------------";

	private Scanner inputReader;
	private Player player;
	private GameBoard gameBoard;
	private Map<String, String> gameBoardWords;

	public GameController(Scanner inputReader, Player player, GameBoard gameBoard, Map<String, String> gameBoardWords) {
		this.inputReader = inputReader;
		this.player = player;
		this.gameBoard = gameBoard;
		this.gameBoardWords = gameBoardWords;
	}

	private String validatePlayerInput() {
		String typedPositions = "";

		while (true) {
			System.out.printf(" %s \n\n", line);
			System.out.print(" Digite aqui as posições da palavra encontrada: ");
			String playerInput = this.inputReader.nextLine();

			if (playerInput.matches("[0-5],[0-5]-[0-5],[0-5]")) {
				typedPositions = playerInput;
				return typedPositions;
			}

			System.out.println("\n Por favor, digite posições válidas! Utilize a formatação\n"
					+ " especificada no início do jogo: \"1,1-2,2\".");
			System.out.println(" Lembre-se: o primeiro número de cada posição, é a linha,\n"
					+ " já o segundo número de cada posição, é a coluna.\n");
		}
	}

	private void verifyAttempt(String typedPositions) {
		this.player.makeAttempt();

		for (Entry<String, String> word : this.gameBoardWords.entrySet()) {
			if (typedPositions.equals(word.getKey())) {
				System.out.printf(" Parabéns! Palavra %s encontrada.\n\n", word.getValue());
				this.player.score();
				this.gameBoardWords.remove(word.getKey());
				return;
			}
		}

		System.out.println(" Nenhuma palavra encontrada :(\n");
	}

	public void startGame() {
		while (true) {
			gameBoard.createBoard();
			System.out.println();

			verifyAttempt(validatePlayerInput());

			if (this.player.getScoring() == 3) {
				System.out.println(" Você encontrou todas as palavras!");
				finishGame();
				return;
			}
			System.out.print(" Continuar jogo? Digite \"sim\" ou \"não\": ");
			String verifyIfUserWantsToContinue = this.inputReader.nextLine().toLowerCase();
			System.out.println();

			if (verifyIfUserWantsToContinue.contains("sim")) {
				System.out.printf(" %s \n\n", line);
				continue;
			}

			finishGame();
			return;
		}
	}

	private void finishGame() {
		System.out.printf(" %s \n\n", line);
		System.out.println(" Obrigado por jogar meu jogo, " + this.player.showName() + ". Tenha um ótimo dia!");
		this.player.showScoring();
		this.player.showAttempts();
		this.inputReader.close();
	}
}
