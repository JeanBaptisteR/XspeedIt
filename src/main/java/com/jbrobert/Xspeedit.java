package com.jbrobert;

import java.util.List;
import java.util.Scanner;

/**
 *
 * This program optimizes the packaging of items into boxes.
 * From a list of items entered in the console, the program displays the content (items) of each box and the total number of boxes used.
 *
 * @author Jean-Baptiste Robert
 */
public class Xspeedit {

    public static void main(String[] args) {
        if(args.length == 0) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Veuillez saisir la liste des articles (exemple : 163841689525773) :");
            String input = scanner.nextLine();

            if (input.matches("[0-9]+")) {
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Articles : " + input);
                Packager packager = new Packager();
                List<Integer> items = packager.convertInputToItems(input);
                packager.printResult(packager.optimizedItemPackaging(items));
            } else {
                System.err.println("Saisie invalide. Seuls les caractères numériques sont acceptés");
            }

            scanner.close();
        } else {
            System.err.println("Auncun argument accepté dans le cadre de l'exécution de l'application");
        }
    }

}
