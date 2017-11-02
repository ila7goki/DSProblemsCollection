package StacksAndQueues;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by Goki_PC on 5/3/2017.
 */
public class DijkstraTwoStack {

    public static void main(String[] args)
    {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("End");
        while(sc.hasNext())
        {
            String s = sc.next();

            if(s.equals("(")) continue;
            else if(s.equals("+") || s.equals("*") || s.equals("-") || s.equals("/"))
                ops.push(s);
            else if(s.equals(")"))
            {
                String op = ops.pop();
                double val1 = vals.pop();
                double val2 = vals.pop();
                System.out.print(op);
                if(op.equals("+")) { System.out.print(val1 + val2); vals.push(val1 + val2);}
                else if (op.equals("*")) { vals.push(val1 * val2);}
                else if (op.equals("-")) { vals.push(val1 - val2);}
                else if (op.equals("/")) { vals.push(val1 / val2);}
            }
            else {vals.push(Double.parseDouble(s));}
        }
        System.out.println("End");
    }

}
