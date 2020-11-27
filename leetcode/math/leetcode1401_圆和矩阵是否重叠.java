package math;/*
  @Date:2020/11/27 11:16
  @Author:Administrator
*/

import java.util.*;

public class leetcode1401_圆和矩阵是否重叠 {
    //https://www.zhihu.com/question/24251545
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        // 矩阵 中心
        double xcenter=((double) x1+x2)/2;
        double ycenter=((double)y1+y2)/2;

        //将圆心转移到第一象限
        double newX_center=Math.abs(xcenter-x_center);
        double newY_center=Math.abs(ycenter-y_center);
        //求矩形右上角到矩阵中心
        double h_x=x2-xcenter;
        double h_y=y2-ycenter;

        double x=newX_center-h_x<0?0:newX_center-h_x;
        double y=newY_center-h_y<0?0:newY_center-h_y;
        return  (x*x+y*y)<=(radius*radius);
    }

    public static void main(String[] args) {
        new leetcode1401_圆和矩阵是否重叠().checkOverlap(1,0,0,2,-10,3,10);
    }
}
