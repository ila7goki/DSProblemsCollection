package ThreadsAndLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophersOriginal {
    public static void main(String[] args)
    {
        Chopstick ch1 = new Chopstick(1);
        Chopstick ch2 = new Chopstick(2);
        Chopstick ch3 = new Chopstick(3);
        Chopstick ch4 = new Chopstick(4);
        Chopstick ch5 = new Chopstick(5);

        Philosopher ph1 = new Philosopher(ch1, ch5, 1);
        Philosopher ph2 = new Philosopher(ch2, ch1, 2);
        Philosopher ph3 = new Philosopher(ch3, ch2, 3);
        Philosopher ph4 = new Philosopher(ch4, ch3, 4);
        Philosopher ph5 = new Philosopher(ch5, ch4, 5);

        ph1.start();
        ph2.start();
        ph3.start();
        ph4.start();
        ph5.start();
    }
}
