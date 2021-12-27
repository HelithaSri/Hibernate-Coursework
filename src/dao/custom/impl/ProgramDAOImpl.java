package dao.custom.impl;

import dao.custom.ProgramDAO;
import entity.Program;
import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;
import view.tm.ProgramTM;

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
        Program program = session.get(Program.class, Id);
        session.delete(program);
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

    @Override
    public List<Program> searchPrograms(String value) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("FROM Program p WHERE p.programId LIKE ?1");
        query.setParameter(1,'%'+value+'%');
        List list = query.list();

/*
//        Query query = session.createQuery("from Program WHERE CONCAT(programId, programName) LIKE CONCAT('%', ?1, '%')");
        Query query = session.createQuery("from Program WHERE CONCAT(programId, programName) LIKE ?1");
//        Query query = session.createQuery("from Program WHERE CONCAT(programId, programName) LIKE ?1");
        query.setParameter(1,value);
//        query.setParameter(1,"%"+value+"%");
        List<ProgramTM> list = query.list();
*/

        transaction.commit();
        session.close();
        return list;
    }
}
