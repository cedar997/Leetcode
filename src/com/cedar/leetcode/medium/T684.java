package com.cedar.leetcode.medium;

import java.util.Arrays;

public class T684 {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{1, 2}, {1, 3}, {2, 3}};
        int[] ret = new T684().findRedundantConnection(edges);
        System.out.println(Arrays.toString(ret));
    }

    public int[] findRedundantConnection(int[][] edges) {
        final int n = edges.length;
        UnionFind uf = new UnionFind(n + 1);
        for (int i = 0; i < n; i++) {
            int x = edges[i][0];
            int y = edges[i][1];

            if (uf.isConnected(x, y)) {
                return new int[]{x, y};
            }

            uf.union(x, y);
        }
        return null;
    }


    class UnionFind {
        private int[] parent;
        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;

        }

        public int find(int x) {
            if (x != parent[x]) {

                parent[x] = find(parent[x]);

            }
            return parent[x];
        }

        public boolean isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return true;
            } else {
                return false;
            }
        }
    }
}

