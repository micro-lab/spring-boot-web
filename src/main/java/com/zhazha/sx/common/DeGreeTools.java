package com.zhazha.sx.common;

public class DeGreeTools {
    private static double EARTH_RADIUS = 6370996.81;//地球半径

    public static void main(String[] args) {
        // 先经度，后维度
        System.out.println(getRange(89.877666, 81.167646, 91.579416, 81.132152));
    }

    /**
     * @param L1 第一个位置的经度
     * @param R1 第一个位置的纬度
     * @param L2 第二个位置的经度
     * @param R2 第二个位置的纬度
     * @return 两个位置间的距离(单位:m)
     */
    public static double getRange(double L1, double R1, double L2, double R2) {
        double l1 = degreeToRad(_getLoop(L1, -180, 180));
        double r1 = degreeToRad(_getRange(R1, -74, 74));
        double l2 = degreeToRad(_getLoop(L2, -180, 180));
        double r2 = degreeToRad(_getRange(R2, -74, 74));
        return EARTH_RADIUS
                * Math.acos((Math.sin(r1) * Math.sin(r2) + Math.cos(r1)
                * Math.cos(r2) * Math.cos(l2 - l1)));
    }

    /**
     * 将度转化为弧度
     * @param {degree} Number 度
     * @returns {Number} 弧度
     */
    public static double degreeToRad(double degree) {
        return Math.PI * degree / 180;
    }

    /**
     * 将v值限定在a,b之间，纬度使用
     */
    public static double _getRange(double v, double a, double b) {
        if (a != 0) {
            v = Math.max(v, a);
        }
        if (b != 0) {
            v = Math.min(v, b);
        }
        return v;
    }

    /**
     * 将v值限定在a,b之间，经度使用
     */
    public static double _getLoop(double v, double a, double b) {
        while (v > b) {
            v -= b - a;
        }
        while (v < a) {
            v += b - a;
        }
        return v;
    }

}
