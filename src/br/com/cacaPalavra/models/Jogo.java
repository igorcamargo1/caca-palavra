package br.com.cacaPalavra.models;

import java.util.Scanner;

public class Jogo {

	private Mensagem mensagem = new Mensagem();
	private Tabuleiro tabuleiro = new Tabuleiro();
	private Cronometro cronometro = new Cronometro();
	private int erros;
	private int acertos;
	private String posicaoInicial;
	private String posicaoFinal;
	private Character linhaInicial;
	private Character linhaFinal;
	private Character colunaInicial;
	private Character colunaFinal;
	private String[] representaLinha = this.tabuleiro.getRepresentaLinha();
	private String[] representaColuna = this.tabuleiro.getRepresentaColuna();

	public void iniciaJogo() {

		//apresenta as regras do jogo
		this.mensagem.apresentacao();

		// Inicia o cronômetro
		this.cronometro.iniciarCronometro();

		while (erros < 4 || acertos < 4) {

			mostraTabuleiro();

			estatisticasJogo();

			verificaCoordenadasPalavra();

			verificaPalavraChutada();

			if (erros == 4) {
				this.mensagem.perdeu();
				this.cronometro.pararCronometro();
				break;
			}
			if (acertos == 4) {
				this.mensagem.ganhou();
				// Para o cronômetro ao final do jogo
				this.cronometro.pararCronometro();
				System.out.println("🕗 Seu tempo foi de:" + this.cronometro.getTempoDecorrido() + " segundos. 🕗");
				break;
			}
		}

	}

	private void verificaCoordenadasPalavra() {
		Scanner scan = new Scanner(System.in);

		// criando loop até trazer as coordenadas possíveis
		outerLoop: while (true) {
			try {
				System.out.println("Digite as coordenadas de onde COMEÇA a palavra");
				System.out.println("Exemplo: A2");
				posicaoInicial = scan.next(); // "A2"
				System.out.println("Digite as coordenadas de onde TERMINA a palavra");
				System.out.println("Exemplo: A9");
				posicaoFinal = scan.next(); // "A9"

				// Verificando se o tamanho das coordenadas é maior que 2
				if (posicaoInicial.length() > 2 || posicaoFinal.length() > 2) {
					System.out.println("As coordenadas devem ter no máximo 2 caracteres. Tente novamente.");
					continue; // Repete o loop se o tamanho das coordenadas for maior que 2
				}

				// Verificando se é uma linha possível
				linhaInicial = Character.toUpperCase(posicaoInicial.charAt(0)); // A
				linhaFinal = Character.toUpperCase(posicaoFinal.charAt(0)); // A
				colunaInicial = posicaoInicial.charAt(1); // 2
				colunaFinal = posicaoFinal.charAt(1); // 9

				//Verificando se a letra passada pelo usuário está contida no tabuleiro
				for (String linha : representaLinha) {
					if (linha.equals(linhaInicial.toString())) {
						break;
					}
				}
				for (String linha : representaLinha) {
					if (linha.equals(linhaFinal.toString())) {
						break;
					}
				}
				
				//Verificando se o número passado pelo usuário está contida no tabuleiro
				for (String coluna : representaColuna) {
					if (coluna.equals(colunaInicial.toString())) {
						break;
					}
				}
				for (String coluna : representaColuna) {
					if (coluna.equals(colunaFinal.toString())) {
						break outerLoop;
					}
				}

				System.out.println("posição inválida, digite igual no exemplo.");
				scan.nextLine();
			} catch (Exception e) {
				System.out.println("posição inválida, digite igual no exemplo.");
				scan.nextLine();
			}
		}
	}

	private void mostraTabuleiro() {
		if (acertos == 0) {
			this.tabuleiro.tabuleiroInicial();
		} else {
			this.tabuleiro.imprimeTabuleiro();
		}
	}

	private void estatisticasJogo() {
		System.out.println("================================");
		System.out.println("Você já errou: " + erros + " vez(es).");
		System.out.println("Você já achou: " + acertos + " palavra(s).");
		System.out.println("================================");
	}

	private void verificaPalavraChutada() {

		// preparando as variáveis para verificação
		int deLinha = verificaVariavelLista(representaLinha,linhaInicial);
		int ateLinha = verificaVariavelLista(representaLinha,linhaFinal);
		int deColuna = verificaVariavelLista(representaColuna,colunaInicial);
		int ateColuna = verificaVariavelLista(representaColuna,colunaFinal);

		boolean palavraCerta = this.tabuleiro.verificaPalavra(deLinha, ateLinha, deColuna, ateColuna);

		if (palavraCerta) {
			this.tabuleiro.removePalavra(deLinha, ateLinha, deColuna, ateColuna);
			this.mensagem.palavraCerta();
			acertos++;
		} else {
			this.mensagem.palavraErrada();
			erros++;
		}
	}

	//Pega a posição que o usuário passou e verifica qual o indice dentro da matriz
	private int verificaVariavelLista(String[] represenhaPosicaoMatriz, Character valorPosicaoUsuario) {
		int indice = 0;
		for (int posicao = 0; posicao < represenhaPosicaoMatriz.length; posicao++) {
			if (represenhaPosicaoMatriz[posicao].equals(String.valueOf(valorPosicaoUsuario))) {
				indice = posicao + 1;
			}
		}
		return indice;
	}
}
