package ThreadsAndLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Goki_PC on 10/30/2017.
 */


    class Chopstick
    {
        Lock lock;
        int num;

        public Chopstick(int num)
        {
            this.num = num;
            this.lock = new ReentrantLock();
        }


        public void pickUp()
        {
            lock.lock();
            System.out.println("Picked up chopstick " + this.num);
        }

        public void putDown()
        {
            lock.unlock();
            System.out.println("Put down Chopstick: " + this.num);
        }
    }
