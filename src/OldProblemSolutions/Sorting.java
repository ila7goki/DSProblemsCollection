package OldProblemSolutions;

/**
 * Created by Goki_PC on 5/5/2017.
 */
public class Sorting {

    private int[] helperArray;

    public void mergeSort(int[] inputArray)
    {
        int length = inputArray.length;
        helperArray = new int[length];
        mergeSort(inputArray, 0, length-1);
        displayArray(inputArray);
    }

    private void mergeSort(int[] inputArray, int left, int right)
    {
        if(left < right)
        {
            int middle = (left + right)/2;
            mergeSort(inputArray, left, middle);
            mergeSort(inputArray, middle+1, right);
            merge(inputArray, left, right, middle);
        }
    }

    private void displayArray(int[] array)
    {
        for (int i=0; i<array.length; i++)
        {
            System.out.print(array[i]);
            if(i < array.length-1)
            {
                System.out.print(", ");
            }
            else
            {
                System.out.println();
            }
        }
    }

    private void merge(int[] inputArray, int low, int high, int middle)
    {
        for (int i=low; i <= high; i++)
        {
            helperArray[i] = inputArray[i];
        }

        int helperLeft = low;
        int helperRight = middle+1;
        int current = low;

        while(helperLeft <= middle && helperRight <= high)
        {
            if(helperArray[helperLeft] <= helperArray[helperRight])
            {
                inputArray[current] = helperArray[helperLeft];
                helperLeft++;
            }
            else
            {
                inputArray[current] = helperArray[helperRight];
                helperRight++;
            }
            current++;
        }

        displayArray(inputArray);
        displayArray(helperArray);
        System.out.println(middle-helperLeft + "," + middle + ", " + helperLeft + ", " + helperRight + ", " + current);
        for(int i=0; i<=middle-helperLeft; i++)
        {
            inputArray[current + i] = helperArray[helperLeft + i];
        }
    }
}
