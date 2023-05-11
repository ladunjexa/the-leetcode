class Solution {
    public int maximum69Number (int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int i = 0;
        
        do {
            if(arr[i] == '6') {
                arr[i] = '9';
                return Integer.parseInt(String.valueOf(arr));
            }
            i++;
        } while(i < arr.length);

        return num;
    }
}