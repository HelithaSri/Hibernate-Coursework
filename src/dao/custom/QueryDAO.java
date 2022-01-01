package dao.custom;

import dao.SupperDAO;
import dao.SupperDAOUltraProMax;
import entity.Program;
import javafx.collections.ObservableList;
import view.tm.ProgramTM;
import view.tm.StudentTM;

import java.util.List;

/**
 * @author HelithaSri
 * @created 1/1/2022 - 5:59 PM
 * @project HibernateCW
 */
public interface QueryDAO extends SupperDAOUltraProMax {
    List<Program> getStudentPrograms(String value);
}
