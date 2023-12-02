package utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtility {

    public FileUtility() {
        openFile();
    }

    private void openFile() {
        ArrayList<Integer> lineNumbers;
        BufferedReader reader;
        int totalValue = 0;

        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\jacki\\Desktop\\Apps\\AdventOfCode\\day1\\day1\\src\\main\\resources\\assets\\input.txt"));
            String line = reader.readLine();

            while (line != null) {
                lineNumbers = new ArrayList<>();
                for (int index = 0; index < line.length(); index++) {
                    boolean isInt = checkIfInt(line.charAt(index));
                    if (isInt) {
                        Integer intToAdd = Character.getNumericValue(line.charAt(index));
                        lineNumbers.add(intToAdd);
                    }
                }
                // next line
                int[] firstAndLast = getFirstAndLast(lineNumbers);
                totalValue += Integer.parseInt(firstAndLast[0] + "" + firstAndLast[1]);

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("The sum of all calculated digits is: " + totalValue);
    }

    // Check if index value is integer
    private boolean checkIfInt(Character c) {
        if (Character.isDigit(c))
            return true;
        return false;
    }

    // Grab array of ints and return the first and last integer
    private int[] getFirstAndLast(ArrayList<Integer> numbers) {
        int[] firstAndLast = { 2, 1 };
        int firstIndex = numbers.get(0);
        int lastIndex = numbers.get(numbers.size() - 1);

        firstAndLast = setFirstAndLast(firstIndex, lastIndex);

        return firstAndLast;
    }

    private int[] setFirstAndLast(int firstIndex, int lastIndex) {
        int[] firstAndLast = { firstIndex, lastIndex };

        return firstAndLast;
    }
}
