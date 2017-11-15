https://www.hackerrank.com/challenges/apple-and-orange/problem
import java.util.Scanner;

public class AbhiNew {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for(int apple_i=0; apple_i < m; apple_i++){
            apple[apple_i] = in.nextInt();
            if((a+m)>=s && (a+m)<=t){
                System.out.println(1);
            }

        }
        int[] orange = new int[n];
        for(int orange_i=0; orange_i < n; orange_i++){
            orange[orange_i] = in.nextInt();
            if((b+n)>=s && (b+n)<=t){
                System.out.println(1);
            }

        }
    }

}

