package gamingmachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Оля
 */
public class GamingMachine {

    static int bottomMarge = 0;
    static int topMarge = 100;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter 'exit' if you want to finish the game");
        System.out.println("Enter number for " + bottomMarge + " to " + topMarge + " excluding " + bottomMarge + " and " + topMarge);

        int makeNumber = random(bottomMarge + 1, topMarge - 1);
        while (true) {
            try {
                String tmp = reader.readLine();
                checkExit(tmp);
                int enterNumber = Integer.parseInt(tmp);

                while (enterNumber != makeNumber) {

                    while (true) {

                        if (enterNumber < makeNumber) {
                            if (enterNumber > bottomMarge) {
                                bottomMarge = enterNumber;
                                System.out.println("Enter number for " + bottomMarge + " to " + topMarge + " excluding " + bottomMarge + " and " + topMarge);
                            } else {
                                System.out.println("Enter number after " + bottomMarge + " (before " + topMarge + ")");
                            }

                        } else if (enterNumber > makeNumber) {
                            if (enterNumber < topMarge) {
                                topMarge = enterNumber;
                                System.out.println("Enter number for " + bottomMarge + " to " + topMarge + " excluding " + bottomMarge + " and " + topMarge);
                            } else {
                                System.out.println("Enter number before " + topMarge + " (after " + bottomMarge + ")");
                            }
                        }
                        try {
                            tmp = reader.readLine();
                            checkExit(tmp);
                            enterNumber = Integer.parseInt(tmp);
                            break;
                        } catch (NumberFormatException ex) {
                            System.out.println("Введи число!");
                        }

                    }

                }

                System.out.println("Uiiiiii!");
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Введите число!");
            }
        }
    }

    public static void checkExit(String tmp) {
        if (tmp.equalsIgnoreCase("exit")) {
            System.exit(0);
        }
    }

    public static int random(int bottomMarge, int topMarge) {
        return bottomMarge + (int) (Math.random() * (topMarge - bottomMarge - 1));
    }

}
