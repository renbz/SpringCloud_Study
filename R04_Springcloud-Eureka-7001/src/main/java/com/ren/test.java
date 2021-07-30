package com.ren;

/**
 * @author Ren
 */

public class test {
    public static void main(String[] args) {
        String str = "11,22,33,44,55,66,77,88,99";
        String [] strArr = str.split(",");
        for (String s : strArr) {
            System.out.println(s);
        }
    }

}
