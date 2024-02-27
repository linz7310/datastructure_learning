package com.lin.algorithm.recursion_multi;

/**
 * ClassName E03PascalTriangle
 * Package com.lin.algorithm.recursion_multi
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/2/22
 */
public class E03PascalTriangle {
    public static int element1(int i,int j){
        if (j==0||i==j){
            return 1;
        }
        return element1(i-1,j-1)+element1(i-1,j);
    }
    private static void printSpace(int n, int i) {
        int num = (n - 1 - i) * 2;
        for (int j = 0; j < num; j++) {
            System.out.print(" ");
        }
    }

    public static void print1(int n) {
        for (int i = 0; i < n; i++) {
            printSpace(n, i);
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", element1(i, j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        System.out.println(element(4, 2));
        print2(6);
    }

    /**
     * <h3>improved1 - two dimensional array memory</h3>
     *
     * @param triangle two-dimensional array
     * @param i        Row Coordinates
     * @param j        Column Coordinates
     * @return element value
     */
    public static int element2(int[][] triangle,int i, int j){
        if (triangle[i][j]>0){
            return triangle[i][j];
        }
        if (j==0||i==j){
            triangle[i][j] =1;
            return triangle[i][j];
        }
        triangle[i][j]=element2(triangle,i-1,j-1)+element2(triangle,i-1,j);
        return triangle[i][j];
    }
    public static void print2(int n){
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            triangle[i]=new int[i+1];
            for (int j = 0; j <=i ; j++) {
                System.out.printf("%-4d", element2(triangle,i, j));
            }
            System.out.println();

        }
    }
    private static void createRow(int[]row,int i){
        if (i==0){
            row[0]=1;
            return ;
        }
        for( int j =i;j>0;j--){
            row[j]=row[j]+row[j-1];
        }
    }
    public static void print3(int n) {
        int[] row = new int[n];
        for (int i = 0; i < n; i++) { // 行
            createRow(row, i);
//            printSpace(n, i);
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", row[j]);
            }
            System.out.println();
        }
    }

}
