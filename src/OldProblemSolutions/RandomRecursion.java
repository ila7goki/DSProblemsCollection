package OldProblemSolutions;

/**
 * Created by Goki_PC on 4/6/2017.
 */
public class RandomRecursion {

    private static int binarySearch(int[] array, int arrStartIdx, int arrEndIdx, int val) throws Exception
    {
        int range = arrEndIdx - arrStartIdx;
        int arrMidIdx = range/2 + arrStartIdx;

        if(array.length == 0)
            throw new Exception("Empty Array");

        if(range == 0 && array[arrStartIdx] != val)
            throw new Exception("Element not found");

        if(array[arrStartIdx] > array[arrEndIdx])
            throw new Exception("Array is not sorted");

        if(array[arrMidIdx] == val)
            return arrMidIdx;
        else if(array[arrMidIdx] > val)
            return binarySearch(array, arrStartIdx, arrMidIdx-1, val);
        else
            return binarySearch(array, arrMidIdx+1, arrEndIdx, val);
    }

    public static int binarySearch(int[] array, int value)  throws Exception
    {
        return binarySearch(array, 0, array.length-1, value);
    }

    private static void doPermute(String inputString, StringBuilder out, boolean[] used)
    {
        if(out.length() == inputString.length()) {
            System.out.println(out);
            return;
        }

        for(int i = 0; i < inputString.length(); ++i)
        {
            if(used[i]) continue;
            out.append(inputString.charAt(i));
            used[i] = true;
            doPermute(inputString, out, used);
            used[i] = false;
            out.setLength(out.length() - 1);
        }
    }

    public static void permute(final String str)
    {
        final String in = str;
        boolean[] used = new boolean[in.length()];
        StringBuilder out = new StringBuilder();
        doPermute(in, out, used);
    }

    private static void doCombine(int start, String in, StringBuilder out)
    {
        for(int i = start; i < in.length(); ++i)
        {
            out.append(in.charAt(i));
            System.out.println(out);
            if(i < in.length())
                doCombine(i+1, in, out);
            out.setLength(out.length() - 1);
        }
    }

    public static void combine(String str)
    {
        String in = str;
        StringBuilder out = new StringBuilder();
        doCombine(0, in, out);
    }

    public static void main(String[] args) throws Exception
    {
        int[] inputArray = {4, 6, 8, 12, 16, 24, 34, 56};
        int val = 16;
        //System.out.println("Index of " + val + "= " + binarySearch(inputArray, val));
        //permute("cat");
        combine("wxyz");
    }
}
