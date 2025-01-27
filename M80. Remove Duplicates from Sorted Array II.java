class Solution {
    public int removeDuplicates(int[] nums) {
        int res = 0;  // initialize the result counter to 0
        int index = 0;  // initialize the index variable to 0
        HashMap<Integer, Integer> map = new HashMap<>();  // create a hash map to store the frequency of each element
        for (int num : nums) {  // iterate through the array
            if (!map.containsKey(num)) {  // if the element is not in the hash map
                map.put(num, map.getOrDefault(num, 0));  // add it to the hash map with a default value of 0
            }
            map.put(num, map.get(num) + 1);  // increment the frequency of the element in the hash map
        }
        for (Integer key : map.keySet()) {  // iterate through the hash map
            if (map.get(key) < 3) {  // if the element appears at most two times
                res = res + map.get(key);  // increment the result counter by the frequency of the element
                if (map.get(key) == 1) {  // if the element appears only once
                    nums[index++] = key;  // add it to the new array once
                } else {  // if the element appears twice
                    nums[index++] = key;  // add it to the new array twice
                    nums[index++] = key;
                }
            } else {  // if the element appears more than two times
                res = res + 2;  // increment the result counter by 2
                nums[index++] = key;  // add the element to the new array twice
                nums[index++] = key;
            }
        }
        for (int i = index; i < nums.length; i++) {  // fill any remaining indices in the new array with Integer.MAX_VALUE
            nums[i] = Integer.MAX_VALUE;
        }
        Arrays.sort(nums);  // sort the new array
        return res;  // return the length of the new array
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0; // initialize a pointer to the position where the next unique element will be written
        for (int i = 0; i < nums.length; i++) { // loop through each element of the array
            if (i < 2 || nums[i] > nums[index - 2]) { // if the current element is the first or second occurrence of the value, or if it is greater than the second-to-last unique element seen so far
                nums[index++] = nums[i]; // write the current element to the next position in the array and move the index pointer forward
            }
        }
        return index; // return the new length of the array
    }
}
