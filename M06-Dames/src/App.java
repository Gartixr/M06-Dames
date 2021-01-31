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
			jugar(tablero, turno);
		} else if (input == 2) {
			//cargar();
		} else {
			jugar = false;
		}

	}

	private static void jugar(char[][] tablero, boolean turno) {

		boolean jugando = true;
		boolean turnoActual = turno;

		mostrarTablero(tablero);

		if (jugando) {
			moverPieza(tablero, turnoActual);
			turnoActual = !turnoActual;
			
			if(haTerminado()) {
				jugando = false;
			}
			
		}


	}

	private static void moverPieza(char[][] tablero, boolean turno) {
		// TODO Auto-generated method stub

		boolean piezaValida = false;

		while (!piezaValida) {
			System.out.println("Pieza a mover");
			System.out.println("Fila (0-7)");
			int fila = teclado.nextInt();
			System.out.println("Columna (0-7)");
			int columna = teclado.nextInt();
			System.out.println(tablero[fila][columna]);

			if(tablero[fila][columna] == 'O' && turno) {

				System.out.println("Nuevo destino");
				System.out.println("Fila (0-7)");
				int fila2 = teclado.nextInt();
				System.out.println("Columna (0-7)");
				int columna2 = teclado.nextInt();

				if(tablero[fila2][columna2] == 'X' || tablero[fila2][columna2] == '·') {
					tablero[fila][columna] = '·';
					tablero[fila2][columna2] = 'O';
					piezaValida = !piezaValida;
					mostrarTablero(tablero);
				}else {
					System.out.println("Movimiento invalido");
				}


			} else if(tablero[fila][columna] == 'X' && !turno){

				System.out.println("Nuevo destino");
				System.out.println("Fila (0-7)");
				int fila2 = teclado.nextInt();
				System.out.println("Columna (0-7)");
				int columna2 = teclado.nextInt();

				if(tablero[fila2][columna2] == 'O' || tablero[fila2][columna2] == '·') {
					tablero[fila][columna] = '·';
					tablero[fila2][columna2] = 'X';
					piezaValida = !piezaValida;
					mostrarTablero(tablero);
				}else {
					System.out.println("Movimiento invalido");
				}

			} else {
				System.out.println("Pieza/posición invalida");
			}
		}

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
