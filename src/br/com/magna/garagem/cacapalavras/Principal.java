package br.com.magna.garagem.cacapalavras;

import java.util.Map;

import br.com.magna.garagem.cacapalavras.componentes.Instrucoes;
import br.com.magna.garagem.cacapalavras.componentes.Tabuleiro;
import br.com.magna.garagem.cacapalavras.controladores.ControladorDoJogo;
import br.com.magna.garagem.cacapalavras.modelos.Usuario;

public class Principal {
	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		usuario.definirNome();

		Tabuleiro tabuleiro = new Tabuleiro();
		Map<String, String> palavrasDoTabuleiro = tabuleiro.pegarPalavras();

		ControladorDoJogo controladorDoJogo = new ControladorDoJogo(usuario, tabuleiro, palavrasDoTabuleiro);
		Instrucoes instrucoes = new Instrucoes(usuario);

		instrucoes.apresentarJogo();
		instrucoes.mostrarInstrucoesDoJogo();
		
		controladorDoJogo.iniciarJogo();
	}
}