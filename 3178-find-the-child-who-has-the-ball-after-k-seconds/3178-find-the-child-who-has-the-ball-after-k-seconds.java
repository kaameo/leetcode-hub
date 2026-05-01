class Solution {
    public int numberOfChild(int n, int k) {
        int length = n - 1;

        int round = k / length;
        int remain = k % length;
        if (round % 2 == 0) {
            return remain;
        } else {
            return length - remain;
        }
    }
}
// k/n-1 == 2, 홀수면 리버스
// k/n-1 == 0 은 가는중
// 3/4 == 0 은 가는중
// 3% 4 == 1

// 6/4 == 1 리버스
// 6% 4 == 2

// 2/3 == 0 가는중
// 2% 3 == 2

// 0 = [0!,1,2,3,4]
// 1 = [0,1!,2,3,4]
// 2 = [0,1,2!,3,4]
// 3 = [0,1,2,3!,4]
// 4 = [0,1,2,3,4!]
