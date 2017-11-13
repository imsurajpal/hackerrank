//https://www.hackerrank.com/challenges/day-of-the-programmer/problem

import java.util.Scanner;

public class AbhiNew {


        public static String solve(int num,int year ) {
            int i=0;

            int[] mon = new int[12];
            mon[0] = 31;
            mon[1] = 28;
            mon[2] = 31;
            mon[3] = 30;
            mon[4] = 31;
            mon[5] = 30;
            mon[6] = 31;
            mon[7] = 31;
            mon[8] = 30;
            mon[9] = 31;
            mon[10] = 30;
            mon[11] = 31;

            String ans="";

            for ( i = 0; i < 12; i++){
                if (num > mon[i]) {

                    if ((i==1) && (isLeap( year))){
                        num=num-1;
                    }


                    num = num - mon[i];
                } else {
                    ans = num + "." +( i+1)+"."+year;
                    break;
                }
        }
        return ans;

        }
//            if (num<31)  return (num+".01.2017");
//            else if (num > 31 && num <= 59)
//               return ((num - 31)+".02.2017");
//             else if (num > 59 && num <= 90)
//                return (num - 59)+".03.2017";
//             else if (num > 90 && num <= 120)
//                return (num - 90)+".04.2017";
//             else if (num > 120 && num <= 151)
//                return (num - 120)+".05.2017";
//             else if (num > 151 && num <= 181)
//                return (num - 151)+".06.2017";
//             else if (num > 181 && num <= 212)
//                return (num - 181)+".07.2017";
//             else return "09.08.2017";
//
//

    static boolean isLeap( int year ) {

        if( year % 4 != 0 ) return false;
        if( year > 1918 && year % 100 == 0 && year % 400 != 0 ) return false;
        return true;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        int num = in.nextInt();
         String result = solve(num,year);
        System.out.println(result);
    }
}

