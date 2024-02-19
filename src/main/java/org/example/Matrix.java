package org.example;

public class Matrix {
    private ComplexNumber[][] matrix;

    public static void main(String[] args) throws Exception {
        Matrix matrix1 = new Matrix();
        matrix1.matrix = new ComplexNumber[2][2];
        matrix1.matrix[0][0] = new ComplexNumber(1, 0);
        matrix1.matrix[0][1] = new ComplexNumber(2, 0);
        matrix1.matrix[1][0] = new ComplexNumber(3, 0);
        matrix1.matrix[1][1] = new ComplexNumber(4, 0);

        Matrix matrix2 = new Matrix();
        matrix2.matrix = new ComplexNumber[2][2];
        matrix2.matrix[0][0] = new ComplexNumber(5, 0);
        matrix2.matrix[0][1] = new ComplexNumber(6, 0);
        matrix2.matrix[1][0] = new ComplexNumber(7, 0);
        matrix2.matrix[1][1] = new ComplexNumber(8, 0);


        Matrix res = matrix1.multiply(matrix2);
        System.out.println(res);
    }

    public Matrix() {
    }

    public Matrix(ComplexNumber[][] matrix) {
        this.matrix = matrix;
    }

    public Matrix add(ComplexNumber[][] matrix) throws Exception {
        if (this.matrix.length != matrix.length || this.matrix[0].length != matrix[0].length)
            throw new Exception("Matrix sizes are incompatible");

        int n = matrix.length, m = matrix[0].length;
        ComplexNumber[][] res = new ComplexNumber[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = this.matrix[i][j].add(matrix[i][j]);
            }
        }
        return new Matrix(res);
    }

    public Matrix multiply(Matrix matrix) throws Exception {

        if (this.matrix[0].length != matrix.matrix.length)
            throw new Exception("Matrix sizes are incompatible");

        int n = this.matrix.length, m = matrix.matrix[0].length;
        ComplexNumber[][] res = new ComplexNumber[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                ComplexNumber number = new ComplexNumber();

                for (int k = 0; k < n; k++) {
                    number = number.add(this.matrix[i][k].multiply(matrix.matrix[k][j]));
                }

                res[i][j] = number;
            }
        }

        return new Matrix(res);
    }
    public Matrix multiply(ComplexNumber number){
        int n = matrix.length, m = matrix[0].length;

        ComplexNumber[][] res = new ComplexNumber[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = matrix[i][j].multiply(number);
            }
        }

        return new Matrix(res);
    }
    public Matrix multiply(int number){
        ComplexNumber complexNumber = new ComplexNumber(number, 0);
        return multiply(complexNumber);
    }


    public Matrix transpose(){
        int n = matrix[0].length, m = matrix.length;
        ComplexNumber[][] res = new ComplexNumber[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = matrix[j][i];
            }
        }

        return new Matrix(res);
    }
    /*public ComplexNumber getDeterminant(Matrix matrix){

        ComplexNumber res = new ComplexNumber();
        for (int i = 0; i < matrix.matrix.length; i++) {
            res.add(
                    matrix.matrix[i][0].multiply(new ComplexNumber(i % 2 == 0 ? 1 : -1))
            );
        }
        return res;
    }*/

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        int n = this.matrix.length, m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                s.append(matrix[i][j]).append(" ");
            }
            s.append("\n");
        }

        return s.toString();
    }
}
