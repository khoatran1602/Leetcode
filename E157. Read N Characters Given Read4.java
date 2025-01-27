/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
//The API return an integer
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int index = 0;
        char[] r4 = new char[4];
        while(index < n){
            int c = read4(r4);
            for(int i = 0; i < c && index < n; i++){
                buf[index++] = r4[i];
            }
            if(c < 4) break;
        }

        return index;
    }
}
