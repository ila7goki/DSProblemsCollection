package StringsAndArrays;

/**
 * Created by Goki_PC on 10/25/2017.
 */
public class MatrixManipulations {

    public static void rotate90DegreesClockwise(int[][] input)
    {
        int n = input.length;
        int layer = n/2;

        for(int i=0; i<layer; i++)
        {
            for(int j=i; j<n-1-i; j++)
            {
                int temp = input[i][j];

                input[i][j] = input[n-1-j][i];
                input[n-1-j][i] = input[n-1-i][n-1-j];
                input[n-1-i][n-1-j] = input[j][n-1-i];
                input[j][n-1-i] = temp;
            }
        }
    }

    static void displayMatrix(int mat[][])
    {
        for (int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j < mat.length; j++)
                System.out.print(" " + mat[i][j]);

            System.out.print("\n");
        }
        System.out.print("\n");
    }


    public static void main(String[] args)
    {
        int mat[][] =
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
                };

        rotate90DegreesClockwise(mat);
        displayMatrix(mat);
    }
}
