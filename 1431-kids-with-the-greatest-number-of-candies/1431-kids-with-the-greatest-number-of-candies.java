class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // get greatest number of candies
        int gnc = getGrNum(candies);
        // for (candies list)
        ArrayList<Boolean> answer = new ArrayList<>();
        for(int i = 0; i < candies.length; i++){
            // if(extraCandies + candies[i] > gnc) list.add(true) | list.add(false)
            if(candies[i] + extraCandies >= gnc){
                answer.add(true);
            }else{
                answer.add(false);
            }
        }
        return answer;
    }
    private int getGrNum(int[] arr){
        int max = -1;
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
    // time complexity O(n)
    // space complexity O(n)
}