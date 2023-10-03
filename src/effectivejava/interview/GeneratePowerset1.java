package effectivejava.interview;

import java.util.ArrayList;
import java.util.List;

public class GeneratePowerset1 {
    public static void main(String[] args) {
        String[] input = new String[]{"a", "b", "c", "d"};
        System.out.println(generatePowerset(input));
    }

    static public List<List<String>> generatePowerset(String[] input) {
        return generatePowerset(input, 0);
    }

    static List<List<String>> generatePowerset(String[] input, int startIdx) {
        if (startIdx == input.length) {
            List<String> emptySet = new ArrayList<>();
            List<List<String>> result = new ArrayList<>();
            result.add(emptySet);
            return result;
        }

        List<List<String>> result = new ArrayList<>();
        List<List<String>> recursionResult = generatePowerset(input, startIdx + 1);
        for (List<String> temp : recursionResult) {
            List<String> newList = new ArrayList<>(temp);
            newList.add(input[startIdx]); // includes the current element into the returned subset
            result.add(newList); // Add the subset that includes the current element
            result.add(temp); // Add the subset that does not include the current element
        }
        return result;
    }
}

//val t1 = T1.sort(col("id"))
//val t2 = T2.sort(col("id"));

val diff = t1.join(t2,col(id),"left_anti"