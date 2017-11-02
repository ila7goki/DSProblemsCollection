package ThreadsAndLocks;

/**
 * Created by Goki_PC on 11/1/2017.
 */
public class Semaphore {

    private boolean signal = false;

    public synchronized void take()
    {
        this.signal = true;
        this.notify();
    }

    public synchronized  void release() throws InterruptedException
    {
        while(!this.signal)
        {
            wait();
            this.signal = false;
        }
    }
}
