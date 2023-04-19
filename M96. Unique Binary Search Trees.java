class Solution {
    public int numTrees(int n) {
        // Create an array to store the number of possible binary trees for a given number of nodes
        int[] numTreesArray = new int[n + 1];
        // Initialize the first two elements of the array to 1
        numTreesArray[0] = numTreesArray[1] = 1;

        // Loop through all possible numbers of nodes
        for (int num = 2; num <= n; num++) {
            // Loop through all possible left subtree sizes for the current number of nodes
            for (int leftSize = 1; leftSize <= num; ++leftSize) {
                // Calculate the number of possible binary trees for the current number of nodes
                numTreesArray[num] = numTreesArray[num] + numTreesArray[leftSize - 1] * numTreesArray[num - leftSize];
            }
        }

        // Return the number of possible binary trees for the given number of nodes
        return numTreesArray[n];
    }
}
