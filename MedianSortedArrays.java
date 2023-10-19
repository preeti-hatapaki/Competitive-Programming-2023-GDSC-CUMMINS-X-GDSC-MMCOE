import java.util.*;

public class MedianSortedArrays {
    public static double calculateMedian(int[] nums1, int[] nums2) {
        int[] merged = mergeArrays(nums1, nums2);
        int n = merged.length;
        if (n % 2.00 == 0) {
            // even
            return (merged[n / 2 - 1] + merged[n / 2]) / 2.00;
        } else {
            //  odd
            return merged[n / 2];
        }
    }
    private static int[] mergeArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        while (i < nums1.length) {
            merged[k++] = nums1[i++];
        }

        while (j < nums2.length) {
            merged[k++] = nums2[j++];
        }

        return merged;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.print("Enter sorted array 1: ");
            int[] nums1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.print("enter sorted array 2: ");
            int[] nums2 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            double output = calculateMedian(nums1, nums2);
            System.out.println("output: " + output);
            System.out.print("Press 1 to continue, or any other number to exit: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 
        } 
        while (choice == 1);
        System.out.println("Thank you :)");
    }
}