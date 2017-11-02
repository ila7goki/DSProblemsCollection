package OldProblemSolutions;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Goki_PC on 4/21/2017.
 */
public class LeetCode
{

    public static int findHammingDistance(int n1, int n2)
    {
        int xor = n1^n2;
        int count = 0;
        while(xor != 0)
        {
           count += xor & 1;
           xor >>= 1;
        }
        return count;
    }

    private static void reverse(char[] s, int startIdx, int endIdx)
    {
        while(startIdx <= endIdx)
        {
            char temp = s[startIdx];
            s[startIdx++] = s[endIdx];
            s[endIdx--] = temp;
        }
    }

    public static String reverseWords(String s)
    {
        if(s.length() == 1)
            return s;

        if(s.isEmpty())
            return null;

        char[] strChr = s.toCharArray();
        int len = strChr.length;
        s.length();
        int startWord = 0;
        for(int endWord = 0; endWord < len; endWord++)
        {
            if(strChr[endWord] == ' ')
            {
                reverse(strChr, startWord, endWord-1);
                startWord = endWord+1;
            }
        }

        reverse(strChr, startWord, len-1);
        return new String(strChr);
    }

    public static int findCompliment(int num)
    {
        System.out.println(Integer.toBinaryString(num));
        System.out.println(Integer.toBinaryString((1 << num) - 1));

        return 1;
    }

    public static int longestConsecutive(int[] numArr)
    {
        int maxCnt = 0;

        HashSet<Integer> numset = new HashSet<Integer>();
        for (int i : numArr)
        {
            numset.add(i);
        }

        for(int i : numArr)
        {
            int left = i-1;
            int right = i+1;
            int count = 1;

            while(numset.contains(left))
            {
                count++;
                numset.remove(left);
                left--;
            }

            while(numset.contains(right))
            {
                count++;
                numset.remove(right);
                right++;
            }

            maxCnt = Math.max(maxCnt, count);
        }

        return maxCnt;
    }

    public static void main(String args[])
    {
        //Scanner sc = new Scanner(System.in);
        //int n1 = sc.nextInt();
        //int n2 = sc.nextInt();

        //System.out.println("Hamming distance of " + n1 + " and " + n2 + " is " + findHammingDistance(n1, n2));
        //System.out.println(reverseWords("Let's take OldProblemSolutions.LeetCode contest"));

        //findCompliment(5);

//        int max = ~0;
//        int i = 2, j = 6;
//        int n = 1036, m = 21;
//        int one = 1;
//        System.out.println(Integer.toBinaryString(n) + ", " + Integer.toBinaryString(m));
//        System.out.println(Integer.toBinaryString(max));
//        System.out.println(Integer.toBinaryString(one<<j));
//        System.out.println(Integer.toBinaryString((one<<j) -1));
//        System.out.println(Integer.toBinaryString(max - ((one<<j) -1)));
//        System.out.println(Integer.toBinaryString(1 << i));
//        System.out.println(Integer.toBinaryString((1 << i) - 1));
//        int mask = ((1 << i) - 1)|(max - ((one<<j) -1));
//        System.out.println(Integer.toBinaryString(((1 << i) - 1)|(max - ((one<<j) -1))));
//        System.out.println(Integer.toBinaryString(n & mask));
//        System.out.println(Integer.toBinaryString(m << i));
//        System.out.println(Integer.toBinaryString(-13 >> 1));
//        System.out.println(Integer.toBinaryString(-13 >>> 1));


        int n[] = {100, 4, 200, 1, 3, 2, 6, 7, 8, 9, 10};
        System.out.println(longestConsecutive(n));
    }

}
