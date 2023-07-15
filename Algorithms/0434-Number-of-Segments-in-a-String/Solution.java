class Solution {
    public int countSegments(String s) {
        String trimmed = s.trim();

        return trimmed.equals("") ? 0 : trimmed.split("\\s+").length;
    }
}
