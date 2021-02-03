import java.util.Scanner;
import java.util.Random;

 

public class main {

 

    public static void main(String[] args) {

 

        Jugador[] equipo = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Numero de jugadores: ");
        int num = sc.nextInt();
        int opcion = 0;

 

        menu();

 

        do {
            opcion = sc.nextInt();

 

            switch (opcion) {
            case 1:
                equipo = getEquipo(num);
                for (int i = 0; i < equipo.length; i++)
                    System.out.println(Imprimir(equipo[i]));

 

                break;

 

            case 2:
                if (equipo != null) {
                    shuffleArray(equipo);
                    for (int i = 0; i < equipo.length; i++)
                        System.out.println(Imprimir(equipo[i]));
                } else {
                    System.out.println("cucha no hay ugadore");
                }
                break;
            case 3:
                if (equipo != null) {
                    System.out.println("Que dorsal quieres buscar:");
                    int dorsal = sc.nextInt();
                    int indice = busqueda_binaria(equipo, dorsal);
                    if (indice != -1) {
                        System.out.println(Imprimir(equipo[dorsal]));
                    } else {
                        System.out.println("No está el dorsal");
                    }
                } else {
                    System.out.println("cucha no hay ugadore");
                }
                break;
            case 4:
                long start = System.nanoTime();
                
                if (equipo != null) {
                    bubbleSort(equipo);
                    for (int i = 0; i < equipo.length; i++)
                        System.out.println(Imprimir(equipo[i]));
                } else {
                    System.out.println("cucha no hay ugadore");
                }
                long finish = System.nanoTime();
                long timeElapsed = finish - start;
                System.out.println(timeElapsed/1e9);
                break;
            default:

 

            }

 

            menu();

 

        } while (opcion != 7);

 

    }

 

    public static void menu() {
        System.out.println();
        System.out.println("¿Qué quiere hacer?");
        System.out.println("1 - Generar Equipo");
        System.out.println("2 - Desordenar Equipo");
        System.out.println("3 - Buscar jugador");
        System.out.println("4 - Ordenar Equipo (Bubble)");
        System.out.println("5 - Ordenar Equipo (Quick)");
        System.out.println("6 - Comparar Algortimos de Orden");
        System.out.println("7 - Salir");
    }

 

    public static Jugador[] getEquipo(int jugadoresEquipo) {
        Jugador[] roster = new Jugador[jugadoresEquipo];
        for (int i = 0; i < jugadoresEquipo; i++) {
            roster[i] = new Jugador(getNombres(), getApellidos(), getPosicion(), i);
        }
        return roster;
        // for (Jugador Jugador:roster) Jugador.imprimirJugador();
    }

 

    public static String Imprimir(Jugador jugador) {

 

        return jugador.getNombre() + " " + jugador.getApellidos() + " " + jugador.getPosicion() + " "
                + jugador.getDorsal() + ".";

 

    }

 

    public static String getNombres() {

 

        Random random = new Random();

 

        String[] nombres = { "Andrea", "Iker", "Diego", "Vinicius", "Ronaldo", "Antoine", "Papu", "Andres", "Cristiano",
                "Lionel", "Canario", "Youssef", "Tomy", "Aitor" };

 

        return nombres[random.nextInt(13)];

 

    }

 

    public static String getApellidos() {

 

        Random random = new Random();

 

        String[] apellidos = { "Gomez", "Pirlo", "Iniesta", "Griezmann", "Junior", "Nazario", "Ruiz", "Carillo",
                "Reina", "Castillo", "Cipote", "Castro", "Tilla", "Fol", "En-Nesyri", "Lapava", "Grigalva", "Messi",
                "Ronaldo", "Casillas" };

 

        return apellidos[random.nextInt(20)] + " " + apellidos[random.nextInt(20)];

 

    }

 

    public static String getPosicion() {

 

        Random random = new Random();

 

        String[] posicion = { "Portero", "Defensa", "Centrocampista", "Delantero" };

 

        return posicion[random.nextInt(4)];

 

    }

 

    private static Jugador[] shuffleArray(Jugador[] array) {

 

        Random random = new Random();
        int contadorRandom = random.nextInt(100 + 1 - 10) + 10;
        for (int i = 0; i < contadorRandom + array.length; i++) {
            int n1 = random.nextInt(array.length - 1);
            Jugador temp = array[n1];
            int n2 = random.nextInt(array.length - 1);

 

            array[n1] = array[n2];
            array[n2] = temp;
        }
        return array;
    }

 

    public static int busqueda_binaria(Jugador[] array, int numero) {

 

        int izq = 0;
        int der = array.length - 1;
        int centro = (izq + der) / 2;

 

        while ((array[centro].getDorsal() != numero) && (izq <= der)) {

 

            if (numero < array[centro].getDorsal()) {
                der = centro - 1;
            } else {
                izq = centro + 1;
            }
            centro = (izq + der) / 2;
        }
        if (izq > der) {
            return -1;
        } else {
            return centro;
        }
    }

 

    public static Jugador[] bubbleSort(Jugador[] dorsal) {
        Jugador temp;
        int n = dorsal.length;
        boolean ordenada = false;
        for (int i = 0; i < n; i++) {// Midiendo los pasos
            if (ordenada) {
                return dorsal;
            }
            ordenada = true;
            for (int j = 0; j < (n - i - 1); j++) {// Va subiendo burbujas o hundiendo pesos.
                if (dorsal[j].getDorsal() > dorsal[j + 1].getDorsal()) {
                    temp = dorsal[j];
                    dorsal[j] = dorsal[j + 1];
                    dorsal[j + 1] = temp;
                    ordenada = false;
                }
            }
        }
        return dorsal;
    }
}