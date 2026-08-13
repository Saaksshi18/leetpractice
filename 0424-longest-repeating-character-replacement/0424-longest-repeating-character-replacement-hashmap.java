class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> freq = new HashMap<>();

        int left=0;
        int maxcount =0;
        int maxlength =0;

        for(int right =0; right< s.length(); right++){
            char ch = s.charAt(right);
            freq.put(ch, freq.getOrDefault(ch,0)+1);

            maxcount = Math.max(maxcount, freq.get(ch));

            while((right-left+1)-maxcount >k){
                char leftchar = s.charAt(left);

                freq.put(leftchar, freq.get(leftchar)-1);

                left++;
            }
            maxlength = Math.max(maxlength, right -left +1);
        }
        return maxlength;
    }
}