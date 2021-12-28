package dao.custom;

import dao.SupperDAO;
import dto.ProgramDTO;
import entity.Program;
import javafx.collections.ObservableList;
import view.tm.ProgramTM;

import java.util.List;

/**
 * @author HelithaSri
 * @created 12/24/2021 - 10:08 PM
 * @project HibernateCW
 */
public interface ProgramDAO extends SupperDAO<Program, String> {
    List<Program> searchPrograms(String value);

    List<String> getAllProgramIds();

    ProgramDTO getProgramDetails (String id);
}
