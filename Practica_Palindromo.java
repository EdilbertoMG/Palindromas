package practica_palindromo;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Edilberto Marrugo Gutiérrez
 */
public class Practica_Palindromo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack pila = new Stack();
        Stack Finalpila = new Stack();

        int op = 0, tamaño, tamaño2, iguales = 0;
        String palabra, palabra2;
        boolean error;
        do {
            error = false;
            do {
                //Valida que solo se ingrese numeros
                do {
                    error = false;
                    try {
                        System.out.println("------------------------------------------------");
                        System.out.print("SELECCIONE UNA OPCION\n"
                                + "1. Ingresar una palabra\n"
                                + "2. Salir: ");
                        op = sc.nextInt();
                        sc.nextLine();
                    } catch (InputMismatchException e) {
                        error = true;
                        sc.nextLine();
                        System.out.println("Debes ingresar solo números.");
                    }
                } while (error);

                switch (op) {

                    case 1:

                        System.out.println("");
                        System.out.println("------------------------------------------------");
                        System.out.print("Ingrese la palabra: ");
                        palabra = sc.nextLine();

                        palabra2 = palabra.replaceAll(" ", "");

                        tamaño = palabra2.length();

                        if (tamaño % 2 == 0) {
                            //par
                            tamaño2 = tamaño / 2;

                            //este for inserta a la pila las letras de la palabra en su respectiva posicion
                            for (int i = 0; i < tamaño2; i++) {
                                pila.push(palabra2.charAt(i));

                            }

                            //Agrega la pila en un arreglo para poder comparar
                            char[] Letras_Palabra = new char[tamaño2];
                            for (int i = 0; i < tamaño2; i++) {

                                Letras_Palabra[i] = (char) pila.peek();
                                pila.pop();
                            }

                            //pila 2
                            char[] Letras_Palabra2 = new char[tamaño2];
                            int Tamaño_Pila_If2 = tamaño2;
                            for (int i = 0; i < tamaño2; i++) {

                                Letras_Palabra2[i] = palabra2.charAt(Tamaño_Pila_If2);
                                Tamaño_Pila_If2++;

                            }

                            for (int i = 0; i < tamaño2; i++) {

                                if (Letras_Palabra[i] == Letras_Palabra2[i]) {

                                    iguales = 1;
                                } else {
                                    //entra si no son iguales
                                    iguales = 2;

                                }

                            }

                            if (iguales == 1) {
                                System.out.println("Esta palabra es par.");
                                System.out.print("Esta palabra es Palíndroma, La palabra es: ");

                                for (int i = 0; i < tamaño; i++) {
                                    Finalpila.push(palabra2.charAt(i));

                                }
                                //imprimir la palabra
                                for (int i = 0; i < tamaño; i++) {
                                    System.out.print(Finalpila.peek());
                                    Finalpila.pop();
                                }
                                System.out.println("");
                            } else {

                                System.out.println("Esta palabra no es Palíndroma.");
                            }

                        } else {

                            //impar
                            tamaño2 = (tamaño / 2);

                            //este for inserta a la pila las letras de la palabra en su respectiva posicion
                            for (int i = 0; i < tamaño2; i++) {
                                pila.push(palabra2.charAt(i));

                            }

                            //Agrega la pila en un arreglo para poder comparar
                            char[] Letras_Palabra = new char[tamaño2];
                            for (int i = 0; i < tamaño2; i++) {

                                Letras_Palabra[i] = (char) pila.peek();
                                pila.pop();
                            }

                            //pila 2
                            //dentro del for primero se aumenta ya que siempre se ignora la letra ..
                            //del medio en el caso de las palabras impares
                            char[] Letras_Palabra2 = new char[tamaño2];
                            int Tamaño_Pila_If2 = tamaño2;
                            for (int i = 0; i < tamaño2; i++) {

                                Tamaño_Pila_If2++;
                                Letras_Palabra2[i] = palabra2.charAt(Tamaño_Pila_If2);

                            }

                            for (int i = 0; i < tamaño2; i++) {

                                if (Letras_Palabra[i] == Letras_Palabra2[i]) {

                                    iguales = 1;
                                } else {
                                    //entra si no son iguales
                                    iguales = 2;

                                }

                            }

                            if (iguales == 1) {

                                System.out.println("Esta palabra es impar.");
                                System.out.print("Esta palabra es Palíndroma, La palabra es: ");

                                for (int i = 0; i < tamaño; i++) {
                                    Finalpila.push(palabra2.charAt(i));

                                }
                                //imprimir la palabra
                                for (int i = 0; i < tamaño; i++) {
                                    System.out.print(Finalpila.peek());
                                    Finalpila.pop();
                                }
                                System.out.println("");
                            } else {

                                System.out.println("Esta palabra no es Palíndroma.");
                            }

                        }
                        break;

                    case 2:
                        System.exit(0);
                        break;

                    default:
                        System.out.println("");
                        System.out.println("------------------------------------------------");
                        System.out.println("Opcion no valida. Intente de nuevo");
                        error = true;
                        break;

                }
            } while (op != 3);
        } while (error);
    }

}
