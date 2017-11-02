package ThreadsAndLocks;

/**
 * Created by Goki_PC on 11/2/2017.
 */
public class FizzBuzzThread extends Thread {

    private static Object lock = new Object();
    protected static int current = 1;
    private int max;
    private boolean div3, div5;
    private String toPrint;

    public FizzBuzzThread(boolean div3, boolean div5, int max, String toPrint)
    {
        this.div3 = div3;
        this.div5 = div5;
        this.toPrint = toPrint;
        this.max = max;
    }

    public void print()
    {
        System.out.println(toPrint);
    }

    public void run()
    {
        while(true)
        {
            synchronized (lock)
            {
                if (current > max) return;

                if((current%3 == 0) == div3 && (current % 5 == 0) == div5)
                {
                    print();
                    current++;
                }
            }
        }
    }
}
