package day05_Stacks;

public class ExprBalanceCheck {

    public static void main(String[] args) {

        System.out.println(balanceCheck("(A*C) + ({V-M})"));
    }

    public static boolean balanceCheck(String expr) {
// create a Stack
        MyStack<Character> myStack = new MyStack<>();
// iterate over expr
        for (int i = 0; i < expr.length(); i++) {

            Character ch = expr.charAt(i);
        // filter non player chars (wrong symbols)
            if (ch != '(' && ch != '[' && ch != '{' && ch != ')' && ch != ']' && ch != '}')
                continue;
        // if correct symbol:
            // if opening symbol -> push to Stack
            if (ch == '(' || ch == '[' || ch == '{') {
                myStack.push(ch);
            }
        // at this point we need the closing symbols
            // stack shouldn't be empty
            if (myStack.isEmpty()) return false;

            switch(ch) {
                case ')':
                    if (myStack.pop() != '(') return false;
                    break;
                case ']':
                    if (myStack.pop() != '[') return false;
                    break;
                case '}':
                    if (myStack.pop() != '{') return false;
                    break;
            }
        }   // end of for
// return if stack is empty
        return myStack.isEmpty();
    }
}
