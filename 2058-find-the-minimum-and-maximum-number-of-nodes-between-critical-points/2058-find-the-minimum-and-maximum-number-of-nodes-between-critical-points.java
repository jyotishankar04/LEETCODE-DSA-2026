class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int minDist = Integer.MAX_VALUE;
        int maxDist = -1;

        ListNode prev = head;
        ListNode curr = head.next;

        int index = 1;

        int firstCritical = -1;
        int prevCritical = -1;

        while (curr.next != null) {

            int prevVal = prev.val;
            int currVal = curr.val;
            int nextVal = curr.next.val;

            // Check if current node is a critical point
            boolean isCritical =
                    (currVal > prevVal && currVal > nextVal) ||
                    (currVal < prevVal && currVal < nextVal);

            if (isCritical) {

                // First critical point
                if (firstCritical == -1) {
                    firstCritical = index;
                }

                // We already have a previous critical point
                if (prevCritical != -1) {
                    minDist = Math.min(minDist, index - prevCritical);
                }

                prevCritical = index;

                // Distance from first to current
                maxDist = index - firstCritical;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        // Fewer than two critical points
        if (minDist == Integer.MAX_VALUE) {
            return new int[] {-1, -1};
        }

        return new int[] {minDist, maxDist};
    }
}