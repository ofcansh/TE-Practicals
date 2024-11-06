import java.util.Scanner;

class Lru {

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
                // Page fault: find the least recently used frame to replace
                int replaceIndex = findLRUFrame(buffer, reference, i);
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

    // Function to find the index of the frame to replace using LRU strategy
    private static int findLRUFrame(int[] frames, int[] pages, int currentIndex) {
        int lruIndex = -1;
        int lruTimestamp = -1;

        for (int i = 0; i < frames.length; i++) {
            boolean found = false;
            for (int j = currentIndex - 1; j >= 0; j--) {
                if (frames[i] == pages[j]) {
                    found = true;
                    if (j < lruTimestamp || lruTimestamp == -1) {
                        lruTimestamp = j;
                        lruIndex = i;
                    }
                    break;
                }
            }

            // If the frame is never found in the pages, it can be replaced
            if (!found) {
                return i; // Replace this frame
            }
        }
        return lruIndex; // Replace the least recently used frame
    }
}
