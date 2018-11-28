import java.util.Timer;
import java.util.TimerTask;

public class Cronometro {
	double SegundosPassados = 0;
	Timer MeuCronometro = new Timer();

	TimerTask Tarefa = new TimerTask() {
		@Override
		public void run() {
			SegundosPassados++;
			System.out.println("Segundos passados" + SegundosPassados / 1000);
		}
	};

	public void start() {
		MeuCronometro.scheduleAtFixedRate(Tarefa, 1, 1);
	};

	public void stop() {
		MeuCronometro.cancel();
		System.out.println("Segundos passados" + SegundosPassados / 1000);
	}
}
