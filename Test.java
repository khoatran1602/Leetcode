class Solution {
  public int[] solution(String recipients, int[] amounts) {
    int minA = 0;
    int minB = 0;

    int balA = 0;
    int balB = 0;

    for (int i = 0; i < recipients.length(); i++) {
      if (recipients.charAt(i) == 'A') {
        balA += amounts[i];
        balB -= amounts[i];
        if (balB < minB) {
          minB = balB;
        }
      } else if (recipients.charAt(i) == 'B') {
        balB += amounts[i];
        balA -= amounts[i];
        if (balA < minA) {
          minA = balA;
        }
      }
    }

    return new int[] { -minA, -minB };
  }
    
  public static void main(String[] args) {
    Solution solution = new Solution();
    String recipients = "ABAB";
    int[] amounts = { 1, 2, 3, 4 };
    int[] result = solution.solution(recipients, amounts);
    System.out.println("Minimum amount for A: " + result[0]);

  }
}