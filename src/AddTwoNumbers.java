import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AddTwoNumbers {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int [nums.length];
        for (int i = 0; i< nums.length; i++) {
            System.out.println(Arrays.stream(nums).boxed().reduce((integer, integer2) -> integer * integer2).get());
//            List<Integer> restOfTheNumbers = Arrays.stream(nums).boxed().reduce((integer, integer2) -> integer * integer2).get();
//            restOfTheNumbers.remove(i);
//            int countedVal = restOfTheNumbers.stream().reduce((integer, integer2) -> integer * integer2).get();
//            result[i] = countedVal;
        }
        return result;

    }
}
