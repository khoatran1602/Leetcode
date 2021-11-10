public int[] numberOfLines(int[] widths, String s) {
        int[] result = new int[2];
        result[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (result[1] + widths[index] > 100) {
                result[0]++;
                result[1] = 0;
            }
            result[1] = result[1] + widths[index];
        }
        return result;
    }
