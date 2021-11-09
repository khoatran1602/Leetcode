class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int len = 0;
        int min = Integer.MAX_VALUE;
        String[] list3 = new String[len];

        for (int i = 0; i < list1.length; i++) {
            for (int  j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (min > i + j) {
                        min = i + j;
                    }
                }
            }
        }
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j]) && min == i + j) {
                    String[] copy = list3;
                    list3 = new String[copy.length + 1];
                    int k = 0;
                    for (; k < copy.length; k++) list3[k] = copy[k];
                    list3[k++] = list1[i];  
                }
            }
        }
        return list3;
    }
}
