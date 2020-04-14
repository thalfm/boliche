package br.com.boliche.services;

import java.util.List;

import br.com.boliche.models.Rodada;

public class CalculadoraPontuacaoBoliche {

	public static int pontuacaoDoJogo(List<Rodada> jogadas) {
		return jogadas.stream().mapToInt(rodada -> rodada.pontuacaoDaRodada()).sum();
	}
}
