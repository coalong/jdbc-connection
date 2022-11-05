import java.util.List;
import java.util.Optional;

public interface TableRepository {
    Optional<Table> findById(Integer id);
    List<Table> findAll();

    int insert(Table table);

    int updateNameById(Integer id, String name);
    int deleteById(Integer id);

}
