/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rogermelich_project;

import java.util.Scanner;

/**
 *
 * @author roger
 */
public class RogerMelich_Project {

    //Numero de Caselles Màximes de l'array
    private static final int MAX_TREBALLADORS = 2;
    //Array on guardem la informació dels pilots
    private static Treballadors[] array = new Treballadors[MAX_TREBALLADORS];

    private static int opcions_menu;   //integer que incloem el numeros per terminiar l'opció
    private static Treballadors t = null; //S'utilitza per apuntar al treballador de les caselles de l'array//S'utilitza per apuntar al treballador de les caselles de l'array//S'utilitza per apuntar al treballador de les caselles de l'array//S'utilitza per apuntar al treballador de les caselles de l'array
    private static char esborrar;  //Esborrar Dades
    private static char modificar; //Modifcar Dades
    private static char llista;   //Veure Dades

    private static char tipusTreballador;   //Serveix per determinar si està en pràctiques o no //Serveix per determinar si està en pràctiques o no //Serveix per determinar si està en pràctiques o no //Serveix per determinar si està en pràctiques o no

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        inicialitzarVariables();
        do {
            demanarOpcio();
            tractarOpcio();
        } while (!opcioFinal());
    }

    public static void inicialitzarVariables() {
        //Inicialitzem l'array en nous treballadors sense dades
        for (int i = 0; i < array.length; i++) {
            array[i] = new Treballadors();
            array[i].setIntroduit(false);
        }

    }

    public static void demanarOpcio() {
        Scanner scan = new Scanner(System.in);   //Servei per llegir el que fiquem al teclat

        System.out.println("-----------------------------");
        System.out.println("|   Menú de l'aplicació:    |");
        System.out.println("|---------------------------|");
        System.out.println("|  0. Sortir de l'Aplicació |");
        System.out.println("|  1. Afegir Treballador    |");
        System.out.println("|  2. Esborrar Treballador  |");
        System.out.println("|  3. Modificar Treballador |");
        System.out.println("|  4. Llistar Treballador   |");
        System.out.println("|  5. Recuperar Treballador |");
        System.out.println("|___________________________|");
        System.out.println("");

        System.out.println("Introdueix una opció, introdueix el digits 0,1,2,3,4 o 5: ");
        opcions_menu = scan.nextInt();
    }

    public static void tractarOpcio() {
        switch (opcions_menu) {
            case 0: //0. Sortir
                System.out.println("El Programa ha finalitzat...!!");
                break;
            case 1: //1. Introduïr treballador
                introduirtreballador();
                break;
            case 2: //2. Modificar treballador
                modificarTreballador();
                break;
            case 3: //3. Borrar treballador
                borrarTreballador();
                break;
            case 4: //4. Llistar treballador
                llistarTreballadors();
                break;
            case 5: //5. Recuperar treballador borrat
                recuperarTreballador();
                break;
            default:
                System.out.println("\nOpció incorrecta!!");
        }
    }

    public static boolean opcioFinal() {
        return opcions_menu == 0; //Retornem 0 per finalitzar
    }

    public static void introduirtreballador() {
        Scanner scan = new Scanner(System.in);   //Servei per llegir el que fiquem al teclat

        int i;
        // Busco una casella buida al vector
        for (i = 0; i < array.length && array[i].isIntroduit(); i++);
        //Aquests for ho fa tot desde la primera línia.

        if (i != array.length) { //indiquem que introduït == false
            //Indiquem que t = array [i]
            t = array[i];
            System.out.println("Introdueix el Nom i Cognoms del Treballador seguit d'un espai entre nom i cognoms");
            //Nom_Cognoms = scan.skip("[\r\n]*").nextLine();
            t.setNom_Cognoms(scan.skip("[\r\n]*").nextLine());
            System.out.println("Introdueix el DNI");
            t.setDNI(scan.skip("[\r\n]*").nextLine());

            System.out.println("Introdueix l'Adreça");
            //Adreca = scan.skip("[\r\n]*").nextLine();
            t.setAdreca(scan.skip("[\r\n]*").nextLine());
            do {
                System.out.println("Introdueix el codi Postal");
                //Codi_Postal = scan.nextInt();
                t.setCodi_Postal(scan.nextInt());

                if (t.getCodi_Postal() < 0) {
                    System.out.println("El Codi Postal a de tenir 5 digits");
                }
            } while (t.getCodi_Postal() < 0);

            do {
                System.out.println("Introdueix la Nomina del Treballador");
                //Nomina = scan.nextDouble();
                t.setNomina(scan.nextDouble());
                if (t.getNomina() < 0) {
                    System.out.println("Valor Incorrecte");
                }
            } while (t.getNomina() < 0);

            do {
                System.out.println("Introdueix si es un contracte de pràctiques o no (S o N)");
                tipusTreballador = scan.skip("[\r\n]*").nextLine().charAt(0);

                if (tipusTreballador == 's' || tipusTreballador == 'S') {
                    t.setPractiques(true);

                }

                if (tipusTreballador == 'n' || tipusTreballador == 'N') {
                    t.setPractiques(false);
                }
            } while (tipusTreballador != 's' && tipusTreballador != 'S' && tipusTreballador != 'n' && tipusTreballador != 'N');
            t.setIntroduit(true); //Al introduïr tots els camps canviem introduit a true
        } else {
            System.out.println("Ja has introduït aquest treballador o no caben més treballadors");
            System.out.println("Que vols fer ara?");
        }
    }

    public static void modificarTreballador() {
        Scanner scan = new Scanner(System.in);   //Servei per llegir el que fiquem al teclat

        int i;
        for (i = 0; i < array.length; i++);
        t = array[i];
        if (!t.isIntroduit()) {
            System.out.println("No hi ha cap treballador per modificar, si el vols modificar el tens que introduïr promer.\n");
            System.out.println("");
        }

        if (t.isIntroduit()) {

            do {

                System.out.println("Vols veure les dades del treballador? (S o N)");
                llista = scan.skip("[\r\n]*").nextLine().charAt(0);

            } while (llista != 's' && llista != 'n' && llista != 'S' && llista != 'N');

            if (llista == 's' || llista == 'S') {
                System.out.println("Dades del Treballador: ");
                System.out.println("Noms i Cognoms: " + t.getNom_Cognoms());
                System.out.println("DNI: " + t.getDNI());
                System.out.println("Adreça: " + t.getAdreca());
                System.out.println("Codi Postal: " + t.getCodi_Postal());
                System.out.println("Sou del Treballador:" + t.getNomina());

                if (t.isPractiques()) {
                    System.out.println("Treballador en Pràctiques: Si");
                }

                if (!t.isPractiques()) {
                    System.out.println("Treballador en Pràctiques: No");
                }
            }

            do {

                System.out.println("Vols veure les dades del treballador? (S o N)");
                llista = scan.skip("[\r\n]*").nextLine().charAt(0);

            } while (llista != 's' && llista != 'n' && llista != 'S' && llista != 'N');

            if (llista == 's' || llista == 'S') {

                System.out.println("Nom i Cognoms: " + t.getNom_Cognoms());    //Modifiquem Nom i Cognoms

                do {
                    System.out.println("Vols modificar els Noms i Cognoms? (S o N)");
                    modificar = scan.skip("[\r\n]*").nextLine().charAt(0);

                } while (modificar != 's' && modificar != 'n' && modificar != 'S' && modificar != 'N');

                if (modificar == 's' || modificar == 'S') {
                    System.out.println("Introdueix el Nou Treballador:");
                    t.setNom_Cognoms(scan.skip("[\r\n]*").nextLine());
                }

                System.out.println("DNI: " + t.getDNI());    //Modifiquem el DNI

                do {
                    System.out.println("Vols modificar el DNI? (S o N)");
                    modificar = scan.skip("[\r\n]*").nextLine().charAt(0);

                } while (modificar != 's' && modificar != 'n' && modificar != 'S' && modificar != 'N');

                if (modificar == 's' || modificar == 'S') {
                    System.out.println("Introdueix el *Nou* DNI del treballador:");
                    t.setDNI(scan.skip("[\r\n]*").nextLine());
                }

                System.out.println("Adreça: " + t.getAdreca());    //Modifiquem l'Adreça

                do {
                    System.out.println("Vols modificar l'Adreça? (S o N)");
                    modificar = scan.skip("[\r\n]*").nextLine().charAt(0);

                } while (modificar != 's' && modificar != 'n' && modificar != 'S' && modificar != 'N');

                if (modificar == 's' || modificar == 'S') {
                    System.out.println("Introdueix la *Nova* adreça del treballador:");
                    t.setAdreca(scan.skip("[\r\n]*").nextLine());
                }

                System.out.println("Codi Postal: " + t.getCodi_Postal());  //Modifiquem el Codi Postal

                do {
                    System.out.println("Vols modificar el Codi Postal? (S o N)");
                    modificar = scan.skip("[\r\n]*").nextLine().charAt(0);
                } while (modificar != 's' && modificar != 'n' && modificar != 'S' && modificar != 'N');

                if (modificar == 's' || modificar == 'S') {
                    do {
                        System.out.println("Introdueix el *Nou* valor del Codi Postal: ");
                        t.setCodi_Postal(scan.nextInt());

                        if (t.getCodi_Postal() <= 0) {
                            System.out.println("Valor incorrecte");
                        }

                    } while (t.getCodi_Postal() <= 0);
                }

                System.out.println("Sou (Nomina) del treballador: " + t.getNomina()); //Modifiquem el Sou de Treballador

                do {
                    System.out.println("Vols modificar el Sou del treballador? (S o N)");
                    modificar = scan.skip("[\r\n]*").nextLine().charAt(0);
                } while (modificar != 's' && modificar != 'n' && modificar != 'S' && modificar != 'N');

                if (modificar == 's' || modificar == 'S') {

                    do {
                        System.out.println("Introdueix el *Nou* sou del treballador: ");
                        t.setNomina(scan.nextDouble());

                        if (t.getNomina() <= 0) {
                            System.out.println("Valor incorrecte!");
                        }

                    } while (t.getNomina() <= 0);
                }

                // El contracte es en Pràctiques o no
                if (t.isPractiques()) {
                    System.out.println("Treballador en Pràctiques: Si");
                }

                if (!t.isPractiques()) {
                    System.out.println("Treballador en Pràctiques: No");
                }

                do {
                    System.out.println("Vols modificar el tipus de Contracte (Contracte de Pràctiques o no)? (S o N)");
                    modificar = scan.skip("[\r\n]*").nextLine().charAt(0);

                } while (modificar != 's' && modificar != 'n' && modificar != 'S' && modificar != 'N');

                if (modificar == 's' || modificar == 'S') {
                    do {
                        System.out.println("Introdueix el *Nou* tipus de contracte: (S o N)");
                        tipusTreballador = scan.skip("[\r\n]*").nextLine().charAt(0);

                        if (tipusTreballador == 's' || tipusTreballador == 'S') {
                            t.setPractiques(true);
                        }

                        if (tipusTreballador == 'n' || tipusTreballador == 'N') {
                            t.setPractiques(false);
                        }

                    } while (tipusTreballador != 's' && tipusTreballador != 'n' && tipusTreballador != 'S' && tipusTreballador != 'N');
                }

                System.out.println("\nTreballador modificat correctament\n");
            }
        }
    }

    public static void borrarTreballador() {
        Scanner scan = new Scanner(System.in);   //Servei per llegir el que fiquem al teclat

        esborrar = 'N';
        int i;
        for (i = 0; i < array.length; i++) {
            t = array[i];

            if (t.isIntroduit()) {
                System.out.println(t);
                do {
                    System.out.println("\nVols Borrar el treballador? (S o N)");
                    esborrar = scan.skip("[\r\n]*").nextLine().charAt(0);
                } while (esborrar != 's' && esborrar != 'n' && esborrar != 'S' && esborrar != 'N');

                if (esborrar == 's' || esborrar == 'S') {
                    t.setIntroduit(false);

                    System.out.println("\nDades del Treballador Borrades\n");
                    break;
                }

            } else {
                System.out.println("No s'ha borrat cap Treballador\n");
                System.out.println("");
            }
        }
    }

    public static void llistarTreballadors() {
        Scanner scan = new Scanner(System.in);   //Servei per llegir el que fiquem al teclat
        
        int i;
        for (i = 0; i < array.length; i++);
        t = array[i];
        if (t.isIntroduit() == true) {
            System.out.println("Dades del Treballador: ");
            System.out.println("Noms i Cognoms: " + t.getNom_Cognoms());
            System.out.println("DNI: " + t.getDNI());
            System.out.println("Adreça: " + t.getAdreca());
            System.out.println("Codi Postal: " + t.getCodi_Postal());
            System.out.println("Sou del Treballador:" + t.getNomina());

            if (t.isPractiques()) {
                System.out.println("Treballador en Pràctiques: Si");
            }

            if (!t.isPractiques()) {
                System.out.println("Treballador en Pràctiques: No");
            }
        } else {
            System.out.println("\nNo hi ha cap treballador\n");
        }
    }

    public static void recuperarTreballador() {
        Scanner scan = new Scanner(System.in);   //Servei per llegir el que fiquem al teclat
    }
}