package com.poojalakhani.dp;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.find("ABCDGH", "AEDFHR"));
        System.out.println(lcs.findTabulated("ABCDGH", "AEDFHR"));
    }

    public int find(String s1, String s2) {
        return find(s1, s2, s1.length() - 1, s2.length() - 1);

    }

    private int find(String s1, String s2, int l1, int l2) {
        if (l1 == -1 || l2 == -1)
            return 0;


        if (s1.charAt(l1) == s2.charAt(l2))
            return 1 + find(s1, s2, l1 - 1, l2 - 1);
        else return Math.max(find(s1, s2, l1 - 1, l2), find(s1, s2, l1, l2 - 1));


    }

    public int findTabulated(String s1, String s2) {
        int a[][] = new int[s1.length()+1][s2.length()+1];
        for(int i=0; i<s1.length(); i++) {
            for(int j=0; j<=s2.length(); j++) {
                if(i == 0 || j==0)
                    a[i][j]=0;
                else
                    if(s1.charAt(i-1) == s2.charAt(j-1))
                        a[i][j] = 1 + a[i-1][j-1];
                    else
                        a[i][j] = Math.max(a[i-1][j], a[i][j-1]);

            }
        }

        return a[s1.length()][s2.length()];

    }


}
