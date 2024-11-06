import java.util.Scanner;

class Optimal {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Length Of String: ");
        int ref_length = input.nextInt();
        System.out.print("Enter Size Of Frame: ");
        int frame = input.nextInt();

        int hit = 0, fault = 0;
        int[] buffer = new int[frame];
        int[] reference = new int[ref_length];
        int[][] memory_layout = new int[ref_length][frame];

        System.out.println("Enter The String: ");
        for (int i = 0; i < ref_length; i++) {
            reference[i] = input.nextInt();
        }
        System.out.println();

        // Initialize frames to -1 (empty)
        for (int i = 0; i < frame; i++) {
            buffer[i] = -1;
        }

        // Process each page reference
        for (int i = 0; i < ref_length; i++) {
            boolean pageFound = false;

            // Check if the page is already in the buffer
            for (int j = 0; j < frame; j++) {
                if (buffer[j] == reference[i]) {
                    pageFound = true;
                    hit++;
                    break;
                }
            }

            if (!pageFound) {
                // Page fault: find the optimal frame to replace
                int replaceIndex = findOptimalFrame(buffer, reference, i);
                buffer[replaceIndex] = reference[i];
                fault++;
            }

            // Record the current state of the buffer
            for (int j = 0; j < frame; j++) {
                memory_layout[i][j] = buffer[j];
            }
        }

        // Print memory layout
        for (int i = 0; i < ref_length; i++) {
            for (int j = 0; j < frame; j++) {
                System.out.print(memory_layout[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println();
        float hit_ratio = (float) hit / (float) ref_length;
        System.out.println("Faults: " + fault);
        System.out.println("Hits: " + hit);
        System.out.println("Hit Ratio: " + hit_ratio);
    }

    // Function to find the index of the frame to replace using Optimal strategy
    private static int findOptimalFrame(int[] frames, int[] pages, int currentIndex) {
        int right_index = currentIndex;
        int replaceIndex = 0;

        for (int i = 0; i < frames.length; i++) {
            int j;
            for (j = currentIndex; j < pages.length; j++) {
                if (frames[i] == pages[j]) {
                    if (j > right_index) {
                        right_index = j;
                        replaceIndex = i;
                    }
                    break;
                }
            }
            if (j == pages.length) {
                // If the page is not found in the future references, it should be replaced
                return i;
            }
        }
        return replaceIndex;
    }
}

