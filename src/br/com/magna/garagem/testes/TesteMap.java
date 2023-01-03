package br.com.magna.garagem.testes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TesteMap {

	public static void main(String[] args) {
		Map<String, String> mapa = new HashMap<>();
		mapa.put("0,1", "A");
		mapa.put("0,2", "B");
		mapa.put("0,3", "C");
		mapa.put("0,4", "R");
		mapa.put("0,5", "U");
		mapa.put("0,6", "A");
		mapa.put("0,7", "G");
		mapa.put("0,8", "H");
		mapa.put("0,9", "I");
		
		
		mapa.put("1,1", "A");
		mapa.put("1,2", "V");
		mapa.put("1,3", "I");
		mapa.put("1,4", "A");
		mapa.put("1,5", "O");
		mapa.put("1,6", "A");
		mapa.put("1,7", "G");
		mapa.put("1,8", "H");
		mapa.put("1,9", "I");

		while (true) {
			Validador validadorDeEntrada = new Validador();
			String[] posicoes = validadorDeEntrada.validar();
			ControladorDoJogo controlador = new ControladorDoJogo();
			controlador.iniciarJogo(mapa, posicoes);

			@SuppressWarnings("resource")
			Scanner leitor = new Scanner(System.in);
			System.out.print("Continuar jogo? Digite \"sim\" ou \"não\": ");
			String verificarContinuacao = leitor.nextLine();

			if (verificarContinuacao.equals("sim")) {
				continue;
			} else if (verificarContinuacao.equals("não")) {
				System.out.println("Obrigado por jogar meu jogo, tenha um ótimo dia!");
				break;
			}
		}

	}
}
