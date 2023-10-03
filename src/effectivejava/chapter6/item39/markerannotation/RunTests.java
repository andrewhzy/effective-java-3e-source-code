package effectivejava.chapter6.item39.markerannotation;

// Program to process marker annotations (Page 182)

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("ALL")
public class RunTests {
    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;
        String className = "effectivejava.chapter6.item39.markerannotation.Sample";
        Class<?> testClass = Class.forName(className);
        Collections.sort(null);

        Arrays.sort(new double[]{});

        String[] strings = {"flsdjl", "jflkds", "jfldsjk"};

        Arrays.sort(strings);
        System.out.println(strings);
        Arrays.sort(strings, (a, b) -> a.length() - b.length());
        System.out.println(strings);


        List<Integer> integers = new LinkedList<>();
        integers.sort(null);
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    System.out.println(m + " failed: " + exc);
                } catch (Exception exc) {
                    System.out.println("Invalid @Test: " + m + " : " + exc);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n",
                passed, tests - passed);
    }
}
