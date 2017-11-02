package StringsAndArrays;

/**
 * Created by Goki_PC on 10/25/2017.
 */
public class MatrixManipulations {

    public void rotate90Degrees(int[][] input)
    {
        int n = input.length;
        int layer = n/2;

        for(int i=0; i<layer; i++)
        {
            for(int j=i; j<n-1-i; j++)
            {
                int temp = input[i][j];

                input[i][j] = input[j][n-layer];

                //input[j][n-layer] = input[n-layer][]

            }
        }


    }


    public static void main(String[] args)
    {

    }
}
