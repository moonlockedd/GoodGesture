import controllers.ProgramController;
import controllers.SubjectScoreController;
import controllers.UserController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GrantedApplication {
    private final SubjectScoreController subjectScoreController;
    private final UserController userController;
    private final Scanner scanner;
    private static final String MENU_LINE = "*****************************************";

    public GrantedApplication(
            SubjectScoreController subjectScoreController,
            UserController userController
    ) {
        this.subjectScoreController = subjectScoreController;
        this.userController = userController;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println(MENU_LINE);
            System.out.println("Welcome to GrantEd Application");
            System.out.println(MENU_LINE);

            System.out.println("Select option: ");
            System.out.println("1. Subject Score Menu");
            System.out.println("2. User Menu");
            System.out.println("3. Program Menu");
            System.out.println("4. University Menu");
            System.out.println("0. Exit application");

            try {
                System.out.println("Enter option 1-4: ");
                int option = scanner.nextInt();

                if (option == 1) {
                    subjectScoreMenu();
                } else if (option == 2) {
                    userMenu();
                } else if (option == 0) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer");
                scanner.nextLine(); // to ignore incorrect input
            }
        }
    }

    public void subjectScoreMenu() {
        while (true) {
            System.out.println(MENU_LINE);
            System.out.println("Subject Score Menu");
            System.out.println(MENU_LINE);

            System.out.println("Select option: ");
            System.out.println("1. Get All Subject Scores");
            System.out.println("2. Get Subject Score By ID");
            System.out.println("3. Create Subject Score");
            System.out.println("0. Go back");

            try {
                System.out.println("Enter option 1-3: ");
                int option = scanner.nextInt();

                if (option == 1) {
                    getAllSubjectScoresMenu();
                } else if (option == 2) {
                    getSubjectScoreByIdMenu();
                } else if (option == 3) {
                    createSubjectScoreMenu();
                } else if (option == 0) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer");
                scanner.nextLine(); // to ignore incorrect input
            }
        }
    }

    public void getAllSubjectScoresMenu() {
        System.out.println(MENU_LINE);
        System.out.println("All Subject Scores\n");

        System.out.println(subjectScoreController.getAll());
    }

    public void getSubjectScoreByIdMenu() {
        try {
            System.out.println(MENU_LINE);

            System.out.println("Enter id: ");

            int id = scanner.nextInt();
            System.out.println("\n" + subjectScoreController.getById(id) + "\n");
        } catch (InputMismatchException e) {
            System.out.println("Input must be integer");
            scanner.nextLine(); // to ignore incorrect input
        }
    }

    public void createSubjectScoreMenu() {
        try {
            System.out.println(MENU_LINE);
            // To ignore whitespace from previous input
            scanner.nextLine();

            System.out.println("Enter subject name: ");
            String subject = scanner.nextLine();

            System.out.println("Enter subject score: ");
            int score = scanner.nextInt();

            System.out.println("\n" + subjectScoreController.create(subject, score));
        } catch (InputMismatchException e) {
            System.out.println("Subject name must be string");
            System.out.println("Score must be integer");
            scanner.nextLine(); // to ignore incorrect input
        }
    }

    public void userMenu() {
        while (true) {
            System.out.println(MENU_LINE);
            System.out.println("User Menu");
            System.out.println(MENU_LINE);

            System.out.println("Select option: ");
            System.out.println("1. Get All Users");
            System.out.println("2. Get User By ID");
            System.out.println("3. Create User");
            System.out.println("0. Go back");

            try {
                System.out.println("Enter option 1-3: ");
                int option = scanner.nextInt();

                if (option == 1) {
                    getAllUsersMenu();
                } else if (option == 2) {
                    getUserByIdMenu();
                } else if (option == 3) {
                    createUserMenu();
                } else if (option == 0) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer");
                scanner.nextLine(); // to ignore incorrect input
            }
        }
    }

    public void getAllUsersMenu() {
        System.out.println(MENU_LINE);
        System.out.println("All Users\n");

        System.out.println(userController.getAll());
    }

    public void getUserByIdMenu() {
        try {
            System.out.println(MENU_LINE);

            System.out.println("Enter id: ");

            int id = scanner.nextInt();
            System.out.println("\n" + userController.getById(id) + "\n");
        } catch (InputMismatchException e) {
            System.out.println("Input must be integer");
            scanner.nextLine(); // to ignore incorrect input
        }
    }

    public void createUserMenu() {

    }
}
