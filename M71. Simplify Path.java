class Solution {
    // Method to simplify the Unix file path
    public String simplifyPath(String path) {
        // Use a stack to store the valid directory names
        Stack<String> s = new Stack<>();
        // Split the path by "/"
        String[] p = path.split("/");
        // Iterate through each directory name in the path
        for (String dir : p) {
            // If the directory name is ".." and the stack is not empty, pop the top element
            if (dir.equals("..") && !s.isEmpty()) {
                s.pop();
            }
            // If the directory name is not empty, ".", or "..", push it to the stack
            else if (!dir.equals("") && !dir.equals(".") && !dir.equals("..")) {
                s.push(dir);
            }
        }
        // If the stack is empty, return "/"
        if (s.isEmpty()) return "/";
        // Build the simplified path from the stack
        StringBuilder res = new StringBuilder();
        for (String dir : s) {
            res.append("/").append(dir);
        }
        // Return the simplified path
        return res.toString();
    }
}
