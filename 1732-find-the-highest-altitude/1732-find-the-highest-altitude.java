class Solution {
    public int largestAltitude(int[] gain) {
        int maxAltitude = 0; // because it starts at 0
        int alt = 0;
        for(int g : gain){
            alt += g;
            maxAltitude = Math.max(maxAltitude, alt);
        }
        return maxAltitude;
    }
}