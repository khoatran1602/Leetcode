class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subRes = new ArrayList<>();
        int sum = 0;
        findCombo(candidates, target, 0, sum, subRes, res);
        return res;
    }

    public void findCombo(int[] candidates, int target, int index, int sum, List<Integer> subRes, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(subRes));
            return;
        }
        if (index >= candidates.length) return;
        if (sum > target) return;
        sum = sum + candidates[index];
        subRes.add(candidates[index]);
        findCombo(candidates, target, index + 1, sum, subRes, res);
        sum = sum - candidates[index];
        subRes.remove(subRes.size() - 1);
        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) index++;
        findCombo(candidates, target, index + 1, sum, subRes, res);
    }
}
