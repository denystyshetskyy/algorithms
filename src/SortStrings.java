import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortStrings {

    public List<String> prioritizedOrders(int numOrders, List<String> orderList)
    {
        if (orderList.isEmpty()) {
            return new ArrayList<String>();
        } else {
            List<String> primeList = orderList.stream().filter(s -> isPrime(s)).sorted((o1, o2) -> o2.compareTo(o1)).collect(Collectors.toList());
            List<String> nonPrimeList = orderList.stream().filter(s -> !isPrime(s)).sorted((o1, o2) -> o2.compareTo(o1)).collect(Collectors.toList());
            List<String> result = new ArrayList<>(primeList);
            result.addAll(nonPrimeList);
            return result;

        }
    }

    boolean isPrime(String val) {
        return !val.substring(val.indexOf(" ")).matches(".*[0-9].*");
    }

}
