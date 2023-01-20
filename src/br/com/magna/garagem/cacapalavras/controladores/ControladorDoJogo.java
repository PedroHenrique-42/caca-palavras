package br.com.magna.garagem.cacapalavras.controladores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.magna.garagem.cacapalavras.componentes.Tabuleiro;
import br.com.magna.garagem.cacapalavras.modelos.Usuario;

public class ControladorDoJogo {
	private static final Scanner leitorDeDados = new Scanner(System.in);
	private Usuario usuario;
	
	private Map<String, String> coordenadasDasLetras;
	
	private Tabuleiro tabuleiro;

	public ControladorDoJogo(Usuario usuario, Tabuleiro tabuleiro, Map<String, String> coordenadasDasLetras) {
		this.coordenadasDasLetras = coordenadasDasLetras;
		this.usuario = usuario;
		this.tabuleiro = tabuleiro;
	}

	private List<String> validarEntrada() {
		List<String> posicoesDigitadas = new ArrayList<>(2);
		Boolean continuarVerificandoPosicoes = true;

		while (continuarVerificandoPosicoes) {
			System.out.print(" Digite aqui as posições da palavra encontrada: ");
			String entradaDeDados = ControladorDoJogo.leitorDeDados.nextLine();

			if (entradaDeDados.matches("[0-5],[0-5]-[0-5],[0-5]")) {
				posicoesDigitadas = Arrays.asList(entradaDeDados.split("-"));
				continuarVerificandoPosicoes = false;
			} else {
				System.out.println("\n Por favor, digite posições válidas! Utilize a formatação\n"
						+ " especificada no início do jogo: \"1,1-2,2\".");
				System.out.println(" Lembre-se: o primeiro número de cada posição, é a linha,\n"
						+ " já o segundo número de cada posição, é a coluna.\n");
			}
		}

		return posicoesDigitadas;
	}

	private void verificarJogada(List<String> posicoesDigitadas) {
		this.usuario.realizarTentativa();
		
		if (coordenadasDasLetras.containsKey(posicoesDigitadas.get(0))
				&& coordenadasDasLetras.containsKey(posicoesDigitadas.get(1))
				&& (coordenadasDasLetras.get(posicoesDigitadas.get(0)) == coordenadasDasLetras.get("4,3")
						&& coordenadasDasLetras.get(posicoesDigitadas.get(1)) == coordenadasDasLetras.get("4,5"))) {

			System.out.println(" Palavra \"RUA\" encontrada!\n");
			coordenadasDasLetras.remove(posicoesDigitadas.get(0));
			coordenadasDasLetras.remove(posicoesDigitadas.get(1));
			usuario.pontuar();
		} else if (coordenadasDasLetras.containsKey(posicoesDigitadas.get(0))
				&& coordenadasDasLetras.containsKey(posicoesDigitadas.get(1))
				&& (coordenadasDasLetras.get(posicoesDigitadas.get(0)) == coordenadasDasLetras.get("1,1")
						&& coordenadasDasLetras.get(posicoesDigitadas.get(1)) == coordenadasDasLetras.get("4,1"))) {

			System.out.println(" Palavra \"BOLA\" encontrada!\n");
			coordenadasDasLetras.remove(posicoesDigitadas.get(0));
			coordenadasDasLetras.remove(posicoesDigitadas.get(1));
			this.usuario.pontuar();
		} else {
			System.out.println("\n Palavra não encontrada :(\n Por favor, tente novamente.\n");
		}
	}

	public void iniciarFluxoDoJogo() {
		boolean continuarJogo = true;

		while (continuarJogo) {
			System.out.println(" As palavras são: BOLA e RUA\n");
			tabuleiro.mostrarTabuleiro();
			System.out.println();

			verificarJogada(validarEntrada());

			if (this.usuario.pegarPontuacao() == 2) {
				System.out.println(" Parabéns! Você achou todas as palavras!");
				encerrarJogo();
				continuarJogo = false;
			} else {
				System.out.print(" Continuar jogo? Digite \"sim\" ou \"não\": ");
				String perguntarSeDesejaContinuar = ControladorDoJogo.leitorDeDados.nextLine();
				System.out.println();

				if (perguntarSeDesejaContinuar.contains("sim") || perguntarSeDesejaContinuar.contains("Sim")) {
					System.out.println(" ----------------------------------------------------------------");
					continue;
				}

				encerrarJogo();
				continuarJogo = false;
			}
		}

	}

	public void encerrarJogo() {
		System.out.println(" Obrigado por jogar meu jogo, " + this.usuario.mostrarNome() + ". Tenha um ótimo dia!");
		this.usuario.mostrarPontuacao();
		this.usuario.mostrarQuantidadeDeTentativas();
		ControladorDoJogo.leitorDeDados.close();
	}
}
