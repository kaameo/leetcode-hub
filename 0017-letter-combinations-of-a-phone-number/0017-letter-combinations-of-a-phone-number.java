class Solution {
    private static final String[] map = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return answer;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer("");

        for (char digit : digits.toCharArray()) {
            int idx = digit - '0';
            String letters = map[idx];

            int size = queue.size();
            while (size-- > 0) {
                String prev = queue.poll();
                for (char ch : letters.toCharArray()) {
                    queue.offer(prev + ch);
                }
            }
        }

        answer.addAll(queue);
        return answer;
    }
    // time complexity O(k^n)
    // space complexity O(n * k^n)
}