package JavaCourseHexlet.episode3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mikalai on 2/22/14.
 */
public class ThreadExample {

    public static void main(String[] args) throws InterruptedException {
        final IBTree<Integer> bTree = new BTree<>(1);
        bTree.add(12);
        bTree.add(1);
        bTree.add(1);
        bTree.add(1);

        List<Thread> threads = new ArrayList<>(1000);

        for (int i=0; i<1000; i++) {
            final int finalI = i;
            threads.add(new Thread() {
                @Override
                public void run() {
                    bTree.add(finalI);
                }
            });
        }

        for (Thread thread: threads) {
            thread.start();
        }


        for (Thread thread: threads) {
            thread.join();
        }

        bTree.forEach(new Process<Integer>());

        System.out.println("End");

    }
}
