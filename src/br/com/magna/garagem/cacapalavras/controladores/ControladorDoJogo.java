package br.com.magna.garagem.cacapalavras.controladores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.magna.garagem.cacapalavras.Usuario;
import br.com.magna.garagem.cacapalavras.jogo.Placar;
import br.com.magna.garagem.cacapalavras.jogo.Tabuleiro;

public class ControladorDoJogo {
	private final Scanner leitorDeDados = new Scanner(System.in);
	private Map<String, String> coordenadasDasLetras;
	private Tabuleiro tabuleiro;
	private Usuario usuario;

	public ControladorDoJogo(Map<String, String> coordenadasDasLetras, Tabuleiro tabuleiro, Usuario usuario) {
		this.coordenadasDasLetras = coordenadasDasLetras;
		this.usuario = usuario;
		this.tabuleiro = tabuleiro;
	}

	private List<String> validarEntrada() {

		List<String> posicoesDigitadas = new ArrayList<>(2);

		while (true) {
			System.out.print(" Digite aqui as posições da palavra encontrada: ");
			String entradaDeDados = leitorDeDados.nextLine();

			if (entradaDeDados.matches("[0-5],[0-5]-[0-5],[0-5]")) {
				posicoesDigitadas = Arrays.asList(entradaDeDados.split("-"));
				break;
			} else {
				System.out.println("\n Por favor, digite posições válidas! Utilize a formatação\n"
						+ " especificada acima: \"1,1-2,2\".");
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

			System.out.println(" Palavra \"RUA\" encontrada com sucesso, parabéns!\n");
			coordenadasDasLetras.remove(posicoesDigitadas.get(0));
			coordenadasDasLetras.remove(posicoesDigitadas.get(1));
			usuario.pontuar();
		} else if (coordenadasDasLetras.containsKey(posicoesDigitadas.get(0))
				&& coordenadasDasLetras.containsKey(posicoesDigitadas.get(1))
				&& (coordenadasDasLetras.get(posicoesDigitadas.get(0)) == coordenadasDasLetras.get("1,1")
						&& coordenadasDasLetras.get(posicoesDigitadas.get(1)) == coordenadasDasLetras.get("4,1"))) {

			System.out.println(" Palavra \"BOLA\" encontrada com sucesso, parabéns!\n");
			coordenadasDasLetras.remove(posicoesDigitadas.get(0));
			coordenadasDasLetras.remove(posicoesDigitadas.get(1));
			this.usuario.pontuar();
		}

		else {
			System.out.println("\n Palavra não encontrada :(\n Por favor, tente novamente.\n");
		}

	}

	public void iniciarJogo() {
		while (true) {
			tabuleiro.mostrarTabuleiro();
			System.out.println();

			List<String> posicoesDigitadas = validarEntrada();

			verificarJogada(posicoesDigitadas);

			if (this.usuario.pegarPontuacao() == 2) {
				System.out.println(" Parabéns! Você achou todas as palavras!");
				Placar.mostrarPontuacao(this.usuario.pegarPontuacao());
				Placar.mostrarQuantidadeDeTentativas(this.usuario.pegarTentativas());

				System.out.println(
						" Obrigado por jogar meu jogo, " + this.usuario.mostrarNome() + ". Tenha um ótimo dia!");
				this.leitorDeDados.close();
				break;
			}

			System.out.print(" Continuar jogo? Digite \"sim\" ou \"não\": ");
			String verificarContinuacao = this.leitorDeDados.nextLine();
			System.out.println();

			if (verificarContinuacao.contains("sim") || verificarContinuacao.contains("Sim")) {
				continue;
			} else {
				System.out.println(
						" Obrigado por jogar meu jogo, " + this.usuario.mostrarNome() + ". Tenha um ótimo dia!");
				Placar.mostrarPontuacao(this.usuario.pegarPontuacao());
				Placar.mostrarQuantidadeDeTentativas(this.usuario.pegarTentativas());
				this.leitorDeDados.close();
				break;
			}
		}

	}

}
