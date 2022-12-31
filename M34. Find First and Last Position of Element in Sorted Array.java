class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 1 && nums[0] != target) return new int[] {-1, -1};
        if (nums.length == 1) return new int[] {0, 0};
        int start = 0;
        int end = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target && start == 0 && temp == 0) {
                System.out.println(i + " " + nums[i]);
                start = i;
                temp++;
            } else if (nums[i] == target && temp != 0) {
                System.out.println(i + " " + nums[i]);
                end = i;
            }
        }
        if (temp == 0) {
            return new int[] {-1, -1};
        }
        if (end == 0) {
            return new int[] {start, start};
        }
        return new int[] {start, end};
    }
}

// public int[] searchRange(int[] nums, int target) {
//         int n = nums.length;
//         int f = first(nums, 0, n - 1, target, n);
//         int l = last(nums, 0, n - 1, target, n);
//         int[] pos = {f, l};
//         return pos;
//     }

//     public static int first(int arr[], int low, int high, int x, int n) {
//         if (high >= low) {
//             int mid = low + (high - low) / 2;
//             if ((mid == 0 || x > arr[mid - 1])
//                     && arr[mid] == x)
//                 return mid;
//             else if (x > arr[mid])
//                 return first(arr, (mid + 1), high, x, n);
//             else
//                 return first(arr, low, (mid - 1), x, n);
//         }
//         return -1;
//     }

//     public static int last(int arr[], int low, int high, int x, int n) {
//         if (high >= low) {
//             int mid = low + (high - low) / 2;
//             if ((mid == n - 1 || x < arr[mid + 1])
//                     && arr[mid] == x)
//                 return mid;
//             else if (x < arr[mid])
//                 return last(arr, low, (mid - 1), x, n);
//             else
//                 return last(arr, (mid + 1), high, x, n);
//         }
//         return -1;
//     }
