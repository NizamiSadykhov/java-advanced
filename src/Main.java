import exeption.MyArrayDataException;
import exeption.MyArraySizeException;

import java.util.Arrays;

public class Main {
    private static final int SIZE = 4;

    public static void main(String[] args) {

        String[][] arrayWithSizeProblem = {
                {"1", "2", "3"},
                {"5", "6", "7"},
                {"9", "10"},
                {"13", "14"}
        };

        try {
            int[][] withSizeProblem = toInt2DArray(arrayWithSizeProblem);

            for (int[] numbers : withSizeProblem)
                System.out.print(Arrays.toString(numbers) + " ");

        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        String[][] arrayWithDataProblem = {
                {"1", "2", "3", "4"},
                {"5", "привет", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int[][] result = toInt2DArray(arrayWithDataProblem);

            for (int[] numbers : result)
                System.out.print(Arrays.toString(numbers) + " ");

        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        String[][] goodArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int[][] result = toInt2DArray(goodArray);

            for (int[] numbers : result)
                System.out.print(Arrays.toString(numbers) + " ");

        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int[][] toInt2DArray(String[][] str2DArray) throws MyArraySizeException, MyArrayDataException {

        if (str2DArray.length != SIZE)
            throw new MyArraySizeException();

        for (String[] strArr : str2DArray)
            if (strArr.length != SIZE)
                throw new MyArraySizeException();

        int[][] int2DArray = new int[SIZE][SIZE];

        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                try {
                    int2DArray[y][x] = Integer.parseInt(str2DArray[y][x]);
                } catch (NumberFormatException exception) {
                    throw new MyArrayDataException(y, x);
                }
            }
        }

        return int2DArray;
    }
}
