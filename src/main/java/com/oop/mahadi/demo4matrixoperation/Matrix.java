package com.oop.mahadi.demo4matrixoperation;

public class Matrix {


    public int[][] vals;

    public Matrix(int[][] val) {
        this.vals = val;
    }

    public Matrix(int row, int col) {
        this.vals = new int[row][col];

        for(int i = 0; i < this.vals.length; i++) {
            for(int j = 0; j < this.vals[i].length; j++) {
                this.vals[i][j] = 0;
            }
        }

    }

    public Matrix() {
    }
    public Matrix sub(Matrix mk){

        Matrix m=new Matrix(vals.length,mk.vals[0].length);
        if( (vals.length==mk.vals.length )&&(vals[0].length==mk.vals[0].length)){
            for(int i = 0; i < this.vals.length; i++) {
                for(int j = 0; j < mk.vals[i].length; j++) {
                    m.vals[i][j] = vals[i][j]-mk.vals[i][j];
                }
            }
        }
        return m;


    }

    public Matrix add(Matrix mk){

        Matrix m=new Matrix(vals.length,mk.vals[0].length);
        if( (vals.length==mk.vals.length )&&(vals[0].length==mk.vals[0].length)){
            for(int i = 0; i < this.vals.length; i++) {
                for(int j = 0; j < mk.vals[i].length; j++) {
                    m.vals[i][j] = vals[i][j]+mk.vals[i][j];
                }
            }
        }
        return m;


    }
    public Matrix  tran(){
        Matrix mk= new Matrix(vals[0].length,vals.length);

        for (int i = 0; i < vals.length; i++) {

            for (int j = 0; j < vals[i].length; j++) {

                mk.vals[j][i]=vals[i][j];
            }

        }

        return mk;




    }

    @Override
    public String toString() {

        String s="";


        for (int i = 0; i < vals.length; i++) {

            for (int j = 0; j < vals[i].length; j++) {

                s+=vals[i][j] + " ";
            }
            s+="\n";
        }

        return  s;

    }
    public Matrix(double[][] vals) {
        int rows = vals.length;
        int cols = vals[0].length;
        this.vals = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.vals[i][j] = (int) vals[i][j];
            }
        }
    }
    private void swapRows(double[][] matrix, int row1, int row2) {
        double[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }

    // Getters for matrix dimensions
    public int getRows() {
        return this.vals.length;
    }

    public int getColumns() {
        return this.vals[0].length;
    }

    public Matrix inv() throws IllegalArgumentException {
        int n = this.vals.length;
        double[][] matrix = new double[n][2 * n];
        double[][] inverse = new double[n][n];

        // Convert int[][] to augmented double[][] (initializing identity matrix)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (double) this.vals[i][j];
                matrix[i][j + n] = (i == j) ? 1.0 : 0.0;
            }
        }

        // Perform Gaussian Elimination
        for (int i = 0; i < n; i++) {
            // Check for zero pivot element
            if (matrix[i][i] == 0) {
                boolean swapped = false;
                for (int k = i + 1; k < n; k++) {
                    if (matrix[k][i] != 0) {
                        swapRows(matrix, i, k);
                        swapped = true;
                        break;
                    }
                }
                if (!swapped) {
                    throw new IllegalArgumentException("Matrix is singular and cannot be inverted.");
                }
            }

            // Normalize the pivot row
            double pivot = matrix[i][i];
            for (int j = 0; j < 2 * n; j++) {
                matrix[i][j] /= pivot;
            }

            // Eliminate the current column in other rows
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    double ratio = matrix[j][i];
                    for (int k = 0; k < 2 * n; k++) {
                        matrix[j][k] -= ratio * matrix[i][k];
                    }
                }
            }
        }

        // Extract the inverse matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverse[i][j] = matrix[i][j + n];
            }
        }

        return new Matrix(inverse);
    }




}









