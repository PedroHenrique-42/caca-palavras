package br.com.magna.garagem.controladores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ControladorDeEntradaDeDados {

	// Faz a validação se os dados digitados são compatíveis com a formatação e
	// números do tabuleiro
	public List<String> validarEntrada() {

		@SuppressWarnings("resource")
		Scanner leitorDeDados = new Scanner(System.in);
		List<String> posicoesDigitadas = new ArrayList<>(2);
		Boolean continuarLendoDados = Boolean.TRUE;

		while (continuarLendoDados) {
			System.out.print(" Digite aqui as posições da palavra encontrada: ");
			String entradaDeDados = leitorDeDados.nextLine();

			if (entradaDeDados.matches("[0-5],[0-5]-[0-5],[0-5]")) {
				posicoesDigitadas = Arrays.asList(entradaDeDados.split("-"));
				continuarLendoDados = Boolean.FALSE;
			} else {
				System.out.println(" Por favor, digite posições válidas! Utilize a formatação\n"
						+ " especificada acima: \"1,1-2,2\".\n");
			}
		}

		return posicoesDigitadas;

	}

}
