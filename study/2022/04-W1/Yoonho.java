import java.util.Arrays;

import static java.util.Arrays.sort;

public class Coding {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Coding().solution(new int[]{-1, -2, -3, -4, -5}, -8)));
    }

    public int[] solution(int[] nums, int target) {

        int[] orig = nums.clone();
        Arrays.sort(nums);
        int first = 0;
        int last = nums.length - 1;

        while (first != last) {
            if (nums[first] + nums[last] != target) {
                if (nums[first] + nums[last] > target) last--;
                else if(nums[first] + nums[last] < target) first++;
            } else break;
        }

        for(int i = 0 ; i < orig.length ; i++){
            if(orig[i] == nums[first]) {
                first = i;
                break;
            }
        }
        for(int i = orig.length - 1; 0 <= i ; i--){
            if(orig[i] == nums[last]) {
                last = i;
                break;
            }
        }
        return new int[]{first, last};
    }
}
