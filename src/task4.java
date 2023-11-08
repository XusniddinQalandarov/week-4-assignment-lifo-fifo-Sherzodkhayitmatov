import java.util.*;

public class task4 {


class Container {
    int type;

    public Container(int type) {
        this.type = type;
    }
}

class Stack {
    List<Container> containers;

    public Stack() {
        this.containers = new ArrayList<>();
    }

    public void push(Container container) {
        containers.add(container);
    }

    public Container pop() {
        if (containers.isEmpty()) {
            return null;
        } else {
            return containers.remove(containers.size() - 1);
        }
    }

    public int size() {
        return containers.size();
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Stack[] stacks = new Stack[n];
        for (int i = 0; i < n; i++) {
            stacks[i] = new Stack();
            int k = scanner.nextInt();
            for (int j = 0; j < k; j++) {
                int type = scanner.nextInt();
                stacks[i].push(new Container(type));
            }
        }

        boolean solutionFound = solve(stacks);
        if (!solutionFound) {
            System.out.println(0);
        }
    }

    public static boolean solve(Stack[] stacks) {
        for (int i = 0; i < stacks.length; i++) {
            if (stacks[i].size() > 0 && stacks[i].peek().type != i + 1) {
                return false;
            }
        }

        while (true) {
            boolean progressMade = false;

            for (int i = 0; i < stacks.length; i++) {
                if (stacks[i].size() > 0 && stacks[i].peek().type != i + 1) {
                    Container container = stacks[i].pop();

                    for (int j = 0; j < stacks.length; j++) {
                        if (container.type == j + 1 && stacks[j].size() == 0) {
                            stacks[j].push(container);
                            progressMade = true;
                            break;
                        }
                    }

                    if (!progressMade) {
                        return false; // No possible moves
                    }
                }
            }

            if (!progressMade) {
                break; // No more moves to make
            }
        }

        return true;
    }
}
}