package kz.akbar.epam.training.service;

import kz.akbar.epam.training.model.Matrix;
import org.apache.log4j.Logger;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class MatrixMultiDiagonalFiller extends Thread {
    ReentrantLock lock = new ReentrantLock();
    private static final Logger LOGGER = Logger.getLogger(MatrixMultiDiagonalFiller.currentThread().getName());
    private final int number = new Random().nextInt(100);
    private String name;
    private Matrix matrix;
    private int cellNumber;

    public MatrixMultiDiagonalFiller(String name, Matrix matrix, int cellNumber) {
        super(name);
        this.name = name;
        this.matrix = matrix;
        this.cellNumber = cellNumber;
    }

    private void fillDiagonal(int cell) {
        LOGGER.info(name + " started work for " + cell + " with " + number);
        for (int i = 0; i <= cell; i++) {
            if (cell != matrix.getSize()) {
                matrix.writeNumber(number, i, cell - i);
            }
        }
        LOGGER.info(name + " finished work for " + cell + " with " + number);
    }

    public void run() {
            fillDiagonal(cellNumber);
            fillDiagonal(cellNumber + matrix.getSize() / 2);

    }
}
