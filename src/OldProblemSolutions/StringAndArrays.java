package OldProblemSolutions;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Goki_PC on 3/4/2017.
 */
public class StringAndArrays {

    //Reverses the given string arr from start position to end position of the string arr in place
    private static void reverse(char[] str, int start, int end)
    {
        while(start <= end)
        {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++; end--;
        }
    }

    //Reverse the sentence with words staying as it is.
    public static char[] reverseWordsInString(String line)
    {
        char[] charArr = line.toCharArray();
        int lineLength = charArr.length;
        reverse(charArr, 0, lineLength-1);
        //System.out.println(charArr);
        int wordStart = 0, wordEnd = 0;
        while(wordEnd < lineLength)
        {
            if(charArr[wordEnd] != ' ')
            {
                wordStart = wordEnd;
                while(wordEnd < lineLength && charArr[wordEnd] != ' ')
                {
                    wordEnd++;
                }
                wordEnd--;
                System.out.println(wordStart + " " + wordEnd);
                reverse(charArr, wordStart, wordEnd);
            }
            wordEnd++;
        }
        return charArr;
    }

    //Remove all the characters from remove string which are present in the source string
    public static String removeChars(String str, String remove)
    {
        char[] removeChr = remove.toCharArray();
        char[] strChr = str.toCharArray();
        boolean[] flags = new boolean[128];
        int src = 0, dst = 0;
        for (int i=0; i < removeChr.length; ++i)
        {
            flags[removeChr[i]] = true;
            System.out.println(flags['i']);
        }

        for (src =0; src < strChr.length; ++src)
        {
            if (!flags[strChr[src]])
            {
                strChr[dst++] = strChr[src];
            }
        }
        return new String(strChr, 0, dst);
    }

    //Find the first non repeated characted in the given string
    public static Character firstNonRepeated(String str)
    {
        HashMap<Character, Integer> charHash = new HashMap<Character, Integer>();
        Character c;
        int length = str.length();
        for(int i = 0; i < length; i++)
        {
            c = str.charAt(i);
            if (charHash.containsKey(c))
            {
                charHash.put(c, charHash.get(c)+1);
            }
            else
            {
                charHash.put(c, 1);
            }
        }

        for (int i = 0; i < length; i++)
        {
            c = str.charAt(i);
            System.out.println(c+ ", " +charHash.get(c));
            if(charHash.get(c) == 1)
            {
                return c;
            }
        }

        return null;
    }

    public static boolean isUniqueCharacters(String str)
    {
        boolean[] flagChars = new boolean[256];
        for (int i=0; i < str.length(); i++)
        {
            if(flagChars[str.charAt(i)])
            {
                return false;
            }
            flagChars[str.charAt(i)] = true;

        }
        return true;
    }

    //Remove duplicates without using addidtion memory
    //Writes first letter to itself and compares each character from the string to the already writtern string without duplicates keeping track of index of the written char in the string
    public static String removeDuplicates(char[] str)
    {
        if(str == null) return null;

        int len = str.length;
        if(len < 2)
            return str.toString();

        int dstIdx = 1;
        for (int i = 1; i < len; ++i)
        {
            int j;
            for (j = 0; j < dstIdx; ++j)
            {
                if(str[i] == str[j])
                    break;
            }
            if(j == dstIdx)
            {
                str[dstIdx] = str[i];
                ++ dstIdx;
            }
        }
        return new String(str, 0, dstIdx);
    }



    public static void main(String[] args)
    {
        //System.out.println(reverseWordsInString("Do or do not, there is no try."));
        //System.out.println(removeChars("problem solving", "aeiou"));
        //System.out.println(firstNonRepeated("BetterButter"));
        //System.out.println(isUniqueCharacters("Coding Challenge"));
        System.out.println(removeDuplicates("abababcdcde".toCharArray()));

    }
}
