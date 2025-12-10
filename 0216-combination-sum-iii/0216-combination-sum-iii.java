class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        // if there is k numbers [a, b, c, ...]
        // sum of numbers equals a number n
        // so k[0] + k[1] + k[2] + ... = n
        // and also  1 <= k[i] <= 9
        
        List<List<Integer>> result = new ArrayList<>();

        Deque<Integer> stack = new ArrayDeque<>();

        int current = 1;
        int sum = 0;

        while (true) {
            while (current <= 9 && stack.size() < k && sum + current <= n) {
                stack.push(current);
                sum += current;
                current++;
            }

            if (stack.size() == k && sum == n) {
                result.add(new ArrayList<>(stack));
            }

            if (stack.isEmpty())
                break;

            int removed = stack.pop();
            sum -= removed;

            current = removed + 1;
        }

        return result;
    }
}