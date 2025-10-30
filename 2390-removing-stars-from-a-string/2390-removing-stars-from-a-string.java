class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '*')
                stack.pop();
            else
                stack.push(c);
        }

        int n = stack.size();
        char[] chArr = new char[n];
        for (int i = n - 1; i >= 0; i--) {
            chArr[i] = stack.pop();
        }

        return new String(chArr);
    }
    // time complexity O(n)
    // space complexity O(n)
}