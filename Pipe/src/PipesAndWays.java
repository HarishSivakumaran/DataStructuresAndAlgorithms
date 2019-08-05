import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PipesAndWays {

    public static class Pipe {
        HashSet<Integer> up;
        HashSet<Integer> right;
        HashSet<Integer> down;
        HashSet<Integer> left;
        int row;
        int col;


        public Pipe(HashSet<Integer> up,
                    HashSet<Integer> right,
                    HashSet<Integer> down,
                    HashSet<Integer> left) {

            this.down = down;
            this.left = left;
            this.right = right;
            this.up = up;

        }
    }


    public static void main(String[] args) {

        Pipe[] pipeArr = createPipes();
        Scanner scanner = new Scanner(System.in);

        int noOfRows = scanner.nextInt();
        int noOfCols = scanner.nextInt();
        int enR = scanner.nextInt();
        int enC = scanner.nextInt();
        int enLength = scanner.nextInt();

        int[][] pipeMatrix = new int[noOfRows][noOfCols];
        int[][] countMatrix = new int[noOfRows][noOfCols];

        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfCols; j++) {
                pipeMatrix[i][j] = scanner.nextInt();
                countMatrix[i][j] = -1;

            }
        }

        countMatrix[enR][enC] = enLength - 1;

        Queue<Pipe> queue = new LinkedList<Pipe>();

        pipeArr[pipeMatrix[enR][enC]].row = enR;
        pipeArr[pipeMatrix[enR][enC]].col = enC;
        queue.add(pipeArr[pipeMatrix[enR][enC]]);

        while (!queue.isEmpty()) {

            Pipe currentPipe = queue.remove();
             int currentRow = currentPipe.row;
             int currentCol = currentPipe.col;

             //up

            if ((currentPipe.up != null) &&
                    !(isOutOfBounds(currentRow - 1,currentCol,noOfRows,noOfCols)) &&

                    (currentPipe.up.contains(pipeMatrix[currentRow - 1][currentCol])) &&
                    (countMatrix[currentRow - 1][currentCol] < countMatrix[currentRow][currentCol] - 1)) {
                Pipe[] p = createPipes();
                Pipe nextPipe =  p[pipeMatrix[currentRow-1][currentCol]];
                nextPipe.row = currentRow-1;
                nextPipe.col = currentCol;
                queue.add(nextPipe);
                countMatrix[currentRow-1][currentCol]=countMatrix[currentRow][currentCol] - 1;
            }

            //right

            if ((currentPipe.right != null) &&
                    !(isOutOfBounds(currentRow,currentCol+1,noOfRows,noOfCols)) &&

                    (currentPipe.right.contains(pipeMatrix[currentRow ][currentCol+1])) &&
                    (countMatrix[currentRow ][currentCol+1] < countMatrix[currentRow][currentCol] - 1)) {
                Pipe[] p = createPipes();
                Pipe nextPipe =  p[pipeMatrix[currentRow][currentCol +1]];
                nextPipe.row = currentRow;
                nextPipe.col = currentCol+1;
                queue.add(nextPipe);
                countMatrix[currentRow][currentCol+1]=countMatrix[currentRow][currentCol] - 1;

            }

            //down

            if ((currentPipe.down != null) &&
                    !(isOutOfBounds(currentRow + 1,currentCol,noOfRows,noOfCols)) &&
                    (currentPipe.down.contains(pipeMatrix[currentRow + 1][currentCol])) &&
                    (countMatrix[currentRow + 1][currentCol] < countMatrix[currentRow][currentCol] - 1)) {
                Pipe[] p = createPipes();
                Pipe nextPipe =  p[pipeMatrix[currentRow+1][currentCol]];
                nextPipe.row = currentRow+1;
                nextPipe.col = currentCol;
                queue.add(nextPipe);
                countMatrix[currentRow+1][currentCol]=countMatrix[currentRow][currentCol] - 1;

            }

            //left

            if ((currentPipe.left != null) &&
                    !(isOutOfBounds(currentRow ,currentCol-1,noOfRows,noOfCols)) &&

                    (currentPipe.left.contains(pipeMatrix[currentRow ][currentCol-1])) &&
                    (countMatrix[currentRow][currentCol-1] < countMatrix[currentRow][currentCol] - 1)) {
                Pipe[] p = createPipes();
                Pipe nextPipe =  p[pipeMatrix[currentRow][currentCol-1]];
                nextPipe.row = currentRow;
                nextPipe.col = currentCol-1;
                queue.add(nextPipe);
                countMatrix[currentRow][currentCol-1]=countMatrix[currentRow][currentCol] - 1;

            }


        }
        printMatrix(pipeMatrix,noOfRows,noOfCols);
        printMatrix(countMatrix,noOfRows,noOfCols);

    }

    public static void printMatrix(int[][] matrix, int noOfRows, int noOfCols) {

        System.out.println();
        System.out.println();

        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfCols; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }
    }

    public static boolean isOutOfBounds(int row,int col,int noOfRows,int noOfCols){

        return !((row>=0)&&(row < noOfRows)&&(col >=0)&&(col < noOfCols) );

    }

    public static Pipe[] createPipes() {

        Pipe[] pipeArr = new Pipe[8];
        HashSet<Integer> up = new HashSet<>();
        HashSet<Integer> right = new HashSet<>();
        HashSet<Integer> down = new HashSet<>();
        HashSet<Integer> left = new HashSet<>();

        up.add(1);
        up.add(2);
        up.add(5);
        up.add(6);

        right.add(3);
        right.add(1);
        right.add(6);
        right.add(7);

        down.add(1);
        down.add(2);
        down.add(4);
        down.add(7);

        left.add(1);
        left.add(3);
        left.add(4);
        left.add(5);

        pipeArr[1] = new Pipe(up,
                right,
                down,
                left);

        pipeArr[2] = new Pipe(up,
                null,
                down,
                null);
        pipeArr[3] = new Pipe(null,
                right,
                null,
                left);
        pipeArr[4] = new Pipe(up,
                right,
                null,
                null);
        pipeArr[5] = new Pipe(null,
                right,
                down,
                null);
        pipeArr[6] = new Pipe(null,
                null,
                down,
                left);
        pipeArr[7] = new Pipe(up,
                null,
                null,
                left);

        return pipeArr;

    }
}
