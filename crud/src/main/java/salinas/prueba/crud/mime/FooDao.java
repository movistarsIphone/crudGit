package salinas.prueba.crud.mime;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooDao extends CrudRepository<Foo, Long>{
}
