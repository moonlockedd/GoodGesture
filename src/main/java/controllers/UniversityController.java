package controllers;

import lombok.AllArgsConstructor;
import models.Program;
import models.University;
import services.interfaces.IUniversityService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class UniversityController {
    private final IUniversityService universityService;

    public String getAll() {
        List<University> universities = universityService.getAll();

        if (universities.isEmpty())
            return "No Universities were found";

        StringBuilder response = new StringBuilder();

        for (University university : universities) {
            response.append(university.toString()).append("\n\n");
        }

        return response.toString();
    }

    public String getById(int id) {
        University university = universityService.getById(id);

        if (university == null)
            return "University was not found";

        return university.toString();
    }

    public String create(
            String name, String[] programNames,
            int[] minimumScores, String[][] electivesArr
    ) {
        List<Program> programs = new ArrayList<>();

        for (int i = 0; i < programNames.length; i++) {
            programs.add(new Program(
                    programNames[i],
                    minimumScores[i],
                    new String[]{
                            electivesArr[i][0],
                            electivesArr[i][1]
                    }
            ));
        }

        University university = new University(name, programs);
        University createdUniversity = universityService.create(university);

        if (createdUniversity == null)
            return "Could not create University";
        return createdUniversity.toString();
    }
}
