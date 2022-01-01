package dao.custom.impl;

import dao.custom.QueryDAO;
import entity.Program;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author HelithaSri
 * @created 1/1/2022 - 6:01 PM
 * @project HibernateCW
 */
public class QueryDAOImpl implements QueryDAO {

    @Override
    public List<Program> getStudentPrograms(String value) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
//        Query query = session.createQuery("SELECT p.programId FROM Student_Detail sp INNER JOIN Program p ON  sp.programList_programId = p.programId WHERE sp.studentList_regNum=?1");
//        Query query = session.createQuery("SELECT p.* FROM (SELECT s.regNum FROM Student.s) sp INNER JOIN Program p ON  sp.programList_programId = p.programId WHERE s.regNum=1?");

        String sql = "select p.* from student_program sp inner join program p ON sp.programList_programId = p.programId where sp.studentList_regNum=?1";
        NativeQuery nativeQuery = session.createNativeQuery(sql).addEntity(Program.class);
        nativeQuery.setParameter(1,value);
        List list = nativeQuery.list();

        /*for (Object o: list) {
            Program program = (Program) o;
            System.out.println(program.getProgramId());
        }*/


        transaction.commit();
        session.close();
        return list;
    }
}
