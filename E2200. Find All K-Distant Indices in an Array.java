class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        // Find indices of target value in nums array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                list.add(i);
            }
        }
        // Find indices within distance k from each index of target value
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < nums.length; j++) {
                if (Math.abs(list.get(i) - j) <= k) res.add(j);
            }
        }
        // Sort and filter out duplicates from results list
        Collections.sort(res);
        List<Integer> filteredList = res.stream().distinct().collect(Collectors.toList());
        return filteredList;
    }
}
