package JavaCourseHexlet.episode3;

/**
 * Created by mikalai on 2/22/14.
 */
public interface IBTree<T extends Comparable<T>> {

    public IBTree getLeft();

    public IBTree getRight();

    public int getCount();

    public T getValue();

    public void add(T value);

    public void forEach(Process<T> p);

    public interface Process<T extends Comparable<T>> {

        public void process(T value);
    }

}
