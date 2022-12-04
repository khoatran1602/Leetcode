class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        ArrayList<String> res = new ArrayList<>();
        for (int hour = 0; hour < 12; hour++) {
            for (int min = 0; min < 60; min++) {
                if (Integer.bitCount(hour) + Integer.bitCount(min) == turnedOn) {
                    if (min < 10) res.add(String.format("%d:0%d", hour, min));
                    else res.add(String.format("%d:%d", hour, min));
                }
            }
        }
        return res;
    }
}
