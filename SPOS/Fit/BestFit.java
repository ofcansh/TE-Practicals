import java.util.Scanner;

public class BestFit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int blockSize[] = {100, 500, 200, 300, 600};
        int job[] = {212, 417, 112, 426};
        int m = blockSize.length;
        int n = job.length;
        int allocation[] = new int[n];

        for (int i = 0; i < allocation.length; i++) {
            allocation[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            int bestIndex = -1;
            for (int j = 0; j < m; j++) {
                if (job[i] <= blockSize[j]) {
                    if (bestIndex == -1 || blockSize[bestIndex] > blockSize[j]) {
                        bestIndex = j;
                    }
                }
            }
            if (bestIndex != -1) {
                allocation[i] = bestIndex;
                blockSize[bestIndex] -= job[i]; // Reduce the size of the block
            }
        }

        System.out.println("Best Fit Allocation Results:");
        for (int i = 0; i < n; i++) {
            if (allocation[i] != -1) {
                System.out.println("Job " + i + " allocated to block " + allocation[i]);
            } else {
                System.out.println("Job " + i + " not allocated");
            }
        }
        sc.close();
    }
}
