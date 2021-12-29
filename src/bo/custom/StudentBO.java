package bo.custom;

import bo.SuperBO;
import dao.custom.StudentDAO;
import dto.ProgramDTO;
import dto.StudentDTO;
import entity.Program;
import entity.Student;
import javafx.collections.ObservableList;
import view.tm.StudentTM;

import java.util.List;

/**
 * @author HelithaSri
 * @created 12/24/2021 - 11:18 PM
 * @project HibernateCW
 */
public interface StudentBO extends SuperBO {
    boolean add(StudentDTO studentDTO);

    ObservableList<StudentTM> find();

    boolean delete(String id);

    boolean update(StudentDTO studentDTO);


}
