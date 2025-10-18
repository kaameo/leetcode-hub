class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0){
            return true;
        }
        int[] paddedFlowerbed = padZerosBothEnds(flowerbed);
        boolean canPlant = false;
        for (int i = 1; i < paddedFlowerbed.length - 1; i++) {
            if(paddedFlowerbed[i-1] == 0 && paddedFlowerbed[i + 1] == 0 && paddedFlowerbed[i] == 0){
                paddedFlowerbed[i] = 1;
                n--;
            }
            if(n == 0){
                canPlant = true;
                break;
            }
        }
        
        return canPlant;
    }

    static int[] padZerosBothEnds(int[] arr) {
        int[] res = new int[arr.length + 2]; // 기본값은 0으로 초기화됨
        for (int i = 0; i < arr.length; i++) {
            res[i + 1] = arr[i];
        }
        return res;
    }
    // time complexity O(n)
    // space complexity O(n)
}