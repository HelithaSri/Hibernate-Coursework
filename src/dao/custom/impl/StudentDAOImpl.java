package dao.custom.impl;

import dao.custom.StudentDAO;
import entity.Program;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.List;

/**
 * @author HelithaSri
 * @created 12/24/2021 - 10:12 PM
 * @project HibernateCW
 */
public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean add(Student entitiy) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entitiy);
        transaction.commit();
        session.close();
        return false;
    }

    @Override
    public boolean update(Student entitiy) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entitiy);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String Id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, Id);
        session.delete(student);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Student> find() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Student s ORDER BY s.regNum DESC ");
        List<Student> list = query.list();

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public boolean register(Student student, String cmb1, String cmb2, String cmb3, String cmb4) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

//        System.out.println("cmd 1 :"+cmb1);
//        System.out.println("cmd 2 :"+cmb2);
//        System.out.println("cmd 3 :"+cmb3);
//        System.out.println("cmd 4 :"+cmb4);
        /*Program program1 = session.get(Program.class, cmb1);
        student.getProgramList().add(program1);*/

        if (cmb1 != null && !cmb1.trim().isEmpty()) {
            Program program1 = session.get(Program.class, cmb1);
            student.getProgramList().add(program1);
        } else {
            return false;
        }

        if (cmb2 != null && !cmb2.trim().isEmpty()) {
            Program program2 = session.get(Program.class, cmb2);
            student.getProgramList().add(program2);
        }

        if (cmb3 != null && !cmb3.trim().isEmpty()) {
            Program program3 = session.get(Program.class, cmb3);
            student.getProgramList().add(program3);
        }

        if (cmb4 != null && !cmb4.trim().isEmpty()) {
            Program program4 = session.get(Program.class, cmb4);
            student.getProgramList().add(program4);
        }

        session.save(student);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean deleteRegister(Student student, String cmb1, String cmb2, String cmb3, String cmb4) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

/*
        System.out.println("cmd 1 :" + cmb1);
        System.out.println("cmd 2 :" + cmb2);
        System.out.println("cmd 3 :" + cmb3);
        System.out.println("cmd 4 :" + cmb4);
*/

        if (cmb1 != null && !cmb1.trim().isEmpty()) {
            Program program1 = session.get(Program.class, cmb1);
            student.getProgramList().add(program1);
        }

        if (cmb2 != null && !cmb2.trim().isEmpty()) {
            Program program2 = session.get(Program.class, cmb2);
            student.getProgramList().add(program2);
        }

        if (cmb3 != null && !cmb3.trim().isEmpty()) {
            Program program3 = session.get(Program.class, cmb3);
            student.getProgramList().add(program3);
        }

        if (cmb4 != null && !cmb4.trim().isEmpty()) {
            Program program4 = session.get(Program.class, cmb4);
            student.getProgramList().add(program4);
        }

        session.delete(student);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Student> searchStudent(String value) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("FROM Student s WHERE s.regNum LIKE ?1");
        query.setParameter(1, '%' + value + '%');
        List list = query.list();

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public boolean updateNatively(String studentRegNo, String cmb1) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

//        System.out.println(studentRegNo);
//        System.out.println(cmb1);
          session.createNativeQuery("INSERT INTO STUDENT_PROGRAM VALUES(?, ?)").setParameter(1, studentRegNo).setParameter(2, cmb1).executeUpdate();
//        System.out.println("hey : "+i);

       /* Query query = session.createQuery("FROM Student s WHERE s.regNum LIKE ?1");
        query.setParameter(1, '%' + value + '%');
        List list = query.list();*/

        transaction.commit();
        session.close();
        return true;
    }
}
