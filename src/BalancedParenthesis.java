import java.util.ArrayDeque;

public class BalancedParenthesis {

    //function to check whether two characters are matched or not
    static boolean matching(char a,char b){
        return (a=='(' && b==')')||(a=='{'&&b=='}')||(a=='['&&b==']');
    }
    static boolean balanced(String s){
        //Created a stack as
        ArrayDeque<Character> as = new ArrayDeque<>();
        //For each character in string if it is opened push it into stack
        //If it is closed check if it is matched with lastest opened bracket
        //If equal pop and move to next bracket
        //If not equal return false
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='('||c=='{'||c=='['){
                as.push(c);
            }else {
                //If closing brackets are more than opening then at some point stack will become empty
                //Which indicates not balanced
                if (as.isEmpty()){
                    return false;
                }else if (matching(as.peek(),c)==false){
                    return false;
                }else{
                    as.pop();
                }
            }
        }

        //After all matching if stack still contain any brackets then return false else true.
        return as.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{([])}";
        //String is passed into the function.
        System.out.println(balanced(s));
    }
}
