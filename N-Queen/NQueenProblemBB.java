/* Branch and bound */

import java.util.Arrays;

class NQueenProblemBB {
  private static boolean isSafe(char[][] mat, int r, int c) {
    for (int i = 0; i < r; i++) {
      if (mat[i][c] == 'Q') {
        return false;
      }
    }
    for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
      if (mat[i][j] == 'Q') {
        return false;
      }
    }
    for (int i = r, j = c; i >= 0 && j < mat.length; i--, j++) {
      if (mat[i][j] == 'Q') {
        return false;
      }
    }
    return true;
  }

  private static void printSolution(char[][] mat) {
    for (char[] chars : mat) {
      System.out.println(Arrays.toString(chars).replaceAll(",", ""));
    }
    System.out.println();
  }

  private static void nQueen(char[][] mat, int r) {
    if (r == mat.length) {
      printSolution(mat);
      return;
    }
    for (int i = 0; i < mat.length; i++) {
      if (isSafe(mat, r, i)) {
        mat[r][i] = 'Q';
        nQueen(mat, r + 1);
        mat[r][i] = '–';
      }
    }
  }

  public static void main(String[] args) {
    int N = 8;
    long tempoInicial = System.currentTimeMillis();
    char[][] mat = new char[N][N];
    for (int i = 0; i < N; i++) {
      Arrays.fill(mat[i], '–');
    }
    nQueen(mat, 0);
    System.out.println(System.currentTimeMillis() - tempoInicial);
  }
}

// Referencia : https://www.geeksforgeeks.org/n-queen-problem-using-branch-and-bound/
