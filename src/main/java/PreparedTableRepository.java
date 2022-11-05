import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PreparedTableRepository implements TableRepository {
    @Override
    public Optional<Table> findById(Integer id) {
        try (
            Connection connection = DbUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "SELECT id, name, age, salary FROM table01 WHERE id=?");
        ) {
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return Optional.of(
                    new Table(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getInt("salary"))
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public List<Table> findAll() {
        List<Table> tables = new ArrayList<>();
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement statement
                 = connection.prepareStatement("SELECT id, name, age, salary FROM table01");
             ResultSet rs = statement.executeQuery()
        ) {
            while (rs.next()) {
                tables.add(
                    new Table(rs.getInt("id"),
                              rs.getString("name"),
                              rs.getInt("age"),
                              rs.getInt("salary")
                    )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public int insert(Table table) {
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO table01 (id, name, age, salary) VALUES (?,?,?)");
        ) {
            statement.setInt(1, table.getId());
            statement.setString(2, table.getName());
            statement.setInt(3, 5);
            statement.setInt(4, 55);
            return statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateNameById(Integer id, String name) {
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE table01 SET name=? WHERE id=?");
        ) {
            statement.setString(1, name);
            statement.setInt(2, id);
            return statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteById(Integer id) {
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM table01 WHERE id=?");
        ) {
            statement.setInt(1, id);
            return statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
