import java.util.Stack;

public class task3 {

    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (String token : expression.split(" ")) {
            if (Character.isDigit(token.charAt(0))) {
                int operand = Integer.parseInt(token);
                stack.push(operand);
            } else if (token.length() == 1) {
                char operator = token.charAt(0);
                int operand1 = stack.pop();
                int operand2 = stack.pop();

                switch (operator) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression");
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String expression = "2 3 + 4 * 5 +";
        int result = evaluatePostfix(expression);
        System.out.println(result);
    }
}
