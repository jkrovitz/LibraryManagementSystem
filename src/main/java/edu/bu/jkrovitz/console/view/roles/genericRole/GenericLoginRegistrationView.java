package edu.bu.jkrovitz.console.view.roles.genericRole;

import edu.bu.jkrovitz.console.controller.accounts.LoginController;
import edu.bu.jkrovitz.console.enums.Role;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Displays a menu where the user can decide to exit, go back, login, or register.
 *
 * @author Jeremy Krovitz
 */
public class GenericLoginRegistrationView {

    public <T> void askToRegisterOrLogin(Role role) throws SQLException, IOException, ParseException {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            while (true) {
                System.out.println("Do you want to 0. quit 1. Go back 2. Login");
                if (sc.hasNextInt()) {
                    break;
                }
                String input = String.valueOf(sc.next());
                System.out.println("Your input " + input + " is not an integer. Your input must be an integer. Please try again.\n");
            }

            choice = sc.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    break;
                case 2:
                    LoginController loginController = new LoginController();
                    loginController.processLogin(role);
                    break;
                default:
                    System.out.println("You have chose an invalid option.");
            }

        } while (choice != 1);
    }
}
