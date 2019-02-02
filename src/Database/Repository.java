package Database;

import BussinessLogic.Cat;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();
    List<T> findByCategory(Cat category);
    T findById(Long id) throws ItemNotFoundException;
    void save(T item);
    void delete(Long id) throws ItemNotFoundException;
}
