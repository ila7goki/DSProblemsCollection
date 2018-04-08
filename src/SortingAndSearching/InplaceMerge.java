package SortingAndSearching;

/**
 * Created by Goki_PC on 2/19/2018.
 */
public class InplaceMerge {

    public static void main(String[] args) {
        InplaceMerge inplaceMerge = new InplaceMerge();
        int a[] = {10, 12, 13, 14, 18, -3, -3, -3, -3, -3};
        int n = 5;
        int b[] = {16, 17, 19, 20, 22};
        int m = 5;
        inplaceMerge.mergeWithInplaceArray(a, b, n, m);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }

    private void mergeWithInplaceArray(int[] a, int[] b, int aLen, int bLen) {
        int lastIdxOfA = aLen - 1;
        int lastIdxOfB = bLen - 1;
        int mergedLastIdx = aLen + bLen - 1;

        while (lastIdxOfB >= 0) {
            if (lastIdxOfA >= 0 && a[lastIdxOfA] > b[lastIdxOfB]) {
                a[mergedLastIdx] = a[lastIdxOfA];
                lastIdxOfA--;
            } else {
                a[mergedLastIdx] = b[lastIdxOfB];
                lastIdxOfB--;
            }
            mergedLastIdx--;
        }
    }
}
