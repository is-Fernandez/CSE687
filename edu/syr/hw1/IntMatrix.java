package edu.syr.hw1;

public class IntMatrix {
    private int[] data;
    private int cols;
    public IntMatrix(int r, int c) {
//TODO
        if (r <= 0 || c <= 0) {
            throw new IllegalArgumentException("Rows and columns must be positive integers.");
        }
        cols = c;
        data = new int[r * c];
    }
    public int get(int r, int c) {
//TODO
        if (r < 0 || c < 0 || r * cols + c >= data.length) {
            throw new IndexOutOfBoundsException("Invalid row or column index.");
        }
        return data[r * cols + c];
    }
    public void set(int r, int c, int val) {
//TODO
        if (r < 0 || c < 0 || r * cols + c >= data.length) {
            throw new IndexOutOfBoundsException("Invalid row or column index.");
        }
        data[r * cols + c] = val;
    }
}

