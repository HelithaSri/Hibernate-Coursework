package dao;

import entity.SuperEntity;

import java.util.List;

/**
 * @author HelithaSri
 * @created 12/24/2021 - 9:07 PM
 * @project HibernateCW
 */
public interface SupperDAO<Entity extends SuperEntity, Id> extends SupperDAOUltraProMax{
    boolean add(Entity entitiy);

    boolean update(Entity entitiy);

    boolean delete(Id Id);

    List<Entity> find();
}
