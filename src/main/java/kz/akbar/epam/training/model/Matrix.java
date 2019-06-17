package kz.akbar.epam.training.model;

import java.util.Arrays;

public class Matrix {
    private int size;
    private int[][] matrix;

    public Matrix(int size) {
        this.size = size;
        matrix = new int[size][size];
    }

    public int getSize() {
        return size;
    }

    public void writeLine(int lineNum, String[] stringNums) {
        for (int i = 0; i < stringNums.length; i++) {
            matrix[lineNum][i] = Integer.parseInt(stringNums[i]);
        }
    }

    public void writeNumber(int number, int x, int y) {
        matrix[x][y] = number;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    @Override
    public String toString() {
        StringBuilder matrixBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            matrixBuilder.append(Arrays.toString(matrix[i]) + '\n');
        }
        return matrixBuilder.toString();
    }
}
