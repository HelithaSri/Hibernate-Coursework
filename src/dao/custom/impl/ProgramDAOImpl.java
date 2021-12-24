package dao.custom.impl;

import dao.custom.ProgramDAO;
import entity.Program;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.List;

/**
 * @author HelithaSri
 * @created 12/24/2021 - 10:40 PM
 * @project HibernateCW
 */
public class ProgramDAOImpl implements ProgramDAO {

    @Override
    public boolean add(Program entitiy) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entitiy);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Program entitiy) {
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
    public List<Program> find() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Program");
        List<Program> list = query.list();


        transaction.commit();
        session.close();
        return list;
    }
}
