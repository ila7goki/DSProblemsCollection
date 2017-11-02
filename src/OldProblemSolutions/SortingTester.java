package OldProblemSolutions;

import OldProblemSolutions.Sorting;

import java.util.Random;


/**
 * Created by Goki_PC on 10/15/2017.
 */
public class SortingTester {
    private static int[] numbers;
    private final static int SIZE = 10;
    private final static int MAX = 100000;

    //@Before
    private static void setUp()
    {
        numbers = new int[SIZE];
        Random generator = new Random();
        for(int i=0; i<SIZE; i++)
        {
            numbers[i] = generator.nextInt(MAX);
        }
    }

    //@Test
    private static void testMergeSort()
    {
        long startTime = System.currentTimeMillis();
        Sorting sorter = new Sorting();
        sorter.mergeSort(numbers);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Mergesort Elapsed Time: " + elapsedTime);
        for(int i=0; i<SIZE-1; i++)
        {
            if(numbers[i] > numbers[i+1])
            {

                //Assert.fail("Should not happen");
            }
            System.out.print(numbers[i]);
        }
        //Assert.assertTrue(true);
    }


    public static void main(String[] args)
    {
        setUp();
        testMergeSort();
    }

}
