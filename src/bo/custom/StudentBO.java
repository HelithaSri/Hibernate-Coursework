package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;
import javafx.collections.ObservableList;
import view.tm.StudentTM;

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

    ObservableList<StudentTM> search(String value);

}
