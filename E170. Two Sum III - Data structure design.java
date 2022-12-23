class TwoSum {

    HashMap<Integer, Integer> map;
    
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int i : map.keySet()) {
            int target = value - i;
            int counter = target == i? 2 : 1;
            if (map.getOrDefault(target, 0) >= counter) {
                return true;
            }
        }
        return false;
    }
}
