package br.com.magna.garagem.cacapalavras.controladores;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import br.com.magna.garagem.cacapalavras.componentes.Tabuleiro;
import br.com.magna.garagem.cacapalavras.modelos.Usuario;

public class ControladorDoJogo {
	private static Scanner leitorDeDados = new Scanner(System.in);
	private static String linhaDeFormatacao = "----------------------------------------------------------------";
	
	private Usuario usuario;
	private Tabuleiro tabuleiro;
	private Map<String, String> palavras;
	
	public ControladorDoJogo(Usuario usuario, Tabuleiro tabuleiro, Map<String, String> coordenadasDasLetras) {
		this.palavras = coordenadasDasLetras;
		this.usuario = usuario;
		this.tabuleiro = tabuleiro;
	}

	private String validarEntrada() {
		String posicoesDigitadas = "";
		Boolean continuarVerificandoPosicoes = true;

		while (continuarVerificandoPosicoes) {
			System.out.printf(" %s \n\n", linhaDeFormatacao);
			System.out.print(" Digite aqui as posições da palavra encontrada: ");
			String entradaDeDados = ControladorDoJogo.leitorDeDados.nextLine();

			if (entradaDeDados.matches("[0-5],[0-5]-[0-5],[0-5]")) {
				posicoesDigitadas = entradaDeDados;
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

	private void verificarJogada(String posicoesDigitadas) {
		this.usuario.realizarTentativa();

		for (Entry<String, String> palavra : this.palavras.entrySet()) {
			if (posicoesDigitadas.equals(palavra.getKey())) {
				System.out.printf(" Parabéns! Palavra %s encontrada.\n\n", palavra.getValue());
				this.usuario.pontuar();
				this.palavras.remove(palavra.getKey());
				return;
			}
		}

		System.out.println(" Nenhuma palavra encontrada :(\n");
	}

	public void iniciarJogo() {
		boolean continuarJogo = true;

		while (continuarJogo) {
			tabuleiro.criarTabuleiro();
			System.out.println();

			verificarJogada(validarEntrada());

			if (this.usuario.pegarPontuacao() == 3) {
				System.out.println(" Parabéns! Você achou todas as palavras!");
				encerrarJogo();
				continuarJogo = false;
			} else {
				System.out.print(" Continuar jogo? Digite \"sim\" ou \"não\": ");
				String perguntarSeDesejaContinuar = ControladorDoJogo.leitorDeDados.nextLine().toLowerCase();
				System.out.println();

				if (perguntarSeDesejaContinuar.contains("sim")) {
					System.out.printf(" %s \n\n", linhaDeFormatacao);
					continue;
				}

				encerrarJogo();
				continuarJogo = false;
			}
		}

	}

	public void encerrarJogo() {
		System.out.printf(" %s \n\n", linhaDeFormatacao);
		System.out.println(" Obrigado por jogar meu jogo, " + this.usuario.mostrarNome() + ". Tenha um ótimo dia!");
		this.usuario.mostrarPontuacao();
		this.usuario.mostrarQuantidadeDeTentativas();
		ControladorDoJogo.leitorDeDados.close();
	}
}
