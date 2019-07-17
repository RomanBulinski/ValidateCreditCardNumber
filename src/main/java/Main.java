import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static boolean validate(String n) {

        String[] num = n.split("");
        int start = 0;

        List<Integer> numbersList = Arrays.asList(num).stream()
                .map(r -> Integer.valueOf(r))
                .collect(Collectors.toList());

        Integer[] numbers = numbersList.toArray(new Integer[0]);

        if (num.length % 2 == 0) {
            start = 0;
        } else if (num.length % 2 != 0) {
            start = 1;
        }

        while (start < num.length % 2) {
            numbers[start] = numbers[start] * 2;
            if (numbers[start] > 9) {
                String[] digitString = String.valueOf(numbers[start]).split("");
                Integer newNum = Integer.valueOf(digitString[0]) + Integer.valueOf(digitString[1]);
                numbers[start] = newNum;
            }
            start += 2;
        }

        Integer sum = Arrays.asList(numbers).stream().collect(Collectors.summingInt(Integer::intValue));

        if (sum % 10 == 0) {
            return true;
        }
        return false;

    }


}
