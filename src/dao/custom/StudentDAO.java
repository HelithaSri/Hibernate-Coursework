package dao.custom;

import dao.SupperDAO;
import entity.Program;
import entity.Student;

import java.util.List;

/**
 * @author HelithaSri
 * @created 12/24/2021 - 10:04 PM
 * @project HibernateCW
 */
public interface StudentDAO extends SupperDAO<Student, String> {
    boolean register(Student student, String cmb1, String cmb2, String cmb3, String cmb4);

    boolean updateRegister(Student student, String cmb1, String cmb2, String cmb3, String cmb4);

    boolean deleteRegister(Student student, String cmb1, String cmb2, String cmb3, String cmb4);
}
