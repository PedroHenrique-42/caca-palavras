package br.com.magna.garagem.testes;

import java.util.Scanner;

public class Validador {

	public String[] validar() {
		@SuppressWarnings("resource")
		Scanner leitor = new Scanner(System.in);
		String[] posicoesDigitadas = new String[2];
		Boolean continuarLendoDados = Boolean.TRUE;
		
		while (continuarLendoDados) {
			System.out.print("Digite aqui as posições da palavra encontrada: ");
			String entradaDeDados = leitor.nextLine();

			if (entradaDeDados.matches("[0-9],[0-9]-[0-9],[0-9]")) {
				posicoesDigitadas = entradaDeDados.split("-");
				continuarLendoDados = Boolean.FALSE;
			} else {
				System.out.println("Por favor, digite posições válidas!\n");
			}
		}
		
		return posicoesDigitadas;
	}

}
