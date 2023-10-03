package effectivejava;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Foo {
    ReentrantLock lock = new ReentrantLock();
    Condition second = lock.newCondition();
    Condition third = lock.newCondition();
    AtomicInteger status = new AtomicInteger(1);

    public static void main(String[] args) throws InterruptedException {

        Foo foo = new Foo();
        foo.first(() -> {
            try {
                foo.lock.lock();
                System.out.println("first");
                foo.status.incrementAndGet();
                foo.second.signal();
            } finally {
                foo.lock.unlock();

            }
        });
        foo.second(() -> {
            try {
                foo.lock.lock();
                while (foo.status.get() != 2) {
                    foo.second.await();
                }
                System.out.println("second");
                foo.status.incrementAndGet();
                foo.third.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                foo.lock.unlock();
            }

        });
        foo.third(() -> {
            try {
                foo.lock.lock();
                while (foo.status.get() != 3) {
                    foo.third.await();
                }
                System.out.println("third");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                foo.lock.unlock();
            }
        });
    }

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}