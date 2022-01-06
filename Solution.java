package com.burk.arr;

import java.util.*;

class Points implements Comparable<Points>{
    int x;
    double y;

    @Override
    public int compareTo(Points p) {
        return Integer.compare(this.x,p.x);
    }
}

public class Solution {

    public int NumOfPoints = 100;
    public int[] IntervalArr = new int[NumOfPoints];
    public int[] Index = new int[NumOfPoints];
    public Points[] points = new Points[NumOfPoints];

    public double[][] error = new double[NumOfPoints][NumOfPoints];


    public double[] OPT = new double[NumOfPoints];
    public int penalty = 5;


    public void InitAllPoints(){
        Random rand = new Random();
        // 第一个point置为(0,0)
//        points[0] = new Points();
//        points[0].x = 0;
//        points[0].y = 0;
        for(int i = 0; i < NumOfPoints; i++){
            points[i] = new Points();
            points[i].x = rand.nextInt(500);
            points[i].y = rand.nextDouble() * 5;
        }
        Arrays.sort(points);
    }

    public void PreComputeErrorArr(){
        for(int i = 0; i < NumOfPoints; i++){
            int S1 = 0;
            int S2 = 0;
            for(int j = i; j < NumOfPoints; j++){
                S1 += points[j].y * points[j].y;
                S2 += points[j].y;
                error[i][j] = S1 - (S2*S2)/(j-i+1);

            }
        }
    }

    public void ComputeOPT(){

        long startTime = System.currentTimeMillis();
        OPT[0] = 0;
        for(int j = 1; j < NumOfPoints; j++){
            double Min = Double.MAX_VALUE;
            int MinIndex = 0;
            for(int i = 1; i <= j; i++){
                double opt = error[i][j] + OPT[i-1] + penalty;

                if(opt < Min){
                    Min = opt;
                    MinIndex = i;
                }
            }
            OPT[j] = Min;
            Index[j] = MinIndex;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("This algorithm spend " + (endTime - startTime) + "ms.");
    }


    public void ComputeIntervals() {
        for(int i = NumOfPoints - 1; i >= 1; i--) {
            int interv = Index[i];
            if(i != interv) {
                IntervalArr[interv] = i;
            }else {
                IntervalArr[--interv] = i;
            }
            i = interv;
        }
    }

    public void PrintIntervals() {
        int Line = 0;
        for (int i = 0; i <= NumOfPoints - 1; i++) {
            int j = IntervalArr[i];
            if (j != 0) {
                if(i!=0 && Line == 0) {

                    System.out.println("Interval " + (++Line) +" is "+ ": [" + points[0].x + "," + points[i-1].x + "] " +
                            "  Point index is points[0] to points[" + (i-1) + "]");
                    System.out.println("Interval " + (++Line) +" is " +": [" + points[i].x+ "," + points[j].x + "] " +
                            "  Point index is points[" + i + "] to points[" + j + "]");
                }
                else {
                    System.out.println("Interval " + (++Line) +" is "+ ": [" + points[i].x + "," + points[j].x + "] " +
                            "  Point index is points[" + i + "] to points[" + j + "]");
                }

            }
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();

        s.InitAllPoints();
        s.PreComputeErrorArr();
        s.ComputeOPT();
        s.ComputeIntervals();
        s.PrintIntervals();

        //打印OPT[]
//        System.out.print("OPT[]: "+ "  ");
//        for(int i = 0; i < s.NumOfPoints; i++){
//            System.out.print(s.OPT[i] + "  ");
//        }
//        System.out.println();
//
//        // 打印Index[]
//        System.out.print("Index[]: "+ "  ");
//        for(int i = 1; i <= s.NumOfPoints; i++){
//            System.out.print(s.Index[i]+ "  ");
//        }
//        System.out.println();
//
//        // 打印所有点的x坐标
//        System.out.print("x: "+ "  ");
//        for(int i = 1; i < s.NumOfPoints; i++){
//            System.out.print(s.points[i].x +  " ");
//        }
//        System.out.println();

    }
}







