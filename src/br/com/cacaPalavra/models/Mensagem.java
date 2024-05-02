package br.com.cacaPalavra.models;

public class Mensagem {

	public void apresentacao() {
		System.out.println("===== 🔎 CAÇA PALAVRAS 🔎 =====");
		System.out.println("xscadvj SEJA BEM VINDO vkjnvkdj");
		System.out.println("O TEMA É: 🗺️ PAÍSES 🗺️");
		System.out.println("=========== REGRAS ============");
		System.out.println("1 - Você pode errar até 4 vezes;");
		System.out.println("1 - Você tem apenas 5 minutos 🕗;");
		System.out.println("2 - Digite as coordenadas da palavra.");
		System.out.println("2 - Os países estão sem acentuanção, preste atenção.");
		System.out.println("3 - O caça-palavras possui 4 países.");
		System.out.println("==========================================");
		System.out.println("🔥Boa sorte e SEJA BEM VINDO AOS JOGOS!🔥");
		System.out.println("==========================================");
	}


	public void palavraCerta() {
		System.out.println("================================");
		System.out.println("Parabéns, você acertou");
		System.out.println("================================");
	}

	public void palavraErrada() {
		System.out.println("================================");
		System.out.println("Palavra errada");
		System.out.println("================================");
	}

	public void perdeu() {
		System.out.println("================================");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("--------------------------------------------------------");
		System.out.println("VOCÊ ATINGIU O LIMITE DE ERROS, INFELIZMENTE VOCÊ PERDEU.");
		System.out.println("--------------------------------------------------------");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("================================");
	}

	public void ganhou() {
		System.out.println("================================");
		System.out.println("🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆");
		System.out.println("----------------------------------------------");
		System.out.println("PARABÉNS, VOCÊ ACHOU TODOS OS PAÍSES!!!");
		System.out.println("----------------------------------------------");
		System.out.println("🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆");
		System.out.println("================================");
	}
	
	public void tempoLimimte() {
		System.out.println("================================");
		System.out.println("🕗🕗🕗🕗🕗🕗🕗🕗🕗🕗🕗🕗🕗🕗🕗🕗🕗🕗");
		System.out.println("----------------------------------------------");
		System.out.println("INFELIZMENTE VOCÊ ATINGIU O TEMPO LIMITE! :(");
		System.out.println("----------------------------------------------");
		System.out.println("🕗🕗🕗🕗🕗🕗🕗🕗🕗🕗🕗🕗🕗🕗🕗🕗🕗🕗");
		System.out.println("================================");

	}
	

}
