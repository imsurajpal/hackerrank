https://www.hackerrank.com/challenges/kangaroo/problem
import java.util.Scanner;

public class Abhi {

    static int kan1;
    static int kan2;
    static int kan3;
    static String res="";
    static String kangaroo(int x1, int v1, int x2, int v2) {
        kan1=x1+v1;
        kan2=x2+v2;
        kan3=x2-x1;
        while ((kan2-kan1)<kan3){
       // while (kan1!=kan2) {
            if (kan1 == kan2) {
                res="Yes";
            }
            else if (kan1 != kan2)
            {
                kan1 += v1;
                kan2 += v2;
            }
            else
                res="no";
        }
    return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }
}

