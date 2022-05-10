package Wang.Ti;


import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class test01Test {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int len1 = nums1.length;
        int len2 = nums2.length;

        for (int i = 0; i < len1; i++){
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        int[] ans = new int[len1];
        int k = 0;
        for (int i = 0; i < len2; i++){
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
                map.put(nums2[i], map.get(nums2[i]) - 1);
                ans[k++] = nums2[i];
            }
        }

        return Arrays.copyOfRange(ans, 0, k);
    }

    @Test
    public void chang(){
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        int[] a = intersect(nums1, nums2);

        for (int i = 0; i < a.length; i++){
            System.out.print(a[i]+ " ");
        }


    }

}