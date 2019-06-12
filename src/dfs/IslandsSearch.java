package dfs;

public class IslandsSearch {

    public static void main(String[] args) {
        int[][] islands = new int[][] {
                { 1, 1, 0, 0, 1 },
                { 0, 1, 0, 1, 1 },
                { 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 }
        };
        int counter = countIslands(islands);
    }

    private static int countIslands(int[][] islands) {
        int counter = 0;
        for (int i = 0; i< islands.length; i++) {
            for (int j = 0; j< islands[i].length; j++) {
                if (islands[i][j] == 1) {
                    dfs(i,j,islands);
                    counter++;
                }
            }
        }
        System.out.println(counter);
        return counter;
    }

    private static void dfs(int row, int col, int[][] islands) {
        islands[row][col] = '-';
        if (col + 1 < islands[row].length && islands[row][col + 1] == 1) {
            dfs(row, col + 1, islands);
        }
        if (row + 1 < islands.length && col + 1 < islands[row].length && islands[row + 1][col + 1] == 1) {
            dfs(row+1, col + 1, islands);
        }
        if (row + 1 < islands.length && islands[row + 1][col] == 1) {
            dfs(row+1, col, islands);
        }
        if (row - 1 >=0 && islands[row - 1][col] == 1) {
            dfs(row - 1, col, islands);
        }
        if (col - 1 >= 0 && islands[row][col-1] == 1) {
            dfs(row, col-1, islands);
        }
        if (row - 1 >=0 && col - 1 >=0 && islands[row - 1][col - 1] == 1) {
            dfs(row-1, col-1, islands);
        }
        if (row + 1 < islands.length && col - 1 >=0 && islands[row + 1][col - 1] == 1) {
            dfs(row+1, col-1, islands);
        }
        if (row -1 >=0 && col + 1 < islands[row].length && islands[row - 1][col + 1] == 1) {
            dfs(row+1, col-1, islands);
        }

    }

}
