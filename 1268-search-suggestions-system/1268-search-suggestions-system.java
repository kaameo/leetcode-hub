class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        List<List<String>> result = new ArrayList<>();
        String prefix = "";

        for (int i = 0; i < searchWord.length(); i++) {
            prefix += searchWord.charAt(i);

            List<String> list = new ArrayList<>();

            for (String product : products) {
                if (product.startsWith(prefix)) {
                    list.add(product);
                    if (list.size() == 3) {
                        break;
                    }
                }
            }

            result.add(list);
        }

        return result;
    }
}