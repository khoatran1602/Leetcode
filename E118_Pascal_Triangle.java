class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> subList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            subList.add(0, 1);
            for (int j = 1; j < subList.size() - 1; j++) {
                subList.set(j, subList.get(j) + subList.get(j+1));
            }
            list.add(new ArrayList<>(subList));
        }
        return list;
    }
}
