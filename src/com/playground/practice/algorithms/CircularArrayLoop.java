package com.playground.practice.algorithms;

/**
 *
 * You are given a circular array nums of positive and negative integers. If a number k at an index is positive, then move forward k steps. Conversely, if it's negative (-k), move backward k steps. Since the array is circular, you may assume that the last element's next element is the first element, and the first element's previous element is the last element.
 *
 * Determine if there is a loop (or a cycle) in nums. A cycle must start and end at the same index and the cycle's length > 1. Furthermore, movements in a cycle must all follow a single direction. In other words, a cycle must not consist of both forward and backward movements.
 *
 *
 *
 * Example 1:
 *
 * Input: [2,-1,1,2,2]
 * Output: true
 * Explanation: There is a cycle, from index 0 -> 2 -> 3 -> 0. The cycle's length is 3.
 * Example 2:
 *
 * Input: [-1,2]
 * Output: false
 * Explanation: The movement from index 1 -> 1 -> 1 ... is not a cycle, because the cycle's length is 1. By definition the cycle's length must be greater than 1.
 * Example 3:
 *
 * Input: [-2,1,-1,-2,-2]
 * Output: false
 * Explanation: The movement from index 1 -> 2 -> 1 -> ... is not a cycle, because movement from index 1 -> 2 is a forward movement, but movement from index 2 -> 1 is a backward movement. All movements in a cycle must follow a single direction.
 *
 *
 * Note:
 *
 * -1000 ≤ nums[i] ≤ 1000
 * nums[i] ≠ 0
 * 1 ≤ nums.length ≤ 5000
 *
 *
 * Follow up:
 *
 * Could you solve it in O(n) time complexity and O(1) extra space complexity?
 *
 */
public class CircularArrayLoop {

    public static final String PASS = "Pass";
    public static final String FAILED = "Failed";

    public static boolean circularArrayLoop(int[] nums) {

        int n = nums.length;

        for(int i=0; i<n; i++) {
            int slow = ((i+nums[i])%n+n)%n;
            int fast = ((slow+nums[slow])%n+n)%n;

            int direction = 1;
            if(nums[i] < 0) direction = -1;

            while(fast != slow) {
                slow=((slow+nums[slow])%n+n)%n;
                fast=((fast+nums[fast])%n+n)%n;
                fast=((fast+nums[fast])%n+n)%n;

//                if(fast == slow && slow == i) return true;

//                boolean forward_backward=nums[slow]>0;//forward or backword
//                int ptr=((slow+nums[slow])%n+n)%n;
//                while(ptr!=slow){
//                    if(nums[ptr]>0!=forward_backward) return false;
//                    ptr=((ptr+nums[ptr])%n+n)%n;
//                }
                if(nums[fast] * direction < 0 || nums[slow] * direction < 0) break;
            }

            if(slow==((slow+nums[slow])%n+n)%n) return false;//one element loop


            return true;
        }

        return false;
    }

    public static boolean circularArrayLoop1(int[] nums) {
        if(nums==null||nums.length==0) return false;
        for(int a:nums){
            if(a==0) return false;
        }
        int len=nums.length;
        for(int i=0;i<len;i++){
            if(checkCycle(nums,i)) return true;
        }
        return false;
    }

    public static boolean checkCycle(int[] nums, int start){
        int len=nums.length;
        int slow=((start+nums[start])%len+len)%len;
        int fast=((slow+nums[slow])%len+len)%len;
        while(slow!=fast){
            slow=((slow+nums[slow])%len+len)%len;
            fast=((fast+nums[fast])%len+len)%len;
            fast=((fast+nums[fast])%len+len)%len;
        }
        if(slow==((slow+nums[slow])%len+len)%len) return false;//one element loop
        boolean forward_backward=nums[slow]>0;//forward or backword
        int ptr=((slow+nums[slow])%len+len)%len;
        while(ptr!=slow){
            if(nums[ptr]>0!=forward_backward) return false;
            ptr=((ptr+nums[ptr])%len+len)%len;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(circularArrayLoop(new int[]{2, -1, 1, 2, 2}) == true ? PASS : FAILED);
        System.out.println(circularArrayLoop(new int[]{1,1,1,2}) == true ? PASS : FAILED);
        System.out.println(circularArrayLoop(new int[]{1,1,-1,2}) == false ? PASS : FAILED);
        System.out.println(circularArrayLoop(new int[]{-2,1,-1,-2,-2}) == false ? PASS : FAILED);
        System.out.println(circularArrayLoop(new int[]{-8,-1,1,7,2}) == false ? PASS : FAILED);
        System.out.println(circularArrayLoop(new int[]{1,1}) == true ? PASS : FAILED);
        System.out.println(circularArrayLoop(new int[]{1,2}) == false ? PASS : FAILED);
        System.out.println(circularArrayLoop(new int[]{2,1}) == false ? PASS : FAILED);
        System.out.println(circularArrayLoop(new int[]{2}) == false ? PASS : FAILED);
        System.out.println(circularArrayLoop(new int[]{1}) == false ? PASS : FAILED);
        System.out.println(circularArrayLoop(new int[]{3,1,2}) == true ? PASS : FAILED);
        System.out.println(circularArrayLoop(new int[]{-2,3,-1,-2,2}) == true ? PASS : FAILED);
        System.out.println(circularArrayLoop(new int[]{2,2,2,2,2,4,7}) == false ? PASS : FAILED);
    }
}
