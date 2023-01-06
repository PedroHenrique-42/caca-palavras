package br.com.magna.garagem.controladores;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.magna.garagem.cacapalavras.Usuario;
import br.com.magna.garagem.jogo.Placar;

public class ControladorDoJogo {
	private Scanner leitorDeDados = new Scanner(System.in);

	// Pede ao jogador seu nome para utilizar na classe Usuario
	public String capturarNomeDoUsuario() {
		System.out.print("\n Por favor, digite aqui o seu nome: ");
		String nomeDoUsuario = this.leitorDeDados.nextLine();

		return nomeDoUsuario;
	}

	// Verifica se as posições digitadas pelo coincidem com alguma palavra no
	// tabuleiro
	public void verificarJogada(Map<String, String> tabuleiro, List<String> posicoesDigitadas, Usuario usuario) {
		usuario.realizarTentativa();
		
		if (tabuleiro.containsKey(posicoesDigitadas.get(0)) && tabuleiro.containsKey(posicoesDigitadas.get(1))
				&& (tabuleiro.get(posicoesDigitadas.get(0)) == tabuleiro.get("4,3")
						&& tabuleiro.get(posicoesDigitadas.get(1)) == tabuleiro.get("4,5"))) {

			System.out.println(" Palavra \"RUA\" encontrada com sucesso, parabéns!\n");
			tabuleiro.remove(posicoesDigitadas.get(0));
			tabuleiro.remove(posicoesDigitadas.get(1));
			usuario.pontuar();
			
			Placar.mostrarPontuacao(usuario.pegarPontuacao());
			Placar.mostrarQuantidadeDeTentativas(usuario.pegarTentativas());

		} else {
			System.out.println("\n Palavra não encontrada :(\n Por favor, tente novamente.\n");
		}

	}

	// Inicia o jogo
	public void iniciarJogo(Map<String, String> tabuleiro, Usuario usuario) {

		while (true) {
			List<String> posicoesDigitadas = new ControladorDeEntradaDeDados().validarEntrada();

			verificarJogada(tabuleiro, posicoesDigitadas, usuario);

			System.out.print(" Continuar jogo? Digite \"sim\" ou \"não\": ");
			String verificarContinuacao = leitorDeDados.nextLine();

			if (verificarContinuacao.equals("sim") || verificarContinuacao.equals("Sim")) {
				continue;
			} else {
				System.out.println(" Obrigado por jogar meu jogo, tenha um ótimo dia!");
				this.leitorDeDados.close();
				break;
			}
		}

	}

}
