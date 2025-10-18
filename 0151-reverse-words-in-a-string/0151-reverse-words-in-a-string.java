import java.util.*;

class Solution {
    public String reverseWords(String s) {
        StringTokenizer st = new StringTokenizer(s);
        List<String> strList = new ArrayList<>();
        while (st.hasMoreTokens()) {
            strList.add(st.nextToken());
        }
        Collections.reverse(strList);

        StringBuilder sb = new StringBuilder();
        for (String str : strList) {
            sb.append(str).append(" ");
        }
        return sb.toString().trim();
    }
    // time complexity O(n)
    // space complexity O(n)
}