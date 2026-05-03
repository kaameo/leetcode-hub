class Foo {
    private final Semaphore secondReady = new Semaphore(0);
    private final Semaphore thirdReady = new Semaphore(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        secondReady.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        secondReady.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        thirdReady.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        thirdReady.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}