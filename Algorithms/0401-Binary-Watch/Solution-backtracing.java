class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> out = new ArrayList<>();

        int[] a = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32}; // [0-3] hours, [4-9] minutes
        readBinaryWatch(a, 0, 0, 0, turnedOn, out);

        return out;
    }

    private void readBinaryWatch(int[] a, int pos, int h, int m, int l, List<String> out) {
        if(l == 0) {
            if(h <= 11 && m <= 59) {
                StringBuilder sb = new StringBuilder();
                sb.append(h).append(":").append(m <= 9 ? "0" + m : m);
                out.add(sb.toString());
            }
            return;
        }

        for(int i = pos; i < a.length; i++) {
            if(i >= 0 && i <= 3)
                h += a[i];
            else
                m += a[i];
            
            readBinaryWatch(a, i + 1, h, m, l - 1, out);

            if(i >= 0 && i <= 3)
                h -= a[i];
            else
                m -= a[i];
        }
    }
}
