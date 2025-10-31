class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        StringBuilder current = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(num);
                stringStack.push(current);

                current = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                int repeatCount = countStack.pop();
                StringBuilder temp = stringStack.pop();

                for (int i = 0; i < repeatCount; i++) {
                    temp.append(current);
                }
                current = temp;
            } else {
                current.append(c);
            }
        }

        return current.toString();
    }
    // time complexity O(n^2)
    // space complexity O(n)
}