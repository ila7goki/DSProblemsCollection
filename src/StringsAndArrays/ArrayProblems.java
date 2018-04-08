package StringsAndArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Goki_PC on 11/2/2017.
 */
public class ArrayProblems {

    public static List<List<Integer>> findThreeSumPairs(int[] inputArr, int target)
    {
        int arrLen = inputArr.length;
        int[] nums = Arrays.copyOf(inputArr, arrLen);
        List<List<Integer>> outputList = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i < arrLen-2; i++)
        {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int lo = i+1;
            int hi = arrLen -1;

            while(lo < hi)
            {
                int sum = nums[i] + nums[lo] + nums[hi];
                if(sum == target)
                {
                    outputList.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    lo++;
                    hi--;
                    while(nums[lo] == nums[lo-1] && lo < hi) lo++;
                    while(nums[hi] == nums[hi+1] && lo < hi) hi--;
                }
                else if(sum < target)
                {
                    lo++;
                    while(nums[lo] == nums[lo-1] && lo < hi) lo++;
                }
                else if(sum > target)
                {
                    hi--;
                    while(nums[hi] == nums[hi+1] && lo < hi) hi--;
                }
            }
        }

        return outputList;
    }

    public static int removeElement(int[] nums, int target)
    {
        int destIdx = 0;
        for(int i=0; i < nums.length; i++)
        {
            if(nums[i] == target)
            {
                i++;
            }

            nums[destIdx++] = nums[i];
        }
        return destIdx;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> results = new ArrayList<>();

        int minLen = Math.min(nums1.length, nums2.length);

        for (int num1 : nums1) {
            map.put(num1, map.getOrDefault(num1, 0) + 1);
        }

        for (int num2 : nums2) {
            int intersect = map.getOrDefault(num2, -1);
            System.out.println(intersect);

            if (intersect > 0) {
                results.add(num2);
                map.put(num2, map.get(num2) - 1);
            }
        }

        int[] output = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            output[i] = results.get(i);
        }

        return output;
    }

    public static void main(String[] args)
    {
        List<List<Integer>> output = findThreeSumPairs(new int[]{-1,0, 1, -2, -1, 4}, -1);

        for (List<Integer> i :output)
        {
            System.out.println(i.toString());
        }

        int arr[] = new int[]{-1,0, 1, -2, -1, 4};

        int newLen = removeElement(arr, -1);
        //System.out.println(Arrays.toString(arr) + ", " + newLen);

        int num1[] = {1, 2, 4, 5, 3, 4, 2, 0}, num2[] = {2, 2, 6, 3, 5};

        System.out.println(Arrays.toString(intersect(num1, num2)));

    }
}
