class Solution {
    public String decodeString(String s) {
        Queue<Character> q = new LinkedList<>();

        for(int i = 0; i < s.length(); i++)
            q.add(s.charAt(i));

        return decodeString(q);
    }

    private String decodeString(Queue<Character> q) {
        StringBuffer out = new StringBuffer();
        int x = 0;

        while(!q.isEmpty()) {
            char ch = q.poll();
            if(Character.isDigit(ch))
                x = x * 10 + (ch - '0');
            else if(ch == '[') {
                String curr = decodeString(q);
                for(int i = 0; i < x; i++)
                    out.append(curr);
                curr = "";
                x = 0;
            } else if(ch == ']')
                break;
            else
                out.append(ch);
        }

        return out.toString();
    }
}
