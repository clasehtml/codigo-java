import java.util.Scanner;

public class Simulacro {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String seleccionRaw;
        boolean entradaValida;
        int seleccion;
        do {
            System.out.println("* * * Selector de ejercicios * * *");
            System.out.println("1 = ejercicio 1");
            System.out.println("2 = ejercicio 2");
            System.out.println("Tip: Utiliza \"0\" para salir");
            System.out.print("Introduzca el ejercicio a elegir mediante un número: ");
            seleccionRaw = entrada.nextLine();
            entradaValida = switch (seleccionRaw) {
                case "1", "2", "0" -> true;
                default -> false;
            };
            if (!entradaValida) {
                System.out.println("\nError: Selección no válida.\n");
            }
        } while (!entradaValida);

        seleccion = Integer.parseInt(seleccionRaw);
        switch (seleccion) {
            case 1:
                ejercicio1();
                break;
            case 2:
                ejercicio2();
                break;
            case 0:
                System.out.println("Fin del programa.");
                break;
        }
    }
    public static void ejercicio1() {
        System.out.println("* * * Ejercicio 1: Contador de frases * * *");
        System.out.print("Introduzca una frase: ");
        Scanner entrada = new Scanner(System.in);
        String frase = entrada.nextLine();
        System.out.println("La frase introducida tiene " + cuentaCaracteres(frase) + " caracteres.");
        System.out.println("La frase introducida tiene " + cuentaVocales(frase) + " ocurrencias de la vocal elegida");
    }

    public static int cuentaCaracteres(String frase) {
        int cantidad = 0;
        for (char letra : frase.toCharArray()) {
           if (!Character.isSpaceChar(letra)) {
               cantidad++;
           }
        }
        return cantidad;
    }
    public static int cuentaVocales(String frase) {
        int cantidad = 0;
        Scanner entrada = new Scanner(System.in);
        String vocalRaw;
        boolean entradaValida;
        char vocal = ' ';
        do {
            System.out.println("Selecciona una vocal a contar (a, i, u, e, o): ");
            vocalRaw = entrada.nextLine();
            switch (vocalRaw) {
                case "a" -> {
                    vocal = 'a';
                    entradaValida = true;
                }
                case "i" -> {
                    vocal = 'i';
                    entradaValida = true;
                }
                case "u" -> {
                    vocal = 'u';
                    entradaValida = true;
                }
                case "e" -> {
                    vocal = 'e';
                    entradaValida = true;
                }
                case "o" -> {
                    vocal = 'o';
                    entradaValida = true;
                }
                default -> {
                    entradaValida = false;
                    System.out.println("Error: vocal no válida.");
                }
            }
        } while (!entradaValida);

        for (char letra : frase.toCharArray()) {
            if (letra == vocal) {
                cantidad++;
            }
        }
        return cantidad;
    }
    public static void ejercicio2() {
        System.out.println(" * * * Ejercicio 2: Laberinto virtual * * *");
        Scanner entrada = new Scanner(System.in);
        // Inicializar posición del jugador
        int jugadorFila = 0;
        int jugadorColumna = 0;
        int movimientosRestantes = 10;
        // Coordenadas de la salida
        final int  SALIDA_FILA = 3;
        final int SALIDA_COLUMNA = 3;
        boolean salidaEncontrada = false;
        System.out.println("¡Bienvenido al juego 'Escapa del Laberinto'!\n" +
                "Tu objetivo es llegar a la salida en la posición (3,3).");
        System.out.println("Usa las teclas 'a' (arriba), 's' (abajo), 'i' (izquierda), 'd' (derecha) para moverte.");
        do {
            System.out.println("Elige tu movimiento: ");
            char movimiento = entrada.nextLine().charAt(0);
            switch (movimiento) {
                case 'a':
                    jugadorFila++;
                    System.out.println("Has subido");
                    break;
                case 's':
                    jugadorFila--;
                    System.out.println("Has bajado");
                    break;
                case 'i':
                    jugadorColumna--;
                    System.out.println("Has ido a la izquierda");
                    break;
                case 'd':
                    jugadorColumna++;
                    System.out.println("Has ido a la derecha");
                    break;
                default:
                    System.out.println("Error: movimiento no válido.");
                    break;
            }
            System.out.println("Posición actual (" + jugadorColumna + ", " +jugadorFila + ")");
            if (jugadorColumna == SALIDA_COLUMNA && jugadorFila == SALIDA_COLUMNA) {
                salidaEncontrada = true;
                System.out.println("Has encontrado la salida!");
            }else {
                darPista(jugadorColumna,jugadorFila,SALIDA_COLUMNA,SALIDA_FILA);
            }
            movimientosRestantes--;
        } while (movimientosRestantes != 0 && !salidaEncontrada);
        if (!salidaEncontrada) {
            System.out.println("Has perdido.");
        }
    }
    public static void darPista(int jugC, int jugF, int salC, int salF)  {
        if (jugC < salC && jugF < salF) {
            System.out.println("Pista: La salida está hacia arriba y a la derecha.");
        } else if (jugF < salF) {
            System.out.println("Pista: La salida está hacia arriba.");
        } else if (jugC < salC) {
            System.out.println("Pista: La salida está hacia la derecha.");
        } else {
            System.out.println("Pista: Te estás alejando.");
        }
    }
}
