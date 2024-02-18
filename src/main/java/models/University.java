package models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@Getter @Setter

public class University{
    private int id;
    private String universityName;
    private List<Program> programs;

    @Override
    public String toString() {
        return "University:" +
                "id=" + getId() +
                "universityName='" + getUniversityName() +
                "programs=" + getPrograms();
    }

}


