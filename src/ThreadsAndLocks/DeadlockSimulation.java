package ThreadsAndLocks;

/**
 * Created by Goki_PC on 10/30/2017.
 */
public class DeadlockSimulation {

    String str1 = "Java";
    String str2 = "Cappuccino";

    Thread t1 = new Thread("My thread 1: ")
    {
        public void run()
        {
            System.out.println("Running " + t1.getName());
            while(true) {
                synchronized (str1) {
                    synchronized (str2)
                    {
                        System.out.println(str1 + ", " + str2);
                    }
                }
            }
        }
    };

    Thread t2 = new Thread("My thread 2: ")
    {

        public void run()
        {
            System.out.println("Running " + t2.getName());
                synchronized (str2)
                {
                    synchronized (str1)
                    {
                        System.out.println(str2 + ", " + str1);
                    }
                }
        }
    };

    public static void main(String[] args)
    {
        DeadlockSimulation d = new DeadlockSimulation();
        d.t1.start();
        d.t2.start();
    }
}
