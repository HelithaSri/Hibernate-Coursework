package dao;

import dao.custom.impl.ProgramDAOImpl;
import dao.custom.impl.QueryDAOImpl;
import dao.custom.impl.StudentDAOImpl;

/**
 * @author HelithaSri
 * @created 12/24/2021 - 11:34 PM
 * @project HibernateCW
 */
public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){

    }

    public static DAOFactory getDAOFactory(){
        if (daoFactory==null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public SupperDAOUltraProMax getDAO(DAOTypes types){
        switch (types){
            case STUDENT:
                return new StudentDAOImpl();
            case PROGRAM:
                return new ProgramDAOImpl();
            case Query:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }
    public enum DAOTypes{
        STUDENT, PROGRAM, Query
    }
}
