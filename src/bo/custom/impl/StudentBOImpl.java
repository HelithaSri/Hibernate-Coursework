package bo.custom.impl;

import bo.custom.StudentBO;
import dao.DAOFactory;
import dto.StudentDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HelithaSri
 * @created 12/24/2021 - 11:31 PM
 * @project HibernateCW
 */
public class StudentBOImpl implements StudentBO {
    private final StudentBOImpl studentBOImpl = (StudentBOImpl) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public boolean add(StudentDTO studentDTO) {
        return studentBOImpl.add(new StudentDTO(
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
    public List<StudentDTO> find() {
        List<StudentDTO> list = studentBOImpl.find();
        ArrayList<StudentDTO> dtoArrayList = new ArrayList<>();
        StudentDTO studentDTO = null;

        for (StudentDTO student : list) {
            dtoArrayList.add(new StudentDTO(
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
        return studentBOImpl.delete(id);
    }

    @Override
    public boolean update(StudentDTO studentDTO) {
        return studentBOImpl.update(new StudentDTO(
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
