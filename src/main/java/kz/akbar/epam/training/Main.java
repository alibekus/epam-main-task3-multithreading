package kz.akbar.epam.training;

import kz.akbar.epam.training.model.Matrix;
import kz.akbar.epam.training.service.MatrixMultiDiagonalFiller;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final int THREAD_COUNT = 5;


    public static void main(String[] args) throws IOException {
        int lineNum = 0;
        Matrix matrix;
        FileReader reader = new FileReader("resources/matrix.txt");
        try (BufferedReader bufferedReader =
                     new BufferedReader(reader)) {
            String numberLine = bufferedReader.readLine();
            String[] stringNums = numberLine.split(" ");
            matrix = new Matrix(stringNums.length);
            matrix.writeLine(lineNum++, stringNums);
            while ((numberLine = bufferedReader.readLine()) != null) {
                matrix.writeLine(lineNum++, numberLine.split(" "));
            }
        }
        LOGGER.info(matrix.toString());
        LOGGER.info("Filling main diagonal of the matrix by multithreading...\n");
        new MatrixMultiDiagonalFiller("Thread1", matrix, 1).start();
        new MatrixMultiDiagonalFiller("Thread2", matrix, 2).start();
        new MatrixMultiDiagonalFiller("Thread3", matrix, 3).start();
        new MatrixMultiDiagonalFiller("Thread4", matrix, 4).start();
        new MatrixMultiDiagonalFiller("Thread5", matrix, 5).start();
        LOGGER.info("The matrix after diagonal multithreading:");
        LOGGER.info('\n' + matrix.toString());
    }
}
