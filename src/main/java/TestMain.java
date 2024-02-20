import models.*;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject("math lit", 15));
        subjects.add(new Subject("read lit", 14));
        subjects.add(new Subject("kaz hist", 18));
        subjects.add(new Subject("info", 35));
        subjects.add(new Subject("math", 31));

        User u1 = new User(
                1,
                "Almat",
                "Almatov",
                "almat@email.com",
                "77777777777",
                subjects
        );

        System.out.println(u1);

        Program p1 = new Program(
                1,
                "Software Engineering",
                85,
                new String[]{"Info","Math"}
        );

        Program p2 = new Program(
                2,
                "Big Data Analysis",
                85,
                new String[]{"Info","Math"}
        );
        List<Program> programs = new ArrayList<>();
        programs.add(p1);
        programs.add(p2);

        University uni1 = new University(
                1,
                "Astana IT University",
                programs
        );

        System.out.println(uni1);
    }
}
