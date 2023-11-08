import java.util.Scanner;

public class task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] cars = new int[n];
        for (int i = 0; i < n; i++) {
            cars[i] = scanner.nextInt();
        }

        int[] deadEnd = new int[n];
        int deadEndIndex = 0;

        int[] track2 = new int[n];
        int track2Index = 0;

        for (int i = 0; i < n; i++) {
            if (deadEndIndex < n) {
                deadEnd[deadEndIndex++] = cars[i];
            } else {
                track2[track2Index++] = cars[i];
            }
        }

        boolean inOrder = true;
        for (int i = 0; i < n; i++) {
            if (cars[i] != track2[i]) {
                inOrder = false;
                break;
            }
        }

        if (inOrder) {
            System.out.println("0");
        } else {
            int[] moves = new int[n * 2];
            int movesIndex = 0;

            for (int i = 0; i < n; i++) {
                if (cars[i] != track2[i]) {
                    int j = 0;
                    while (j < n && cars[j] != track2[i]) {
                        j++;
                    }

                    moves[movesIndex++] = 1;
                    moves[movesIndex++] = j - i + 1;

                    for (int k = i; k <= j; k++) {
                        cars[k] = cars[k + 1];
                    }
                    i = j;
                }
            }

            for (int i = 0; i < movesIndex; i += 2) {
                System.out.println(moves[i] + " " + moves[i + 1]);
            }
        }
    }
}
