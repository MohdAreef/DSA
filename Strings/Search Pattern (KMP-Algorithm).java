class Solution
{
    public  int[] createpreftable(String pattern, String str) {
         int n = pattern.length();
        int[] preftable = new int[n];
        int l = 0; // length of the previous longest prefix suffix
        int i = 1;

        while (i < n) {
            if (pattern.charAt(i)  == pattern.charAt(l)) {
                l++;
                preftable[i] = l;
                i++;
            } else {
                if (l != 0) {
                    l = preftable[l - 1];
                } else {
                    preftable[i] = 0;
                    i++;
                }
            }
        }
        return preftable;
    }

    public  ArrayList<Integer> match(String pattern, String str, int[] pref) {
        
        int m = str.length();
        int n = pattern.length();
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0; // index for str
        int j = 0; // index for pattern

        while (i < m) {
            if (pattern.charAt(j) == str.charAt(i)) {
                i++;
                j++;
            }
            else if (i < m && pattern.charAt(j) != str.charAt(i)) {
                if (j != 0) {
                    j = pref[j - 1];
                } else {
                    i++;
                }
            }
            if (j == n) {
                result.add(i - j+1);
                j = pref[j - 1];
            } 
           
        }
        return result;
    }

    ArrayList<Integer> search(String pat, String txt)
    {
        // your code here
        int[] pref = createpreftable(pat, txt);
        return match(pat,txt,pref);
    }
}
