package br.com.magna.garagem.cacapalavras;

import java.util.Map;
import java.util.Scanner;

import br.com.magna.garagem.cacapalavras.componentes.GameBoard;
import br.com.magna.garagem.cacapalavras.componentes.Instructions;
import br.com.magna.garagem.cacapalavras.controladores.GameController;
import br.com.magna.garagem.cacapalavras.modelos.Player;

public class Main {
	public static void main(String[] args) {
		Scanner inputReader = new Scanner(System.in);
		
		Player player = new Player();
		player.setName(inputReader);

		GameBoard gameBoard = new GameBoard();
		Map<String, String> gameBoardWords = gameBoard.getGameWords();

		GameController gameController = new GameController(inputReader, player, gameBoard, gameBoardWords);
		Instructions instructions = new Instructions();

		instructions.presentGame(player);
		instructions.showGameInstructions();
		gameController.startGame();
		
		inputReader.close();
	}
}