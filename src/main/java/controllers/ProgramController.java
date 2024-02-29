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
            return "No Programs found";

        StringBuilder response = new StringBuilder();
        for (Program program : programs) {
            response.append(program.toString()).append("\n");
        }

        return response.toString();
    }

    public String getById(int id) {
        Program program = programService.getById(id);
        if (program == null)
            return "Program was not found";
        return program.toString();
    }

    public String create(int id, String name, int min, String[] electives) {
        // Instantiate new Program and pass it to create method
        Program program = new Program(id, name, min, elec);
        Program createdProgram = programService.create(program);

        // Check if the create method returned a Program object
        if (createdProgram != null)
            return "Created Program\n" + createdProgram.toString();
        return "Failed to create Program";
    }
}
