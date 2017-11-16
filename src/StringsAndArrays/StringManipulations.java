package StringsAndArrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Goki_PC on 10/23/2017.
 */
public class StringManipulations {

    public static boolean isUniqueChar(String input)
    {
        boolean[] charSet = new boolean[256];

        if(input.length() > 256) return false;

        for(int i=0; i<input.length(); i++)
        {
            int val = input.charAt(i);
           //System.out.print(val + ",");
            if(input.charAt(i) != ' ' && charSet[val])
            {
                return false;
            }
            charSet[val] = true;
        }
        return true;
    }

    // Using Efficient method.. uses counting of characters in the string and then
    // de-counting so that if permuation results in 0 as a count for each char in input length.
    public static boolean isPermutationStr1(String input1, String input2)
    {
        if(input1.length() != input2.length())
        {
            //System.out.println("Not same length");
            return false;
        }

        int inputLen = input1.length();
        int[] charSet = new int[256];
        for (int i=0; i<inputLen; i++)
        {
            charSet[input1.charAt(i)]++;
        }

        for(int i=0; i<inputLen; i++)
        {
            if(charSet[input2.charAt(i)] < 0) return false;
            charSet[input2.charAt(i)]--;
        }

        return true;
    }

    //Helper method to sort the input string characters and return as string
    private static String sort(String input)
    {
        char[] inArr = new char[input.length()];
        Arrays.sort(inArr);

        return new String(inArr);
    }

    //Using simple method of sorting the strings and comparing if they are the same using equals
    public static boolean isPermutationStr2(String input1, String input2)
    {
        if(input1.length() != input2.length()) return false;

        if(sort(input1).equals(sort(input2))) return true;

        return false;
    }

    //Method to replace all spaces in a string with "%20"
    public static String getURLifyStr(String input)
    {
        int inputLen = input.length();
        int spaceCount=0, index;
        for(int i=0; i<inputLen; i++)
        {
            if(input.charAt(i) == ' ') spaceCount++;
        }

        index=inputLen+(spaceCount*3);
        //System.out.println("index = "+index);
        char[] inputCharArr = new char[index+2];
        inputCharArr[index+1] = '\0'; //Marking end of string in array

        for(int i=inputLen-1; i>=0; i--)
        {
            if(input.charAt(i) == ' ')
            {
                inputCharArr[index--] = '0';
                inputCharArr[index--] = '2';
                inputCharArr[index--] = '%';
            }
            else
            {
                inputCharArr[index--] = input.charAt(i);
            }
        }

        return new String(inputCharArr);
    }
    
    public static boolean isPermutationOfPalindrome(String input)
    {
        int inputLen = input.length();
        int[] charCountTable = new int[256];
        boolean foundOdd = false;
        int countOdd = 0;

        for(int i=0; i<inputLen; i++)
        {
            charCountTable[input.charAt(i)]++;
            if(charCountTable[input.charAt(i)]%2 == 1)
            {
                countOdd++;
            }
            else
            {
                countOdd--;
            }
        }
        return countOdd <= 1;
//Alternate way 1: Build char table first and then iterate through the input to see if odd is found second time.

//        for (int i=0; i < inputLen; i++)
//        {
//            if(charCountTable[input.charAt(i)]%2 == 1)
//            {
//                System.out.println("zz " + charCountTable[input.charAt(i)] + ", " + input.charAt(i));
//                if(foundOdd) return false;
//                foundOdd = true;
//            }
//        }
//        return true;
//        for(int i=0; i<256; i++)
//        {
//            if(charCountTable[i]%2 == 1)
//            {
//                System.out.print(charCountTable[i] + "," + (char)i);
//                if(foundOdd) return false;
//                foundOdd = true;
//            }
//        }
        //return true;
    }

    public static boolean StringContains(String str1, String str2)
    {
        int lenS1 = str1.length();
        int lens2 = str2.length();

        int j=0;

        for(int i=0; i<lenS1&j<lens2; i++)
        {
            if(str1.charAt(i) == str2.charAt(j))
                j++;
            else
                j=0;
        }

        return (j == lens2);
    }

    public static int lengthOfLongestSubstring(String input)
    {
        int l1 = input.length();
        int outLen = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0, j=0; i<l1; i++)
        {
            char currentChar = input.charAt(i);

            //if(currentChar == ' ') continue;

            if(currentChar != ' ' && map.containsKey(currentChar))
            {
                 j= Math.max(map.get(currentChar), j);
            }

            outLen = Math.max(outLen, i-j+1);
            map.put(currentChar, i+1);
        }

        return outLen;
    }

    public static void permuteAndPrint(String input)
    {
        boolean[] used = new boolean[input.length()];
        StringBuilder out = new StringBuilder();

        permute(used, out, input);
    }

    public static void permute(boolean[] used, StringBuilder out, String input)
    {
        int inlen = input.length();
        if(out.length() == inlen)
        {
            System.out.print(out.toString() + "  ");
            return;
        }

        for(int i=0; i<inlen; i++)
        {
            if(used[i]) continue;
            out.append(input.charAt(i));
            used[i] = true;
            permute(used, out, input);
            used[i] = false;
            out.setLength(out.length()-1);
        }
    }

    public static void main(String[] args) {
        if (isUniqueChar("ABCD EFGH IJKL")) {
            System.out.println("String contains unique characters");
        } else {
            System.out.println("String doesn not contain unique characters");
        }

        if (isPermutationStr2("Gokila", "kilaGo")) {
            System.out.println("Strings are permutations of each other");
        } else {
            System.out.println("Strings are not permutations of each other");
        }

        System.out.println(getURLifyStr("Hello World"));

        if(isPermutationOfPalindrome("catach"))
        {
            System.out.println("Yes. It is Permutation of a Palindrome");
        }
        else
        {
            System.out.println("No. It is not a Permutation of a Palindrome");
        }

        if(StringContains("God is Great!", "Git"))
        {
            System.out.println("String contains: True");
        }

        System.out.println( lengthOfLongestSubstring("ab aaba"));

        permuteAndPrint("abcd");
    }

}
