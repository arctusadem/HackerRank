package MergeSortedLinkedLists;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {

        public static LinkedList merge_sorted(
                LinkedList head1,
                LinkedList head2) {

            if (head1 == null) {
                return head2;
            } else if (head2 == null) {
                return head1;
            }

            LinkedList mergedHead = new LinkedList<>();

            while (!head1.isEmpty() || !head2.isEmpty()) {
                if (head1.isEmpty()) {
                    mergedHead.addAll(head2);
                    head2.clear();
                } else if (head2.isEmpty()) {
                    mergedHead.addAll(head1);
                    head1.clear();
                } else if ((int)head1.getFirst() <= (int)head2.getFirst()) {
                    mergedHead.add(head1.getFirst());
                    head1.removeFirst();
                } else {
                    mergedHead.add(head2.getFirst());
                    head2.removeFirst();
                }
            }

            return mergedHead;

        }
        public static void main(String[] args) {
            Integer[] arr1 = {1, 3, 5, 6};
            Integer[] arr2 = {2, 4, 6, 20, 34};
            LinkedList list_head1 = new LinkedList(Arrays.asList(arr1));
            System.out.print("Original1: ");
            list_head1.forEach(x -> System.out.println(x));

            LinkedList list_head2 = new LinkedList(Arrays.asList(arr2));
            System.out.print("Original2: ");
            list_head2.forEach(x -> System.out.println(x));

            System.out.println("\nMerged:");

            LinkedList newHead = merge_sorted(list_head1, list_head2);
            newHead.forEach(x -> System.out.println(x));
        }
}
