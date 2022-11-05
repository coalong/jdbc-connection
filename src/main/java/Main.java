import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Main main = new Main();
        // JDBC 4.0 버전부터 자동으로 로드해준다.
        // main.loadDriver();

        TableRepository tableRepository = new PreparedTableRepository();

        System.out.println("==> findAll");
        tableRepository.findAll()
                       .forEach(System.out::println);

        System.out.println("==> findById");
        Optional<Table> byId = tableRepository.findById(1);
        byId.ifPresent(System.out::println);

        int insertCnt = tableRepository.insert(new Table(2, "아로미", 20, 7000));
        System.out.println("inserted Count: " + insertCnt);

        System.out.println("==> findAll");
        tableRepository.findAll()
                       .forEach(System.out::println);

        int updateCnt = tableRepository.updateNameById(1, "이제훈");
        System.out.println("updated Count: " + updateCnt);

        System.out.println("==> findAll");
        tableRepository.findAll()
                       .forEach(System.out::println);

        int deleteCnt = tableRepository.deleteById(1);
        System.out.println("deleted Count: " + deleteCnt);

        System.out.println("==> findAll");
        tableRepository.findAll()
                       .forEach(System.out::println);
        String tr = "123";
        tr.repeat(1);
    }

    private void loadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
