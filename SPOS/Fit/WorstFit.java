import java.util.Scanner;

public class WorstFit {
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
            int worstIndex = -1;
            for (int j = 0; j < m; j++) {
                if (job[i] <= blockSize[j] && (worstIndex == -1 || blockSize[worstIndex] < blockSize[j])) {
                    worstIndex = j;
                }
            }
            if (worstIndex != -1) {
                allocation[i] = worstIndex;
                blockSize[worstIndex] -= job[i]; // Reduce the size of the block
            }
        }

        System.out.println("Worst Fit Allocation Results:");
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
