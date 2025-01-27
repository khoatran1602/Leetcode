class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        int len = 0;
        int index = 0;
        for (int num : nums1) {
            if (map1.containsKey(num)) {
                map1.put(num, map1.get(num) + 1);
            } else {
                map1.put(num, 1);
            }
        }
        for (int num : nums2) {
            if (map2.containsKey(num)) {
                map2.put(num, map2.get(num) + 1);
            } else {
                map2.put(num, 1);
            }
        }
        for (Integer key : map1.keySet()) {
            if (map2.containsKey(key)) {
                if (map1.get(key) < map2.get(key)) {
                    len = len + map1.get(key);
                } else {
                    len = len + map2.get(key);
                }
            }
        }
        int[] nums3 = new int[len];
        for (Integer map : map1.keySet()) {
            if (map2.containsKey(map)) {
                if (map2.get(map) > map1.get(map)) {
                    for (int i = 0; i < map1.get(map); i++) {
                        nums3[index++] = map;
                    }
                } else {
                    for (int i = 0; i < map2.get(map); i++) {
                        nums3[index++] = map;
                    }
                }
            }
        }
        return nums3;
    }
}
