class Solution {
    public int countSegments(String s) {
        //If there are no characters
        if (s.equals("")) return 0;
        //Replace all the long white space to a white space
        s = s.replaceAll("/\s{2,}/g", " ");
        //Create array with every word in s
        String[] res = s.split(" ");
        //Get the size
        int size = res.length;
        //Subtract if the element is not a string
        for (int i = 0; i < res.length; i++) {
            if (res[i].equals("")) size--;
        }

        return size;
    }
}
