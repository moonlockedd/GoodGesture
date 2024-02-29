package controllers;

import lombok.AllArgsConstructor;
import models.Program;
import services.interfaces.IProgramService;

import java.util.List;

@AllArgsConstructor
public class ProgramController {
    private final IProgramService programService;

    public String getAll() {
        List<Program> programs = programService.getAll();
        if (programs.isEmpty())
            return "No Programs were found";

        StringBuilder response = new StringBuilder();
        for (Program program : programs) {
            response.append(program.toString()).append("\n\n");
        }

        return response.toString();
    }

    public String getById(int id) {
        Program program = programService.getById(id);

        if (program == null)
            return "Program was not found";

        return program.toString();
    }

    public String create(String name, int min, String[] electives) {
        Program program = new Program(name, min, electives);
        Program createdProgram = programService.create(program);

        if (createdProgram != null)
            return "Created Program\n" + createdProgram;
        return "Failed to create Program";
    }
}
