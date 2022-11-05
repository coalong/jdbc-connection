import lombok.Getter;

@Getter
public class Table {
    private final int id;
    private final String name;
    private final int age;
    private final int salary;

    public Table(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Table{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age + '\'' +
            ", salary=" + salary + '\'' +
            '}';
    }
}
