package effectivejava;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class ReflectionExample {
    public static void main(String[] args) throws Exception {
        // Get Class using reflection
        Class<?> cls = Class.forName("java.lang.String");
        System.out.println("Class name: " + cls.getName());

        // Get superclass
        Class<?> sup = cls.getSuperclass();
        System.out.println("Superclass: " + sup.getName());

        // Get public methods
        Method[] methods = cls.getMethods();
        System.out.println("Public methods:");
        for (Method m : methods) {
            System.out.println(m.getName());
        }

        // Get constructors
        Constructor<?>[] constructors = cls.getConstructors();
        System.out.println("Constructors:");
        for (Constructor c : constructors) {
            System.out.println(c.getName());
        }

        // Create instance of "cls"
        Object obj = cls.newInstance();

        // Get Field
        Field field = cls.getField("CASE_INSENSITIVE_ORDER");
        System.out.println("Field: " + field.getName());

        // Set accessible flag for this field
        field.setAccessible(true);

        // Get and set field value
        System.out.println("Field value: " + field.get(obj));
        field.set(obj, field.getType().cast(1));
        System.out.println("New field value: " + field.get(obj));

        // Invoke public method
        Method method = cls.getMethod("substring", int.class);
        String result = (String) method.invoke(obj, 5);
        System.out.println("Result: " + result);
    }
}