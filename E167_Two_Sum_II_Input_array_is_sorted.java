class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            hashMap.put(numbers[i], i + 1);
        }
        for (int i = 0; i < numbers.length; i++) {
            int found = target - numbers[i];
            if (hashMap.containsKey(found) && hashMap.get(numbers[i]) != i) {
                return new int[] {i + 1, hashMap.get(found)}; 
            }
        }
        return null;
    }
}
