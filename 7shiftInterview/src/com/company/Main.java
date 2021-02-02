// code by: Matthew Gurski

package com.company;


import java.io.*;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) throws IOException {
        //Tests
        int Test1 = Add("1,2,5");
        if(Test1 != 8){
            System.out.println("Test2 failed, result was not equal to expected value of 0! got: " + Test1);
        }
        int Test2 = Add("");
        if(Test2 != 0){
            System.out.println("Test2 failed, result was not equal to expected value of 0! got: " + Test2);
        }
        int Test3 = Add("12");
        if(Test3 != 12){
            System.out.println("Test3 failed, result was not equal to expected value of 12! got: " + Test3);
        }
        int Test4 = Add("1,1,1,1,1");
        if(Test4 != 5){
            System.out.println("Test4 failed, result was not equal to expected value of 5! got: " + Test4);
        }
        int Test5 = Add("10,10,10,10,10");
        if(Test5 != 50){
            System.out.println("Test5 failed, result was not equal to expected value of 50! got: " + Test5);
        }
        int Test6 = Add("100,100,100,100,100");
        if(Test6 != 500){
            System.out.println("Test6 failed, result was not equal to expected value of 500! got: " + Test6);
        }
        int Test7 = Add("1\n,2,3");
        if(Test7 != 6){
            System.out.println("Test7 failed, result was not equal to expected value of 6! got: " + Test7);
        }
        int Test8 = Add("1,\n2,4");
        if(Test8 != 7){
            System.out.println("Test8 failed, result was not equal to expected value of 7! got: " + Test8);
        }
        int Test9 = Add("//;\n1;3;4");
        if(Test9 != 8){
            System.out.println("Test9 failed, result was not equal to expected value of 8! got: " + Test9);
        }
        int Test10 = Add("//$\n1$2$3");
        if(Test10 != 6){
            System.out.println("Test10 failed, result was not equal to expected value of 6! got: " + Test10);
        }
        int Test11 = Add("//@\n2@3@8");
        if(Test11 != 13){
            System.out.println("Test11 failed, result was not equal to expected value of 13! got: " + Test11);
        }
        int Test12 = Add("2,-5,7");
        if(Test12 != 1){
            System.out.println("Test12 failed, test should have resulted in negative input error!");
        }
        int Test13 = Add("//@\n2@3@-8");
        if(Test13 != 1){
            System.out.println("Test13 failed, test should have resulted in negative input error!");
        }
        int Test14 = Add("5,1005,5");
        if(Test14 != 10){
            System.out.println("Test14 failed, result was not equal to expected value of 10! got: " + Test14);
        }


    }

    // Add method
    // Uses a StringTokenizer to iterate through input using ',' as a delimiter
    // returns sum of string of ints
    public static int Add(String input){
        int sum = 0;

        // null input case
        if(input.isEmpty()){
            return sum;
        }

        Pattern delimiters = Pattern.compile("[\n,]");          // Create a pattern for the delimiters

        // custom delimiter check
        if(input.startsWith("//")){
            String del = String.valueOf(input.charAt(2));       // set char at index 2 to delimiter
            delimiters = Pattern.compile("[\n," + del + "]");   // append custom del to pattern
            input = input.substring(2);                         // create substring, excluding custom del control
        }

        String[] arr = input.split(delimiters.pattern());       //split the input given the delimiters
        for(String s : arr){
            if(!s.isEmpty()){
                int cur = Integer.parseInt(s);                  //convert input to int
                if(cur < 0){
                    System.err.println("exception: Negatives not allowed, incorrect input: "+ cur);
                    return 1;
                }
                if(cur > 1000){}                                // if number bigger than 1000, ignore (do nothing)
                else {
                    sum += cur;
                }

            }
        }
        return sum;
    }
}
