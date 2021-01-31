import damas.entity.DatosPartida;
import damas.entity.Movimientos;
import damas.util.HibernateUtil;
import java.util.Scanner;
import org.hibernate.Session;

public class App {

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

                Session session = HibernateUtil.getSessionFactory().openSession();
            
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
			jugar(tablero, turno,session);
		} else if (input == 2) {
			//cargar();
		} else {
			jugar = false;
		}

	}

	private static void jugar(char[][] tablero, boolean turno, Session session) {

		boolean jugando = true;
		boolean turnoActual = turno;
                DatosPartida dp = new DatosPartida(turno, jugando);

		mostrarTablero(tablero);

		while (jugando) {
			moverPieza(tablero, turnoActual);
			turnoActual = !turnoActual;
                        dp.setTurno(turnoActual);

			if(haTerminado(tablero)) {
				jugando = false;
                                dp.setJugando(jugando);
			}else {
				System.out.print("Cambio de turno -> ");
				if(turnoActual) {
					System.out.print("O\n");
				}else {
					System.out.print("X\n");
				}
			}
                    session.save(dp);
		}


	}

	private static boolean haTerminado(char[][] tablero) {
		
		int contO = 0;
		int contX = 0;
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {

				if(tablero[i][j] == 'O') {
					contO++;
				}else if(tablero[i][j] == 'X') {
					contX++;
				}
				
				// Si O est· en fila 0 gana
				if(tablero[i][j] == 'O' && i == 0) {
					System.out.println("Ganan O");
					return true;
				}else if (tablero[i][j] == 'X' && i == 7) {
					System.out.println("Ganan X");
					return true;
				}
				
			}
		}
		
		if(contO == 0) {
			System.out.println("Ganan X");
			return true;
		}else if (contX == 0) {
			System.out.println("Ganan O");
			return true;
		}
		
		return false;
		
	}

	private static void moverPieza(char[][] tablero, boolean turno) {
		// TODO Auto-generated method stub

                
                int fila = -1;
                int columna = -1;
                int fila2 = -1;
                int columna2 = -1;
                Movimientos movimientos = new Movimientos(fila, columna, fila2, columna2);
                
		boolean piezaValida = false;

		while (!piezaValida) {
			System.out.println("Pieza a mover");
			System.out.println("Fila (0-7)");
			fila = teclado.nextInt();
			System.out.println("Columna (0-7)");
			columna = teclado.nextInt();

			if(tablero[fila][columna] == 'O' && turno) {

				System.out.println("Nuevo destino");
				System.out.println("Fila (0-7)");
				fila2 = teclado.nextInt();
				System.out.println("Columna (0-7)");
				columna2 = teclado.nextInt();

				if(tablero[fila2][columna2] == 'X' || tablero[fila2][columna2] == '·') {
					tablero[fila][columna] = '·';
					tablero[fila2][columna2] = 'O';
					piezaValida = !piezaValida;
                                        movimientos.setFila(fila);
                                        movimientos.setColumna(columna);
                                        movimientos.setFilaDestino(fila2);
                                        movimientos.setColumnaDestino(columna2);
					mostrarTablero(tablero);
				}else {
					System.out.println("Movimiento invalido");
				}


			} else if(tablero[fila][columna] == 'X' && !turno){

				System.out.println("Nuevo destino");
				System.out.println("Fila (0-7)");
				fila2 = teclado.nextInt();
				System.out.println("Columna (0-7)");
				columna2 = teclado.nextInt();

				if(tablero[fila2][columna2] == 'O' || tablero[fila2][columna2] == '·') {
					tablero[fila][columna] = '·';
					tablero[fila2][columna2] = 'X';
					piezaValida = !piezaValida;
                                        movimientos.setFila(fila);
                                        movimientos.setColumna(columna);
                                        movimientos.setFilaDestino(fila2);
                                        movimientos.setColumnaDestino(columna2);
					mostrarTablero(tablero);
				}else {
					System.out.println("Movimiento invalido");
				}

			} else {
				System.out.println("Pieza/posici·n invalida");
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
