package effectivejava.interview;

import java.util.Arrays;

public class Sort1 {
    public static void main(String[] args) {
        int[] ints = new int[]{0, 0, 1, 2, 1, 2, 0, 0, 0, 1, 2};
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(sort(ints)));
    }

    static public int[] sort(int[] input) {
        int lo = 0, i = 0, hi = input.length - 1;
        while (i < hi) {
            if (input[i] == 0) {
                swap(input, lo-1, i);
                lo++;
                i++;
                continue;
            }
            if (input[i] == 1) {
                i++;
                continue;
            }
            if (input[i] == 2) {
                swap(input, i, hi);
                hi--;
                continue;
            } else {
                throw new RuntimeException("this value is not allowed");
            }
        }
        return input;
    }

    static void swap(int[] ints, int i, int j) {
        int tmp = ints[j];
        ints[j] = ints[i];
        ints[i] = tmp;
    }

}
// a, b, c, d
//output:"",a,b,c,d,ab,ac,ad,bc,bd,cd,abc,abd,acd,bcd,abcd,