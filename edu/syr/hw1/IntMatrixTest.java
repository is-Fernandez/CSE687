package edu.syr.hw1;

public class IntMatrixTest {
    public static void main(String[] args) {
        IntMatrix m1 = new IntMatrix(2, 3);

        m1.set(0, 0, 1);
        m1.set(0, 1, 2);
        m1.set(0, 2, 3);

        try {
            m1.set(0, 3, 4); // should throw exception
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught expected exception for invalid cell");
        }

        m1.set(1, 0, 4);
        m1.set(1, 1, 5);
        m1.set(1, 2, 6);

        // Print matrix contents to verify
        for (int r = 0; r < 2; r++) {
            for (int c = 0; c < 3; c++) {
                System.out.print(m1.get(r, c) + " ");
            }
            System.out.println();
        }
    }
}