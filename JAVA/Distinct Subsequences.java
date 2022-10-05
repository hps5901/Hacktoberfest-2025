// Given two strings s and t, return the number of distinct subsequences of s which equals t.

// A string's subsequence is a new string formed from the original string by deleting some (can be none) of the characters without disturbing the remaining characters' relative positions. (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).

// JAVA Solution:

class Solution {
    public int numDistinct(String s, String t) {
   
    int n= s.length();
    int m= t.length();
    int[][] dp = new int[n+1][m+1];
    for(int[] row: dp){
        Arrays.fill(row,-1);
    }
 return solve(s,t,n,m,0,0,dp);
}


      public int solve(String s, String t,int n, int m, int i, int j,int[][] dp){
          if(j>=m){
          return 1;
   } 
   if(i>=n){
       return 0;
   } 
   if(dp[i][j]!=-1){
       return dp[i][j];
   } 
   
   if(s.charAt(i)!=t.charAt(j)){
       return dp[i][j]=solve(s,t,n,m,i+1,j,dp);
   } 
    else{
        return dp[i][j]= solve(s,t,n,m,i+1,j,dp) + solve(s,t,n,m,i+1,j+1,dp);
    }
      }
}
