package br.com.cacaPalavra.models;

import java.util.Random;

public class Tabuleiro {

	private int linhas = 10;
	private int colunas = 10;
	private String[][] matriz = new String[linhas][colunas];
	private String[] representaLinha = { "A", "B", "C", "D", "E", "F", "G", "H", "I" };
	private String[] representaColuna = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	private String[] iraque = { "i", "r", "a", "q", "u", "e" };
	private String[] malta = { "m", "a", "l", "t", "a" };
	private String[] ira = { "i", "r", "a" };
	private String[] peru = { "p", "e", "r", "u" };
	private String mascara = "*";

	// Caracteres possíveis para as strings aleatórias
	String caracteres = "abcdefghijklmnopqrstuvwxyz";

	// Gerador de números aleatórios
	Random rand = new Random();

	private void preencheTabulheiro() {
		for (int linha = 0; linha < linhas; linha++) {
			for (int coluna = 0; coluna < colunas; coluna++) {
				if (linha >= 1 && linha <= 9 && coluna == 0) {
					matriz[linha][coluna] = representaLinha[linha - 1];
				} else if (linha == 0 && coluna >= 1 && coluna <= 9) {
					// Transformando o valor da coluna em string
					Integer colunaInteger = (Integer) coluna;
					matriz[linha][coluna] = colunaInteger.toString();
				} else if (linha == 0 && coluna == 0) {
					matriz[linha][coluna] = " ";
				} else {
					// Gerar um índice aleatório para escolher um caractere aleatório na lista
					int index = rand.nextInt(caracteres.length());
					Character letra = caracteres.charAt(index);
					// Obter o caractere aleatório correspondente ao índice gerado
					matriz[linha][coluna] = String.valueOf(letra);
				}
			}
		}
	}

	public void tabuleiroInicial() {
		preencheTabulheiro();
		int indexIraque = 0;
		int indexMalta = 0;
		int indexIra = 0;
		int indexPeru = 0;

		for (int linha = 0; linha < linhas; linha++) {
			for (int coluna = 0; coluna < colunas; coluna++) {
				// Preenchendo iraque
				if (linha == 2 && coluna >= 2 && coluna <= 7) {
					matriz[linha][coluna] = iraque[indexIraque++];
				}
				// Preenchendo malta
				if (linha >= 4 && linha <= 8 && coluna == 7) {
					matriz[linha][coluna] = malta[indexMalta++];
				}
				// Preenchendo irã
				if (linha == 8 && coluna >= 4 && coluna <= 6) {
					matriz[linha][coluna] = ira[indexIra++];
				}
				// Preenchendo peru
				if (linha >= 4 && linha <= 7 && coluna == 2) {
					matriz[linha][coluna] = peru[indexPeru++];
				}
			}
		}
		imprimeTabuleiro();
	}

	public void imprimeTabuleiro() {

		for (int i = 0; i < 2; i++)
			System.out.println();
		System.out.println("=====================");
		System.out.println("===== TABULEIRO =====");
		System.out.println("=====================");
		for (int linha = 0; linha < linhas; linha++) {
			for (int coluna = 0; coluna < colunas; coluna++) {

				System.out.print(matriz[linha][coluna]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public boolean verificaPalavra(int deLinha, int ateLinha, int deColuna, int ateColuna) {

		// verifica se a palavra já foi acertada
		if (matriz[deLinha][deColuna].compareTo(mascara) == 0 && matriz[ateLinha][ateColuna].compareTo(mascara) == 0)
			return false;
		// Verifica malta e peru
		else if (deLinha == 4 && ateLinha == 8 && deColuna == 7 || deLinha == 4 && ateLinha == 7 && ateColuna == 2)
			return true;
		// Verifica iraque e irã
		else if (deLinha == 2 && deColuna == 2 && ateColuna == 7 || ateLinha == 8 && deColuna == 4 && ateColuna == 6)
			return true;
		return false;
	}

	public void removePalavra(int deLinha, int ateLinha, int deColuna, int ateColuna) {
		for (int linhaTabuleiro = 0; linhaTabuleiro < linhas; linhaTabuleiro++) {
			for (int colunaTabuleiro = 0; colunaTabuleiro < colunas; colunaTabuleiro++) {
				if (linhaTabuleiro >= deLinha && linhaTabuleiro <= ateLinha && colunaTabuleiro >= deColuna && colunaTabuleiro <= ateColuna)
					matriz[linhaTabuleiro][colunaTabuleiro] = mascara;
			}
		}
	}

	public String[] getRepresentaLinha() {
		return representaLinha;
	}

	public String[] getRepresentaColuna() {
		return representaColuna;
	}

}
