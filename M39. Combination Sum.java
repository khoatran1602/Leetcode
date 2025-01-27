class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] arr, int sum) {
        Arrays.sort(arr);
        helper(arr, sum, 0, new ArrayList<>());
        return ans;
    }

    public void helper(int[] arr, int sum, int index, List<Integer> temp) {
        if (index == arr.length) {
            return;
        }

        if (arr[index] == sum) {
            ArrayList<Integer> temp2 = new ArrayList<>(temp);
            temp2.add(arr[index]);
            ans.add(temp2);
            return;
        }
        if (arr[index] > sum) {
            return;
        }

        helper(arr, sum, index + 1, temp);

        ArrayList<Integer> temp2 = new ArrayList<>(temp);
        temp2.add(arr[index]);
        helper(arr, sum - arr[index], index, temp2);
    }
}
