package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int n) {
        List<String> res = new ArrayList<>();
        apartments.sort(Home::compareTo);
        for (int i = 0; i < (Math.min(apartments.size(), n)); i++) {
            res.add(apartments.get(i).toString());
        }
        return res;
    }
}
// END
