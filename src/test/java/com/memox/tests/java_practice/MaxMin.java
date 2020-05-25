package com.memox.tests.java_practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxMin {


    public static String highAndLow(String numbers){

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        String nums[] = numbers.split(" ");

        for(String s: nums) {
            int num = Integer.parseInt(s);

            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        return "" + max + " " + min;

    }



    public static String highAndLow2(String numbers) {
        String[] array = numbers.split(" ");
        List<Integer> nums = new ArrayList<>();

        for(String i : array){
            nums.add(Integer.parseInt(i));
        }

        return Collections.max(nums) + " " + Collections.min(nums);
    }



    public static String highAndLow3(String numbers) {
        String [] strs = numbers.split(" ");
        Integer [] ints = new Integer[strs.length];

        for (int i = 0; i < strs.length; i++) {
            ints[i] = Integer.parseInt(strs[i]);
        }

        Integer max = ints[0];
        Integer min = ints[0];

        for (int i = 0; i < ints.length; i++) {
            if(max < ints[i])
                max = ints[i];
            if(min > ints[i])
                min = ints[i];
        }

        return max.toString() + " " + min.toString();
    }






    @Test
    public void maxMinTest(){

        String str = highAndLow3("1 2 3 4 5");

        Assert.assertEquals("5 1",str);
    }
}
