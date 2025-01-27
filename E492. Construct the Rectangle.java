class Solution {
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) w--;
        System.out.println(area % w + " " + w);
        return new int[] {area / w, w};
    }
}
