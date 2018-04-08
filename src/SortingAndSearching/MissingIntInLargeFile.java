package SortingAndSearching;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Goki_PC on 2/21/2018.
 */
public class MissingIntInLargeFile {

    private long numberOfInts = ((long) Integer.MAX_VALUE) + 1;

    private byte[] bitfield = new byte[(int) (numberOfInts / 8)];

    private String fileName = "";

    void findOpenNumber() throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader(fileName));
        while (in.hasNextInt()) {
            int n = in.nextInt();

        }

    }
}
