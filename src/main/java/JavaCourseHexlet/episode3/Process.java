package JavaCourseHexlet.episode3;

/**
 * Created by mikalai on 2/22/14.
 */
public class Process<T extends Comparable<T>> implements IBTree.Process<T>{

    @Override
    public void process(T value) {
        System.out.println(value);
    }
}
