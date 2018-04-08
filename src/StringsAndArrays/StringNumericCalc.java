package StringsAndArrays;

/**
 * Created by Goki_PC on 4/7/2018.
 */
public class StringNumericCalc {

    private static String addBinary(String a, String b) {
        int a_len = a.length() - 1;
        int b_len = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int len = Math.max(a_len, b_len);
        int carry = 0;

        while (a_len >= 0 || b_len >= 0) {
            int a_val = a_len >= 0 ? a.charAt(a_len--) - '0' : 0;
            int b_val = b_len >= 0 ? b.charAt(b_len--) - '0' : 0;

            int sum = (a_val + b_val + carry);
            carry = sum > 1 ? 1 : 0;
            System.out.println(", " + b_val + ", " + a_val + ", " + sum % 2 + ", " + carry);
            sb.append(sum % 2);
        }

        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        System.out.println(addBinary("11", ""));

    }
}
