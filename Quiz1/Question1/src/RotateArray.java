public class RotateArray {
    public static void rotateArray(int[] nums, int k) {
        int[] tempNums = new int[nums.length];

        for(int i =0;  i<nums.length;i++){
            tempNums[(i+k)%nums.length]=nums[i];
        }
        for(int i = 0; i<nums.length;i++){
            nums[i]=tempNums[i];
        }
    }
}
