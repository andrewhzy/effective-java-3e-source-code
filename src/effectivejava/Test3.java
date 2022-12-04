package effectivejava;

public class Test3 {
    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < 1000; i++) {
//            new Thread(() -> System.out.println("jklfdsjlf".substring(222, 2))).start();
//        }
        int size1 = 1 << 31 - 1;
        int size2 = (1 << 31) - 1;
        byte[] ints = new byte[size1];
        System.out.println(ints.length);

        Thread.sleep(1000);
    }

}
