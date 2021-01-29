import java.util.Scanner;

public class App {

	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean jugar = true;
		char tablero[][] = {{'X', '·', 'X', '·', 'X', '·', 'X', '·'},
							{'·', 'X', '·', 'X', '·', 'X', '·', 'X'},
							{'·', '·', '·', '·', '·', '·', '·', '·'},
							{'·', '·', '·', '·', '·', '·', '·', '·'},
							{'·', '·', '·', '·', '·', '·', '·', '·'},
							{'·', '·', '·', '·', '·', '·', '·', '·'},
							{'O', '·', 'O', '·', 'O', '·', 'O', '·'},
							{'·', 'O', '·', 'O', '·', 'O', '·', 'O'}};
		
		// true = O - false = x
		boolean turno = true;
		
		cargarMenu();
		
		int input = teclado.nextInt();
		
		if(input == 1) {
			jugar(tablero);
		} else if (input == 2) {
			//cargar();
		} else {
			jugar = false;
		}
		
	}

	private static void jugar(char[][] tablero) {
		
		mostrarTablero(tablero);
		
	}

	private static void mostrarTablero(char[][] tablero) {
		// TODO Auto-generated method stub
		
		System.out.print("  0  1  2  3  4  5  6  7  ");
		for (int i = 0; i < tablero.length; i++) {
			System.out.println();
			System.out.print(i);
			for (int j = 0; j < tablero[i].length; j++) {

				
				System.out.print(" " + tablero[i][j] + " ");
			}
		}
		System.out.println();
		
	}

	private static void cargarMenu() {
		// TODO Auto-generated method stub
		
		System.out.println("[1] - Nueva partida \n"
				+ "[2] - Cargar partida \n"
				+ "[3] - Salir");

	}

}
