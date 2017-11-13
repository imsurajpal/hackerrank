//https://www.hackerrank.com/challenges/day-of-the-programmer/problem

import java.util.Scanner;

public class Abhi {


    static String solve(int year){
        if( year == 1918 ) return "26.09.1918";
        if( isLeap( year ) ) return "12.09." + Integer.toString( year );
        else return "13.09." + Integer.toString( year );

    }

    static boolean isLeap( int year ) {

        if( year % 4 != 0 ) return false;
        if( year > 1918 && year % 100 == 0 && year % 400 != 0 ) return false;
        return true;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        String result = solve(year);
        System.out.println(result);
    }
}

