class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        // Store coordinates of all 1s in both images.
        List<int[]> ones1 = new ArrayList<>();
        List<int[]> ones2 = new ArrayList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (img1[r][c] == 1) {
                    ones1.add(new int[]{r, c});
                }

                if (img2[r][c] == 1) {
                    ones2.add(new int[]{r, c});
                }
            }
        }

        // Map each translation (rowShift, colShift)
        // to the number of overlapping 1s.
        Map<String, Integer> shifts = new HashMap<>();

        int answer = 0;

        for (int[] p1 : ones1) {
            for (int[] p2 : ones2) {
                int rowShift = p2[0] - p1[0];
                int colShift = p2[1] - p1[1];

                String key = rowShift + "," + colShift;

                int count = shifts.getOrDefault(key, 0) + 1;
                shifts.put(key, count);

                answer = Math.max(answer, count);
            }
        }

        return answer;
    }
}