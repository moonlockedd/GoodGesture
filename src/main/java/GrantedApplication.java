import controllers.ProgramController;
import controllers.SubjectScoreController;
import controllers.UniversityController;
import controllers.UserController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GrantedApplication {
    private final SubjectScoreController subjectScoreController;
    private final UserController userController;
    private final ProgramController programController;
    private final UniversityController universityController;
    private final Scanner scanner;
    private static final String MENU_LINE = "*****************************************";

    public GrantedApplication(
            SubjectScoreController subjectScoreController,
            UserController userController,
            ProgramController programController,
            UniversityController universityController
    ) {
        this.subjectScoreController = subjectScoreController;
        this.userController = userController;
        this.programController = programController;
        this.universityController = universityController;
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
                } else if (option == 3) {
                    programMenu();
                } else if (option == 4) {
                    universityMenu();
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

            System.out.println("\n" + subjectScoreController.create(subject, score) + "\n");
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
        try {
            System.out.println(MENU_LINE);
            // To ignore whitespace from previous input
            scanner.nextLine();

            System.out.println("Enter first name: ");
            String firstName = scanner.nextLine();

            System.out.println("Enter last name: ");
            String lastName = scanner.nextLine();

            System.out.println("Enter email: ");
            String email = scanner.nextLine();

            System.out.println("Enter password: ");
            String password = scanner.nextLine();

            String[] subjects = new String[5];
            int[] scores = new int[5];

            for (int i = 0; i < 3; i++) {
                System.out.println("Mandatory Subject #" + (i + 1));

                System.out.println("Enter subject name: ");
                subjects[i] = scanner.nextLine();

                System.out.println("Enter subject score: ");
                scores[i] = scanner.nextInt();
                // To ignore whitespace from previous input
                scanner.nextLine();
            }

            for (int i = 0; i < 2; i++) {
                System.out.println("Elective Subject #" + (i + 1));

                System.out.println("Enter subject name: ");
                subjects[i + 3] = scanner.nextLine();

                System.out.println("Enter subject score: ");
                scores[i + 3] = scanner.nextInt();
                scanner.nextLine();
            }

            System.out.println(
                    "\n" + userController.create(
                            firstName, lastName,
                            email, password,
                            subjects, scores
                    ) + "\n");
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input");
            scanner.nextLine(); // to ignore incorrect input
        }
    }

    public void programMenu() {
        while (true) {
            System.out.println(MENU_LINE);
            System.out.println("Program Menu");
            System.out.println(MENU_LINE);

            System.out.println("Select option: ");
            System.out.println("1. Get All Programs");
            System.out.println("2. Get Program By ID");
            System.out.println("3. Create Program");
            System.out.println("0. Go back");

            try {
                System.out.println("Enter option 1-3: ");
                int option = scanner.nextInt();

                if (option == 1) {
                    getAllProgramsMenu();
                } else if (option == 2) {
                    getProgramByIdMenu();
                } else if (option == 3) {
                    createProgramMenu();
                } else if (option == 0) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer");
                scanner.nextLine(); // to ignore incorrect input
            }
        }
    }

    public void getAllProgramsMenu() {
        System.out.println(MENU_LINE);
        System.out.println("All Programs\n");

        System.out.println(programController.getAll());
    }

    public void getProgramByIdMenu() {
        try {
            System.out.println(MENU_LINE);

            System.out.println("Enter id: ");

            int id = scanner.nextInt();
            System.out.println("\n" + programController.getById(id) + "\n");
        } catch (InputMismatchException e) {
            System.out.println("Input must be integer");
            scanner.nextLine(); // to ignore incorrect input
        }
    }

    public void createProgramMenu() {
        try {
            // To ignore whitespace from previous input
            scanner.nextLine();
            System.out.println(MENU_LINE);

            System.out.println("Enter program name: ");
            String name = scanner.nextLine();

            System.out.println("Enter program minimum passing score: ");
            int minimumScore = scanner.nextInt();
            // To ignore whitespace from previous input
            scanner.nextLine();

            String[] electiveSubjectNames = new String[2];

            System.out.println("Enter first elective subject name: ");
            electiveSubjectNames[0] = scanner.nextLine();

            System.out.println("Enter second elective subject name: ");
            electiveSubjectNames[1] = scanner.nextLine();

            System.out.println("\n" + programController.create(
                    name, minimumScore, electiveSubjectNames
            ) + "\n");
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input");
            scanner.nextLine(); // to ignore incorrect input
        }
    }

    public void universityMenu() {
        while (true) {
            System.out.println(MENU_LINE);
            System.out.println("University Menu");
            System.out.println(MENU_LINE);

            System.out.println("Select option: ");
            System.out.println("1. Get All Universities");
            System.out.println("2. Get University By ID");
            System.out.println("3. Create University");
            System.out.println("0. Go back");

            try {
                System.out.println("Enter option 1-3: ");
                int option = scanner.nextInt();

                if (option == 1) {
                    getAllUniversitiesMenu();
                } else if (option == 2) {
                    getUniversityById();
                } else if (option == 3) {
                    createUniversityMenu();
                } else if (option == 0) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer");
                scanner.nextLine(); // to ignore incorrect input
            }
        }
    }

    public void getAllUniversitiesMenu() {
        System.out.println(MENU_LINE);
        System.out.println("All Universities\n");

        System.out.println(universityController.getAll());
    }

    public void getUniversityById() {
        try {
            System.out.println(MENU_LINE);

            System.out.println("Enter id: ");

            int id = scanner.nextInt();
            System.out.println("\n" + universityController.getById(id) + "\n");
        } catch (InputMismatchException e) {
            System.out.println("Input must be integer");
            scanner.nextLine(); // to ignore incorrect input
        }
    }

    public void createUniversityMenu() {
        try {
            // To ignore whitespace from previous input
            scanner.nextLine();
            System.out.println(MENU_LINE);

            System.out.println("Enter university name: ");
            String name = scanner.nextLine();

            System.out.println("Enter how many university programs to input: ");
            int numberOfPrograms = scanner.nextInt();
            // To ignore whitespace from previous input
            scanner.nextLine();

            // Arrays to store program names, minimum scores, and elective subject names
            String[] programNames = new String[numberOfPrograms];
            int[] minimumScores = new int[numberOfPrograms];
            String[][] electivesArr = new String[numberOfPrograms][2];

            for (int i = 0; i < programNames.length; i++) {
                System.out.println("Enter program name: ");
                programNames[i] = scanner.nextLine();

                System.out.println("Enter minimum passing score: ");
                minimumScores[i] = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter first elective subject name: ");
                electivesArr[i][0] = scanner.nextLine();

                System.out.println("Enter second elective subject name: ");
                electivesArr[i][1] = scanner.nextLine();
            }

            System.out.println(
                    "\n" + universityController.create(
                            name, programNames, minimumScores, electivesArr
                    ) + "\n");
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input");
        }
    }
}
