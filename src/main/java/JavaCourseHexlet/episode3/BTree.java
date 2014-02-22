package JavaCourseHexlet.episode3;

/**
 * Created by mikalai on 2/22/14.
 */
public class BTree<T extends Comparable<T>> implements IBTree<T> {

    private IBTree left;

    private IBTree right;

    private final T value;

    private int count = 1;

    //to make fields safe for threads you can use:
    //1. volatile for field;
    //2. AtomicInteger class (increments of Double and Long are not one operation);
    //3. synchronized (for method).

    public BTree(T value) {
        this.value = value;
    }

    @Override
    public IBTree getLeft() {
        return left;
    }

    @Override
    public IBTree getRight() {
        return right;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void add(T value) {
        if (value.equals(getValue()))
            increment();
        else if (value.compareTo(getValue()) < 0) {
            addLeft(value);
        } else {
            addRight(value);
        }
    }

    @Override
    public void forEach(final Process<T> process) {
        new Thread() {
            @Override
            public void run() {
                process.process(getValue());
            }
        }.start();
        if (getLeft() != null) {
            getLeft().forEach(process);
        }
        if (getRight() != null) {
            getRight().forEach(process);
        }
    }

    private void increment() {
        int oldCount = getCount();
        int count = oldCount + 1;
        count++;
        if (count > 100)
            count = 0;
        Thread.yield();
        if (oldCount != getCount())
            System.out.println("Hi");
        this.count = count;
    }

    private void addLeft(T value) {
        if (getLeft() == null) {
            setLeft(new BTree<>(value));
        }
        left.add(value);
    }

    private void addRight(T value) {
        if (getRight() == null) {
            setRight(new BTree<>(value));
        }
        right.add(value);
    }

    private void setRight(IBTree right) {
        this.right = right;
    }

    private void setLeft(IBTree left) {
        this.left = left;
    }
}
