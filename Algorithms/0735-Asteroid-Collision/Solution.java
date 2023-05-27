class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> out = new Stack<Integer>();

        for(int i = 0; i < asteroids.length; i++) {
            int v = asteroids[i];
            if(v <= 0) {
                while(out.size() > 0 && out.peek() > 0 && out.peek() < -v)
                    out.pop();
                if(out.size() > 0 && out.peek() == -v)
                    out.pop();
                else if(!(out.size() > 0 && out.peek() > -v))
                    out.add(v);
            } else
                out.add(v);
        }
    
        int[] r = new int[out.size()];
        
        while(!out.isEmpty())
            for(int i = r.length - 1; i >= 0; i--)
                r[i] = out.pop();
        
        return r;
    }
}
