package ThreadsAndLocks;

/**
 * Created by Goki_PC on 11/2/2017.
 */
public class NumberFizzBuzzThread extends FizzBuzzThread {

    public NumberFizzBuzzThread(boolean div3, boolean div5, int max)
    {
        super(div3, div5, max, null);
    }

    public void print()
    {
        System.out.println(current);
    }
}
