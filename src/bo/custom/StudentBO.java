package bo.custom;

import bo.SuperBO;
import dao.custom.StudentDAO;
import dto.StudentDTO;

import java.util.List;

/**
 * @author HelithaSri
 * @created 12/24/2021 - 11:18 PM
 * @project HibernateCW
 */
public interface StudentBO extends SuperBO {
    boolean add(StudentDTO studentDTO);

    List<StudentDTO> find();

    boolean delete(String id);

    boolean update(StudentDTO studentDTO);
}
