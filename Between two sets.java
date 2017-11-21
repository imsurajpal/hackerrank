https://www.hackerrank.com/challenges/between-two-sets/problem
import java.util.Scanner;

public class AbhiNew {


    static int getTotalX(int[] a, int[] b) {
        int num=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]%a[i]==0 && b[i]%a[i]==0)
            {
                num++;
            }
        }
        for(int i=0;i<b.length;i++)
        {
            if(b[i]%a[i]==0 && b[i]%b[i]==0)
            {
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for (int b_i = 0; b_i < m; b_i++) {
            b[b_i] = in.nextInt();
        }
        int total = getTotalX(a, b);
        System.out.println(total);
        in.close();
    }



}

//for(int i=0;i<a.length;i++)
//        {
//        if(num%a[i]==0&&b[i]%num==0)
//        {
//        num++;
//        }
//        }
//        return num;




