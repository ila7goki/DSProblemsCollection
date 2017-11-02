package ThreadsAndLocks;

/**
 * Created by Goki_PC on 11/2/2017.
 */
public class FizzBuzzTest {

    public static void main(String[] args)
    {
        Thread[] threads = {new FizzBuzzThread(true, true, 15, "FizzBuzz"),
                            new FizzBuzzThread(true, false, 15, "Fizz"),
                            new FizzBuzzThread(false, true, 15, "Buzz"),
                            new NumberFizzBuzzThread(false, false, 15)};

        for (Thread t : threads)
        {
            t.start();
        }
    }
}
