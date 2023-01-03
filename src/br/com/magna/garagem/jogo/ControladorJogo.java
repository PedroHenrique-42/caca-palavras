package br.com.magna.garagem.jogo;

public class ControladorJogo {

	public void validarEntrada(String entradaDeDados) {
		while (Boolean.TRUE) {
			System.out.print("\n Digite aqui as posições da primeira e da última letra da palavra"
						   + "\n encontrada: ");

			if (entradaDeDados.matches("[0-5],[0-5]-[0-5],[0-5]")) {
				System.out.println(" " + entradaDeDados);
				break;
			}
			System.out.println(" Valores inválidos");
			continue;
		}
	}

}
