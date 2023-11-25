App.java
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner n = new Scanner(System.in);
        System.out.print("Enter Total Number of process:");
        int process = n.nextInt();
        System.out.print("Enter Total Number of blocks:");
        int blocks = n.nextInt();
        int p[] = new int[process];
        int b[] = new int[blocks];
        for (int i = 0; i < process; i++) {
            System.out.print("Enter size of each process " + (i + 1) + ":");
            int x = n.nextInt();
            p[i] = x;
        }
        for (int i = 0; i < blocks; i++) {
            System.out.print("Enter size of blocks " + (i + 1) + ":");
            int x = n.nextInt();
            b[i] = x;
        }
        First_fit_Allocation(p, b, process, blocks);
    }

    public static void First_fit_Allocation(int p[], int b[], int process, int blocks) {
        int allocate[] = new int[blocks];
        int waste[] = new int[blocks];
        for (int i = 0; i < process; i++) {

            for (int j = 0; j < blocks; j++) {
                if (p[i] <= b[j]) {
                    b[j] = b[j] - p[i];
                    allocate[i] = j + 1;
                    waste[i] = b[j];
                    break;
                }

            }

        }
        System.out.println("\nProcess No.\tProcess size\tAllocated block \tWasted block size");
        for (int x = 0; x < process; x++) {
            if (allocate[x] != 0) {
                System.out.println(x + 1 + "\t\t" + p[x] + "\t\t" + allocate[x] + "\t\t\t" + waste[x]);
            } else {
                System.out.println(x + 1 + "\t\t" + p[x] + "\t\tNot Allocated");
            }

        }

    }
}