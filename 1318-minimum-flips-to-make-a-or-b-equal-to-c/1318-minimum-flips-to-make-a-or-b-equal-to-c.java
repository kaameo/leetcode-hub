class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;

        while (a > 0 || b > 0 || c > 0) {
            int bitA = a & 1;
            int bitB = b & 1;
            int bitC = c & 1;

            if (bitC == 1) {
                if (bitA == 0 && bitB == 0) {
                    count++;
                }
            } else {
                if (bitA == 1 && bitB == 1) {
                    count += 2;
                } else if (bitA == 1 || bitB == 1) {
                    count++;
                }
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return count;
    }
}
// a, b, c <= 1,000,000,000

// 0010     0001 a
// 0110 ->  0100 b
// 0101     0101 c
// res: 3

// 0100     0101 a
// 0010 ->  0010 b
// 0111     0111 c
// res: 1

// 0001     0001 a
// 0010 ->  0010 b
// 0011     0011 c
// res: 0