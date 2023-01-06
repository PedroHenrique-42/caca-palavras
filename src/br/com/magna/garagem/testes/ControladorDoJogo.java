package br.com.magna.garagem.testes;

import java.util.Map;

public class ControladorDoJogo {

	public void iniciarJogo(Map<String, String> mapa, String[] posicoes) {
		if (mapa.containsKey(posicoes[0]) && mapa.containsKey(posicoes[1])
				&& (mapa.get(posicoes[0]) == mapa.get("0,4") && mapa.get(posicoes[1]) == mapa.get("0,6"))) {
			System.out.println("Palavra \"RUA\" encontrada com sucesso, parabéns!\n");
			mapa.remove(posicoes[0]);
			mapa.remove(posicoes[1]);
		} 
		else if (mapa.containsKey(posicoes[0]) && mapa.containsKey(posicoes[1])
					&& (mapa.get(posicoes[0]) == mapa.get("1,1") && mapa.get(posicoes[1]) == mapa.get("1,5"))) {
			System.out.println("Palavra \"AVIAO\" encontrada com sucesso, parabéns!\n");
			mapa.remove(posicoes[0]);
			mapa.remove(posicoes[1]);
		}
		else {
			System.out.println("\nPalavra errada ou não encontrada :(\nPor favor, tente novamente.\n");
		}
	}
}
