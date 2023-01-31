package br.com.magna.garagem.cacapalavras.models;

import java.util.Scanner;

public class Player {
	private String name;
	private Integer scoring = 0;
	private Integer attempts = 0;
	
	public String setName(Scanner inputReader) {
		System.out.print("\n Por favor, digite aqui o seu nome: ");
		this.name = inputReader.nextLine();

		return this.name;
	}

	public String showName() {
		return this.name;
	}

	public void score() {
		this.scoring += 1;
	}

	public int getScoring() {
		return scoring;
	}

	public void showScoring() {
		System.out.println(" Sua pontuação: " + this.scoring);
	}

	public void makeAttempt() {
		this.attempts += 1;
	}

	public void showAttempts() {
		System.out.println(" Tentativas realizadas: " + this.attempts + "\n");
	}
	
	
}
