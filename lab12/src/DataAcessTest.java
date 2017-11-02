import java.sql.SQLException;
import java.util.List;
import java.util.stream.IntStream;

public class DataAcessTest {
    public static void main(String[] args) {
        DataAcessLogic acessLogic = new DataAcessLogic();

//        try {
//            names = acessLogic.loadNames(1);
//            names.forEach(System.out::println);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        IntStream.range(1, acessLogic.numberOfPage() + 1).forEach(page->{
            System.out.println("======================" + page);
            try {
                List<String> names = acessLogic.loadNames(1);
                names.forEach(System.out::println);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    }
}
