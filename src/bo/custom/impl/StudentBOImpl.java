package bo.custom.impl;

import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.custom.StudentDAO;
import dao.custom.impl.StudentDAOImpl;
import dto.StudentDTO;
import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import view.tm.ProgramTM;
import view.tm.StudentTM;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HelithaSri
 * @created 12/24/2021 - 11:31 PM
 * @project HibernateCW
 */
public class StudentBOImpl implements StudentBO {
    private final StudentDAOImpl studentDAO = (StudentDAOImpl) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public boolean add(StudentDTO studentDTO) {
        return studentDAO.add(new Student(
                studentDTO.getRegNum(),
                studentDTO.getName(),
                studentDTO.getAge(),
                studentDTO.getAddress(),
                studentDTO.getEmail(),
                studentDTO.getDob(),
                studentDTO.getNic(),
                studentDTO.getContactNum(),
                studentDTO.getGender()
        ));
    }

    @Override
    public ObservableList<StudentTM> find() {
        List<Student> list = studentDAO.find();
        ObservableList<StudentTM> dtoArrayList = FXCollections.observableArrayList();

        for (Student student : list) {
            dtoArrayList.add(new StudentTM(
                    student.getRegNum(),
                    student.getName(),
                    student.getAge(),
                    student.getAddress(),
                    student.getEmail(),
                    student.getDob(),
                    student.getNic(),
                    student.getContactNum(),
                    student.getGender()
            ));
        }
        return dtoArrayList;
    }

    @Override
    public boolean delete(String id) {
        return studentDAO.delete(id);
    }

    @Override
    public boolean update(StudentDTO studentDTO) {
        return studentDAO.update(new Student(
                studentDTO.getRegNum(),
                studentDTO.getName(),
                studentDTO.getAge(),
                studentDTO.getAddress(),
                studentDTO.getEmail(),
                studentDTO.getDob(),
                studentDTO.getNic(),
                studentDTO.getContactNum(),
                studentDTO.getGender()
        ));
    }
}
