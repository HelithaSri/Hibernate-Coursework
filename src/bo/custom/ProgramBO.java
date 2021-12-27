package bo.custom;

import bo.SuperBO;
import dto.ProgramDTO;
import dto.StudentDTO;
import javafx.collections.ObservableList;
import view.tm.ProgramTM;

import java.util.List;

/**
 * @author HelithaSri
 * @created 12/24/2021 - 11:19 PM
 * @project HibernateCW
 */
public interface ProgramBO extends SuperBO {
    boolean add(ProgramDTO programDTO);

    ObservableList<ProgramTM> find();

    boolean delete(String id);

    boolean update(ProgramDTO programDTO);

    ObservableList<ProgramTM> search(String value);
}
