package cyberlogitec.training.project.ecommerce.common;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface IGenericService<T extends AbstractEntity, ID> {
    public List<T> findAll();

    public T save(T entity);

    public Optional<T> findById(ID id);

    public void deleteById(ID id);
}
