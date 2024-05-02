package br.com.cacaPalavra.models;

import java.util.Timer;
import java.util.TimerTask;

public class Cronometro {

	private Timer cronometro;
	private int segundosDecorridos; // Variável para armazenar o tempo decorrido
	private int tempoLimite = 300;

	public Cronometro() {
		this.cronometro = new Timer();
	}

	public void iniciarCronometro() {

		// cria uma nova tarefa (Task) para ser executada repetidamente em intervalos
		// fixos usando um objeto Timer
		cronometro.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				// Incrementa os segundos decorridos a cada segundo
				segundosDecorridos++;
				if(tempoLimite == segundosDecorridos) {
					System.out.println("Tempo limite atingido, infelizmente você perdeu!");
					System.exit(0);
				}

			}
		}, 0, 1000); // Inicia o cronômetro e atualiza a cada segundo
	}

	public void pararCronometro() {
		cronometro.cancel();
	}

	// Método para obter o tempo decorrido
	public int getTempoDecorrido() {
		return segundosDecorridos;
	}
}
