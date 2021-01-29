import java.util.Scanner;

public class App {

	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean jugar = true;
		
		cargarMenu();
		
		int input = teclado.nextInt();
		
		if(input == 1) {
			
		} else if (input == 2) {
			
		} else {
			
		}
		
	}

	private static void cargarMenu() {
		// TODO Auto-generated method stub
		
		System.out.println("[1] - Nueva partida \n"
				+ "[2] - Cargar partida \n"
				+ "[3] - Salir");

	}

}
