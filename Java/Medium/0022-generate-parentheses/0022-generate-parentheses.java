class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> ll = new ArrayList<>();

    
        Parent(n, 0, 0, "",ll);
        return ll;
    }

    public static void Parent(int n, int open,int close,String ans, List<String> ll ) {
        if( open == n && close == n){
            ll.add(ans);
            return;      // although it would've worked without return too because unnecessary calls won't happen since both calls are capped inside "if" conditions
        }
        if( open < n ){
            Parent(n, open+1, close, ans + "(",ll); // increase open by 1 if call is of open
        }

        if( close < open ){
            Parent( n,open, close+1, ans + ")",ll); // increase open by 1 if call is of open
        }
        // also you could've changed the both calls if block place with each other ans would have come similar but in diff order
    }
}
 