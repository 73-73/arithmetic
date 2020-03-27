package mycode;

/**
 * 给定一个整型矩阵matrix，请按照转圈的方式打印它。
 * 例如：
 * 1   2   3   4
 * 5   6   7   8
 * 9  10  11   12
 * 13 14  15   16
 * 打印结果为：1，2，3，4，8，12，16，15，14，13，9，
 * 5，6，7，11， 10
 *
 * @author pan
 * @create 2020-03-12-16:03
 */
public class PrintMatrixSpiralOrder {
    public static void spiralPrint(int[][] matrix) {
        int row1 = 0, column1 = 0;
        int row2 = matrix.length - 1, column2 = matrix[0].length - 1;
        while (row1 <= row2 && column1 <= column2) {
            printEdge(matrix, row1++, column1++, row2--, column2--);
        }
    }

    public static void printEdge(int[][] matrix, int row1, int column1, int row2, int column2) {
        //判断这个矩形的形状
        //一行
        if (row1 == row2) {
            for (int i = column1; i <= column2; i++) {
                System.out.print(matrix[row1][i] + " ");
            }
        }
        //一列
        else if (column1 == column2) {
            for (int i = row1; i <= row2; i++) {
                System.out.print(matrix[i][column1] + " ");
            }
        }
        /**
         * 比如：1 2 3
         *      4 5 6
         *      7 8 9
         *   这里负责打印 1 2 3 6 9 8 7 4
         */
        else {
            int curR = row1;
            int curC = column1;
            //打印1 2 部分
            while (curC < column2) {
                System.out.print(matrix[curR][curC++] + " ");
            }
            //打印 3 6 部分
            while (curR < row2) {
                System.out.print(matrix[curR++][curC] + " ");
            }
            //打印 9 8 部分
            while (column1 < curC) {
                System.out.print(matrix[curR][curC--] + " ");
            }
            //打印 7 4 部分
            while (column1 < curR) {
                System.out.print(matrix[curR--][curC] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
//        int[][] matrix = {{1}, {2}, {3}, {4}};
//        int[][] matrix = {{}};
        spiralPrint(matrix);
        System.out.println();
        System.out.println("1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 ");
    }
}
