class Solution {
    public String simplifyPath(String path) {
        String[] components = path.split("/");
        String[] canonicalPath = new String[components.length];
        int i = 0;

        for(String comp : components) {
            if(comp.equals("..")) {
                if(i > 0) i--;
            } else if(!comp.equals(".") && !comp.equals(""))
                canonicalPath[i++] = comp;
        }

        return "/" + String.join("/", Arrays.copyOf(canonicalPath, i));
    }
}
