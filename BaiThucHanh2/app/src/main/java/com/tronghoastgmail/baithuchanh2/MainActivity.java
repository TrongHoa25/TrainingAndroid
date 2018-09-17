package com.tronghoastgmail.baithuchanh2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {
    EditText edtcol, edtrow;
    Button btninitialaze, btncaculate;
    GridLayout matrix1, matrix2, matrixres;
    int col = 0, row = 0;
    MatrixEvaluation matrixe1, matrixe2, matrixeres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addAction();
    }
    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btninitialize :
                    btinitialize_onlcick();
                    break;
                case R.id.btncalculate :
                    btncaculate_onlcick();
                    break;
                default:
            }
        }
    };

    private void btinitialize_onlcick() {
        matrix1.removeAllViews();
        matrix2.removeAllViews();
        matrixres.removeAllViews();
        col = Integer.parseInt(edtcol.getText().toString().trim());
        row = Integer.parseInt(edtrow.getText().toString().trim());
        matrix1.setColumnCount(col);
        matrix2.setColumnCount(col);
        matrix1.setRowCount(row);
        matrix2.setRowCount(row);
        matrixres.setRowCount(row);
        matrixres.setColumnCount(col);
        for (int i = 0; i < row * col ; i++){
            EditText edt1 = new EditText(this);
            EditText edt2 = new EditText(this);
            EditText edt3 = new EditText(this);
            edt1.setWidth(60);
            edt1.setInputType(InputType.TYPE_CLASS_NUMBER);
            edt2.setInputType(InputType.TYPE_CLASS_NUMBER);
            edt2.setWidth(60);
            edt3.setWidth(60);
            edt3.setTextColor(Color.RED);
            edt3.setEnabled(false);
            matrix1.addView(edt1, i);
            matrix2.addView(edt2, i);
            matrixres.addView(edt3, i);
            btninitialaze.setEnabled(false);
        }
    }

    private void btncaculate_onlcick() {
        matrixe1 = new MatrixEvaluation(row,col);
        matrixe2 = new MatrixEvaluation(row,col);
        matrixeres = new MatrixEvaluation(row,col);
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col ; j++){
                matrixe1.putMatrixElements(i , j, Float.parseFloat(((EditText)
                        matrix1.getChildAt(col * i + j)).getText().toString().trim()));
                matrixe2.putMatrixElements(i,j,Float.parseFloat(((EditText)
                        matrix2.getChildAt(col * i + j)).getText().toString().trim()));
            }
        }
        matrixeres = matrixe1.addMatrix(matrixe2);
       for (int i = 0; i < row; i++){
           for (int j = 0; j < col ; j ++){
               ((EditText) matrixres.getChildAt(col * i + j)).setText(""+ matrixeres.getMatrixElement(i,j));
           }
       }
       btninitialaze.setEnabled(true);
    }

    private void addAction() {
        matrix1 = findViewById(R.id.matrix1);
        matrix2 = findViewById(R.id.matrix2);
        matrixres = findViewById(R.id.matrixres);
        edtcol = findViewById(R.id.edtcol);
        edtrow = findViewById(R.id.edtrow);
        btninitialaze = findViewById(R.id.btninitialize);
        btncaculate = findViewById(R.id.btncalculate);
        btncaculate.setOnClickListener(click);
        btninitialaze.setOnClickListener(click);
    }
}
