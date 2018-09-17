package com.tronghoastgmail.baithuchanh2;

public class MatrixEvaluation {
    private float[][] element;
    private int col, row;

    public MatrixEvaluation(int row, int col){
        this.row = row;
        this.col = col;
        this.element = new float[row][col];
    }

    public void putMatrixElements(int i, int j, float value){
        this.element[i][j] = value;
    }

    public float getMatrixElement(int i, int j){
        return element[i][j];
    }
    public MatrixEvaluation addMatrix(MatrixEvaluation matrix){
        MatrixEvaluation mt = new MatrixEvaluation(row, col);
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                mt.putMatrixElements(i,j,this.getMatrixElement(i, j) + matrix.getMatrixElement(i, j));
            }
        }
        return mt;
    }
    public MatrixEvaluation subMatrix(MatrixEvaluation matrix){
        MatrixEvaluation mt = new MatrixEvaluation(row, col);
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                mt.putMatrixElements(i, j,this.getMatrixElement(i, j) - matrix.getMatrixElement(i, j));
            }
        }
        return mt;
    }
}