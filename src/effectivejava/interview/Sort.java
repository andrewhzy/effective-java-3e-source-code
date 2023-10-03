package effectivejava.interview;

public class Sort {
    public int[] sort(int[] input) {
        int[] counts = new int[3];
        for (int i : input) {
            counts[i]++;
        }
        int i = 0;
        for (int count : counts) {
            for (int j = 0; j < count; j++) {
                input[i] = 0;
                i++;
            }
        }


        return input;
    }
        public static void main(String[] args) {
            A x = new A("John", 20);
            A y = new A("John", 20);

            System.out.println(x == y); // false
            System.out.println(x.equals(y)); // false
        }

}
// a, b, c, d
//output:"",a,b,c,d,ab,ac,ad,bc,bd,cd,abc,abd,acd,bcd,abcd,