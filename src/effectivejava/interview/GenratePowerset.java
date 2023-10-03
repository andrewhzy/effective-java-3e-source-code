package effectivejava.interview;

import java.util.ArrayList;
import java.util.List;

public class GenratePowerset {

    public static void main(String[] args) {
        String[] input = new String[]{"a", "b", "c", "d"};
        System.out.println(generatePowerset(input));
    }

    static public List<List<String>> generatePowerset(String[] input) {
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            res.addAll(getCombinations(input, i));
        }
        return res;
    }


    static public List<List<String>> getCombinations(String[] input, int k) {
        List<List<String>> combinations = new ArrayList<>();
        combine(input, k, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private static void combine(String[] input, int k, int start, List<String> combination, List<List<String>> combinations) {
        if (k == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i <= input.length - k; i++) {
            combination.add(input[i]);
            combine(input, k - 1, i + 1, combination, combinations);
            combination.remove(combination.size() - 1);
        }
    }
//
//    static List<List<String>> generate4i(String[] input, int startIdx, int cnt) {
//        List<List<String>> res4i = new ArrayList<>();
//        if (cnt == 0) {
//            res4i.add(List.of(""));
//        } else {
//            res4i.addAll(generate4i(input, startIdx + 1, cnt));
//
//            for (List<String> list : generate4i(input, startIdx + 1, cnt - 1)) {
//                list.add(input[startIdx]);
//                res4i.add(list);
//            }
//        }
//        return res4i;
//    }

}
// a, b, c, d
//output:"",a,b,c,d,ab,ac,ad,bc,bd,cd,abc,abd,acd,bcd,abcd,