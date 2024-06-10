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
    public Matrix tran(){
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




}









