package Wang.Ti;

import java.util.Arrays;
import java.util.HashSet;

public class RandomNum {


    //求最大值
    public static int max(int[] array){
        int m = array[0];
        for (int i = 1; i < array.length; i++){
            if (array[i] > m){
                m = array[i];
            }
        }

        return m;
    }

    //消除重复值
    public static int[] eliminateDuplicate(int[] lst){
        HashSet<Integer> integers = new HashSet<>();

        int len = lst.length;

        for (int i = 0; i < len; i++){
            integers.add(lst[i]);
        }

        int k = 0;
        int[] a = new int[len];
        for (int i = 0; i < integers.size(); i++){
            a[k++] = (int) integers.toArray()[i];
        }

        return Arrays.copyOfRange(a,0, k);
    }



    public static void main(String[] args){

        System.out.println(123);

    }





    
}
