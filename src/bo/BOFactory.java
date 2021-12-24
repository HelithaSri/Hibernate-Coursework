package bo;

import bo.custom.impl.ProgramBOImpl;
import bo.custom.impl.StudentBOImpl;

/**
 * @author HelithaSri
 * @created 12/25/2021 - 1:18 AM
 * @project HibernateCW
 */
public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){

    }

    public static BOFactory getBoFactory(){
        if (boFactory==null){
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public SuperBO getBO(BoTypes types){
        switch (types){
            case STUDENT:
                return new StudentBOImpl();
            case PROGRAM:
                return new ProgramBOImpl();
            default:
                return null;
        }
    }

    public enum BoTypes{
        STUDENT, PROGRAM
    }
}
