https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
import java.util.Scanner;

public class Abhi {


    static int[] getRecord(int[] s){
        int countS=0;
        int countG=0;
        int num=s[0];
        for(int i=0;i<s.length;i++)
        {
           if (s[i]>num)
           {
               num=s[i];
               countG++;
           }
           else if(s[i]<num)
            {
                num=s[i];
                countS++;
            }
        }
        
        return ;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int[] result = getRecord(s);
        String separator = "", delimiter = " ";
        for (Integer val : result) {
            System.out.print(separator + val);
            separator = delimiter;
        }
        System.out.println("");
    }
}

