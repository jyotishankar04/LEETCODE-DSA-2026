class Solution {

    static class Node {
        int len;
        int prefix;
        int suffix;
        int best;
        char leftChar;
        char rightChar;

        Node(int len, int prefix, int suffix, int best,
             char leftChar, char rightChar) {
            this.len = len;
            this.prefix = prefix;
            this.suffix = suffix;
            this.best = best;
            this.leftChar = leftChar;
            this.rightChar = rightChar;
        }
    }

    Node[] tree;
    char[] s;

    public int[] longestRepeating(
            String str,
            String queryCharacters,
            int[] queryIndices) {

        s = str.toCharArray();

        int n = s.length;
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int k = queryIndices.length;
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {

            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            s[index] = ch;

            update(1, 0, n - 1, index);

            ans[i] = tree[1].best;
        }

        return ans;
    }

    private void build(int node, int l, int r) {

        if (l == r) {
            tree[node] = new Node(
                    1,
                    1,
                    1,
                    1,
                    s[l],
                    s[l]
            );
            return;
        }

        int mid = l + (r - l) / 2;

        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        tree[node] = merge(
                tree[node * 2],
                tree[node * 2 + 1]
        );
    }

    private void update(int node, int l, int r, int index) {

        if (l == r) {
            tree[node] = new Node(
                    1,
                    1,
                    1,
                    1,
                    s[index],
                    s[index]
            );
            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index);
        } else {
            update(node * 2 + 1, mid + 1, r, index);
        }

        tree[node] = merge(
                tree[node * 2],
                tree[node * 2 + 1]
        );
    }

    private Node merge(Node left, Node right) {

        int len = left.len + right.len;

        int prefix = left.prefix;
        int suffix = right.suffix;

        int best = Math.max(left.best, right.best);

        // The two boundary runs can be joined
        if (left.rightChar == right.leftChar) {

            best = Math.max(
                    best,
                    left.suffix + right.prefix
            );

            // Entire left segment has same character
            if (left.prefix == left.len) {
                prefix = left.len + right.prefix;
            }

            // Entire right segment has same character
            if (right.suffix == right.len) {
                suffix = right.len + left.suffix;
            }
        }

        return new Node(
                len,
                prefix,
                suffix,
                best,
                left.leftChar,
                right.rightChar
        );
    }
}